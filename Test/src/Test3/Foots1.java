package Test3;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Foots1 {

	private JFrame frame;

	int field = 400; // 발판 높이


	List<String> fieldStr = new ArrayList<>(); // 스트링으로 된 필드배열을 저장한다

	List<List> fieldList = new ArrayList<>(); //  발판 리스트를 담는 리스트

	

	int count = 0; // 발판 확인 변수

	int foot = 0;

	int range = 0; // 캐릭터가 밟는 발판 범위

	int nowField = field; // 캐릭터높이에 따른 발판위치 조정 변수

	ImageIcon landIc = new ImageIcon("img/land1.png");
	Image landimg = landIc.getImage();

	// substring으로 발판 정보 검색
	static int getGround(String ground, int index) {
		return Integer.parseInt(ground.substring(index, index + 1));
	}

	Image buffImage; // 더블버퍼 관련
	Graphics buffg;

	ImageIcon ic = new ImageIcon("img/c1run.gif");
	Image img = ic.getImage();

	int fallOverY = ic.getImage().getHeight(null); // 기본 이미지 높이(나중에 사각형으로 수정요망)

	boolean downKeyOn = false;

	ImageIcon icJump = new ImageIcon("img/c1jump.gif");
	ImageIcon icDoubleJump = new ImageIcon("img/c1doubleJump.gif");
	ImageIcon icfall = new ImageIcon("img/c1fall.png");
	ImageIcon icfallOver = new ImageIcon("img/c1fallOver.png");
	ImageIcon icnap = new ImageIcon("img/c1nap.gif");

	ImageIcon backIc = new ImageIcon("img/back1.png");
	Image back = backIc.getImage();
	Image back1 = backIc.getImage();
	int backX = 0;
	int back1X = back.getWidth(null);

	int imgY = 0; // 이미지가 시작하는 좌표

	boolean fall = false; // 현재 떨어지는지 확인
	boolean jump = false; // 현재 점프중인지 확인

	int doubleJump = 0; // 점프 카운트 (2가되면 더블점프 상태이다)

	// 시간 가져오기
	static long getTime() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Foots1 window = new Foots1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	class MyPanel extends JPanel {
		public MyPanel() {

			setFocusable(true);
			
			// 맵에 펼쳐질 발판의 모습이다. (0이면 허공, 1이면 발판)
			// 배열을 위에서 부터 저장
			fieldStr.add("0000000000000000000000001111111111111110000000000000000000000000000000000000000000000000000");
			fieldStr.add("0000000000000000111111111000000000000001000000000000000000000000000000000000000000000000000");
			fieldStr.add("0000000000001111000000000111111000000000100000000011111111111111111111111000000000000000000");
			fieldStr.add("0000011111110000000000000000000001111100111111111100000000000000000000000000000000000000000");
			fieldStr.add("1111100000000111111111111111110000000000000000000000000000000000000000000000000000000000000");
			
			Collections.reverse(fieldStr);  // 배열을 위에서 부터 저장했기 때문에 뒤집어서 바닥이 0번이 되도록 함

			
			for (int i = 0; i < fieldStr.size(); i++) {  // fieldStr의 길이 (현재 5개)만큼 반복한다.

				int tempY = 400 - 50 * i; // 바닥은 400이며 1계단 올라갈 때마다 Y값이 50씩 줄어든다.
				
				List<Foot> tempList = new ArrayList<>(); // 임시 리스트 (for문 안에서 선언했기 때문에 1회전할때마다 새로 선언 및 초기화된다.)

				for (int j = 0; j < fieldStr.get(i).length(); j++) { // fieldStr에 저장된 문자열의 길이만큼 반복한다.
					
					int tempX = landimg.getWidth(null) * j; // 발판의 X값은 0부터 발판의 넓이만큼 늘어난다.
					
					if (getGround(fieldStr.get(i), j) == 1) { // getGround함수는 문자열 순서대로 1인지 0인지 판별한다.
						
						// 1이라면 발판 추가 0이라면 공백
						tempList.add(new Foot(landimg, tempX, tempY, landimg.getWidth(null), landimg.getHeight(null)));
					}
				}
				
				// 위에서 선언해둔 Foot 임시리스트를 전역공간에 생성해둔 리스트에 저장한다.
				fieldList.add(tempList);
			}
			

			new Thread(new Runnable() { // 리페인트 전용 쓰레드

				@Override
				public void run() {
					while (true) {
						repaint();
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();

			new Thread(new Runnable() { // 배경 및 발판 좌표 이동 쓰레드

				@Override
				public void run() {
					while (true) {
						foot = imgY + fallOverY; // foot

						if (backX < -(back.getWidth(null))) {
							backX = back.getWidth(null);
						}
						if (back1X < -(back.getWidth(null))) {
							back1X = back.getWidth(null);
						}

						backX--;
						back1X--;
						
						
						for (int i = 0; i < fieldList.size(); i++) { // fieldList의 사이즈만큼 (현재 5개)

							for (int j = 0; j < fieldList.get(i).size(); j++) { // fieldList.get(i)의 사이즈 만큼 (층별 발판의 개수만큼)
								
								// (Foot)을 캐스팅 해주지 않으면 오류가나서 추가함.
								Foot f = (Foot)fieldList.get(i).get(j); //개별 발판을 불러온다.
								
								f.setX(f.getX() - 4); // 발판의 X값을 -4해준다.
							}
						}
						
						
						range = (int) (landimg.getWidth(null) * 1.3); // 캐릭터가 서있을 수 있는 위치 ( 나중에 조절해야됨)
						
						List<Integer> countList = new ArrayList<>(); // 쓰레드 안에 임시적으로 선언한 리스트
						
						for (int i = 0; i < fieldList.size(); i++) { // fieldList의 사이즈만큼 (현재 5개)

							for (int j = 0; j < fieldList.get(i).size(); j++) { // fieldList.get(i)의 사이즈 만큼 (층별 발판의 개수만큼)
								
								count = 0; // count를 0으로 세팅한다.
								
								Foot f = (Foot)fieldList.get(i).get(j); // 개별 발판을 불러온다.
								
								if (f.getX() >= 0 && f.getX() < range) { // 발판이 캐릭 범위 안이라면
									count = 1; // 카운트 1로 변경하고 브레이크한다.
									break;
								}
							}
							countList.add(count); // 리스트에 count를 추가한다. 만약 1층만 발판이 있다면 [1, 0, 0, 0, 0] 이된다.
						}
						
						int tempField = 2000; // 임시변수에 지옥 위치를 저장한다.
						
						for (int i = countList.size() - 1; i >= 0; i--) { // 맨 위의 발판부터 확인해야하기 때문에 배열끝부터 스캔한다.
							
							int tempY = 400 - 50 * i; // 발판의 높이 맨위의 발판은 400 - 50*4 = 200이된다.
							
							if(countList.get(i) == 1 && foot <= tempY ) { // 해당 높이에 발판이 있고 (1), 발바닥이 높이보다 높거나 같다면!
								
								tempField = tempY; // 임시변수는 tempY가 된다.
								
								break; // 발판을 확인했으니 포문을 탈출한다.
							}
							
						}
						
						nowField = tempField; // 전역공간의 nowField에 tempField를 저장해주자.(맨위에 발판이 있었고 조건이 맞다면 200)
						

						System.out.println(nowField);
						

						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();

			// 낙하쓰레드
			new Thread(new Runnable() {

		@Override
		public void run() {
			while (true) {

				// 발바닥 위치는 이미지의 Y위치 + 이미지의 높이 이다.

				// 발바닥이 발판보다 위에 있으면 작동
				if (foot < nowField && !jump && !fall) { // 공중에 있으며 점프중이지 않고 떨어지는 중이 아닐 때 작동
					fall = true; // 떨어지는 중으로 전환
					System.out.println("낙하");

					if (doubleJump == 2) {
						img = icfall.getImage();
					}

					long t1 = getTime(); // 현재시간을 가져온다
					long t2;
					int set = 1; // 처음 낙하량 (0~10) 까지 테스트해보자
					while (foot < nowField) { // 발이 발판에 닿기 전까지 반복
						t2 = getTime() - t1; // 지금 시간에서 t1을 뺀다
						int fallY = set + (int) ((t2) / 40); // 낙하량을 늘린다.

						if (foot + fallY >= nowField) { // 발바닥+낙하량이 발판보다 낮다면 낙하량을 조정한다.
							// fall = false;
							fallY = nowField - foot;
						}

						imgY = imgY + fallY; // Y좌표에 낙하량을 더한다

						foot = imgY + fallOverY; // 현재 발바닥 위치를 저장한다

						if (jump) { // 떨어지다가 더블 점프를 하면 낙하중지
							break;
						}

						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
					fall = false;

					if (downKeyOn && !jump && !fall && img != icnap.getImage()) {
						img = icnap.getImage();
					} else if (!downKeyOn && !jump && !fall && img != ic.getImage()) {
						img = ic.getImage();
					}

					if (jump == false) { // 발이 땅에 닿고 점프 중이 아닐 때 더블점프 카운트를 0으로 변경
						doubleJump = 0;
					}

				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}).start();

	addKeyListener(new KeyAdapter() {

				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE && doubleJump < 2) { // 스페이스 키를 누르고 더블점프가 2가 아닐때

						new Thread(new Runnable() {

							@Override
							public void run() {

								doubleJump++; // 점프 횟수 증가

								int nowJump = doubleJump; // 이번이 점프인지 더블점프인지 저장

								jump = true; // 점프중으로 변경

								if (doubleJump == 1) {
									System.out.println("점프");
									img = icJump.getImage();
								} else if (doubleJump == 2) {
									System.out.println("더블점프");
									img = icDoubleJump.getImage();
								}

								// 발바닥 위치는 이미지의 Y위치 + 이미지의 높이 이다.
								int foot = imgY + fallOverY; // 발바닥의 위치 Y좌표+ 이미지의 높이

								long t1 = getTime(); // 현재시간을 가져온다
								long t2;
								int set = 8; // 점프 계수 설정(0~20) 등으로 바꿔보자
								int jumpY = 8; // 1이상으로만 설정하면 된다.(while문 조건 때문)
								while (jumpY > 0) { // 상승 높이가 0일때까지 반복
									t2 = getTime() - t1; // 지금 시간에서 t1을 뺀다
									jumpY = set - (int) ((t2) / 40); // jumpY 를 세팅한다.
									imgY = imgY - jumpY; // Y값을 변경한다.
									foot = imgY + fallOverY; // 발바닥 위치를 저장한다.

									if (nowJump != doubleJump) { // 점프가 한번 더되면 첫번째 점프는 멈춘다
										break;
									}
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}

								if (nowJump == doubleJump) { // 점프가 진짜 끝났을 때를 확인
									jump = false;
								}

							}
						}).start();
					}
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {

						downKeyOn = true;

						if (img != icnap.getImage() && !jump && !fall) {
							img = icnap.getImage();
						}
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {

					if (e.getKeyCode() == KeyEvent.VK_DOWN) {

						downKeyOn = false;

						if (img != ic.getImage() && !jump && !fall) {
							img = ic.getImage();
						}
					}
				}

			});
		}

	@Override
	protected void paintComponent(Graphics g) {

		if (buffg == null) {
			buffImage = createImage(this.getWidth(), this.getHeight());
			if (buffImage == null) {
				System.out.println("더블 버퍼링용 오프 스크린 생성 실패");
			} else {
				buffg = buffImage.getGraphics();
			}
		}

		buffg.drawImage(back, backX, 0, back.getWidth(this) + 10, (int) (back.getHeight(this) * 1.5), null);
		buffg.drawImage(back1, back1X, 0, back.getWidth(this) + 10, (int) (back.getHeight(this) * 1.5), null);
		

		for (int i = 0; i < fieldList.size(); i++) {

			for (int j = 0; j < fieldList.get(i).size(); j++) {

				Foot f = (Foot) fieldList.get(i).get(j); // 개별 발판

				buffg.drawImage(f.getImage(), f.getX(), f.getY(), f.getWidth(), f.getHeight(), null); // 발판을 그려준다

			}
		}

		buffg.drawImage(img, landimg.getWidth(null) / 2, imgY, img.getWidth(null), img.getHeight(null), this);

		g.drawImage(buffImage, 0, 0, this);

	}


	}

	/**
	 * Create the application.
	 */
	public Foots1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

}
