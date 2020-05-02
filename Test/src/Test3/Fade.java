package Test3;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class Fade {

	private JFrame frame;

	int field = 400; // 발판 높이

	// 1이면 발판이 있고 0이면 없다
	String fieldStr = "1111011101100110010101101111000111011111111111111111111111111111111111111111111111111111111";

	List<Foot> fieldList = new ArrayList<>(); // 발판 객체를 담을 리스트

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
	
	Color backFade = new Color(0, 0, 0, 0);
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fade window = new Fade();
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

			for (int i = 0; i < fieldStr.length(); i++) { // fieldStr의 길이 만큼 반복

				int tempX = i * landimg.getWidth(null); // 반복할 때마다 X좌표를 늘인다.

				if (getGround(fieldStr, i) == 1) { // fieldStr로 땅이 있는 위치에만 발판을 설치한다.
					fieldList.add(new Foot(landimg, tempX, 400, landimg.getWidth(null), landimg.getHeight(null)));
				}
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

						for (int i = 0; i < fieldList.size(); i++) {
							fieldList.get(i).setX(fieldList.get(i).getX() - 4);
						}

						range = (int) (landimg.getWidth(null) * 1.3); // 캐릭터가 서있을 수 있는 위치

						for (int i = 0; i < fieldList.size(); i++) { // range안에 발판이 있으면 1 없으면 0
							if (fieldList.get(i).getX() >= 0 && fieldList.get(i).getX() < range) {
								count = 1;
								break;
							} else if (i == fieldList.size() - 1) {
								count = 0;
							}
						}

						if (count == 0) { // count가 0이면 지하로 count가 1이면 캐릭터 높이에 따라 발판위치 지정
							nowField = 2000;
						} else if (count == 1 && foot > field) {
							nowField = 2000;
						} else if (count == 1 && foot < field) {
							nowField = field;
						}

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
									//fall = false;
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
					
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						new Thread(new Runnable() {
							
							@Override
							public void run() {
								for (int i = 0; i < 256; i+=2) {
									backFade = new Color(0, 0, 0, i);
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								for (int i = 255; i >= 0; i-=2) {
									backFade = new Color(0, 0, 0, i);
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							}
						}).start();
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

// 페인트컴포넌트 원본
//		@Override
//		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			for (int i = 0; i < fieldList.size(); i++) {
//				Image tempImg = fieldList.get(i).getImage();
//				int tempX = fieldList.get(i).getX();
//				int tempY = fieldList.get(i).getY();
//				int tempWidth = fieldList.get(i).getWidth();
//				int tempHeight = fieldList.get(i).getHeight();
//				g.drawImage(tempImg, tempX, tempY, tempWidth, tempHeight, null);
//			}
//			
//			g.drawImage(img, landimg.getWidth(null) / 2, imgY, this);
//		}

		// 업데이트 더블버퍼링
		@Override
		public void update(Graphics g) {

			buffg.drawImage(back, backX, 0, back.getWidth(this) + 10, (int) (back.getHeight(this) * 1.5), null);
			buffg.drawImage(back1, back1X, 0, back.getWidth(this) + 10, (int) (back.getHeight(this) * 1.5), null);
			
			buffg.setColor(backFade);
			buffg.fillRect(0, 0, this.getWidth(), this.getHeight());
			

			for (int i = 0; i < fieldList.size(); i++) {
				Image tempImg = fieldList.get(i).getImage();
				int tempX = fieldList.get(i).getX();
				int tempY = fieldList.get(i).getY();
				int tempWidth = fieldList.get(i).getWidth();
				int tempHeight = fieldList.get(i).getHeight();
				buffg.drawImage(tempImg, tempX, tempY, tempWidth, tempHeight, null);
			}

			buffg.drawImage(img, landimg.getWidth(null) / 2, imgY, img.getWidth(null), img.getHeight(null), this);

//			buffg.drawLine(range, 0, range, 600); // 범위 테스트용

			g.drawImage(buffImage, 0, 0, this);

		}

		// 페인트 컴포넌트 더블버퍼링
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
			update(g);

		}

	}

	/**
	 * Create the application.
	 */
	public Fade() {
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
