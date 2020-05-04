
package Test3;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

import java.awt.AlphaComposite;
import java.awt.BorderLayout;

public class Foots7 {

	private JFrame frame;

	int field = 400; // 발판 높이

	List<Jelly> jellyList = new ArrayList<>(); // 젤리 리스트

	List<Foot> fieldList = new ArrayList<>(); // 발판 리스트

	List<Tacle> tacleList = new ArrayList<>(); // 장애물 리스트

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

	ImageIcon jelly1 = new ImageIcon("img/jelly1.png");
	ImageIcon eff1 = new ImageIcon("img/effect/tw2.png");

	ImageIcon tacle1 = new ImageIcon("img/tacle1.png");

	int[][] colorArr; // 이미지의 x y 좌표의 색값을 저장하는 2차원배열 colorArr[0][0] 을 호출하면 16777215 등이 나온다.
	int[] sizeArr; // 이미지의 넓이와 높이를 가져오는 1차원 배열 temp

	ImageIcon icJump = new ImageIcon("img/c1jump.gif");
	ImageIcon icDoubleJump = new ImageIcon("img/c1doubleJump.gif");
	ImageIcon icfall = new ImageIcon("img/c1fall.png");
	ImageIcon icfallOver = new ImageIcon("img/c1fallOver.png");
	ImageIcon icnap = new ImageIcon("img/c1nap.gif");
	ImageIcon ichit = new ImageIcon("img/hit.gif");
	int cookieAlpha = 255;

	ImageIcon backIc = new ImageIcon("img/back1.png");
	Image back = backIc.getImage();
	Image back1 = backIc.getImage();
	int backX = 0;
	int back1X = back.getWidth(null);

	int imgY = 0; // 이미지가 시작하는 좌표

	boolean fall = false; // 현재 떨어지는지 확인
	boolean jump = false; // 현재 점프중인지 확인

	int doubleJump = 0; // 점프 카운트 (2가되면 더블점프 상태이다)
	
	boolean invincible = false;
	
	private AlphaComposite alphaComposite;

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
					Foots7 window = new Foots7();
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

			try {
				sizeArr = Bf3.getSize("img/firstMap.png");
				colorArr = Bf3.getPic("img/firstMap.png");
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			int maxX = sizeArr[0];
			int maxY = sizeArr[1];

			for (int i = 0; i < maxX; i += 2) { // 발판은 4칸을 차지하는 공간이기 때문에 2,2사이즈로 반복문을 돌린다.
				for (int j = 0; j < maxY; j += 2) {
					if (colorArr[i][j] == 0) { // 색값이 0 일경우 (검은색)
						fieldList.add(new Foot(landimg, i * 40, j * 40, 80, 80)); // 좌표에 40을 곱하고, 넓이와 높이는 80으로 한다.
					}

				}
			}

			for (int i = 0; i < maxX; i += 1) { // 젤리는 1칸을 차지하기 때문에 1,1사이즈로 반복문을 돌린다.
				for (int j = 0; j < maxY; j += 1) {
					if (colorArr[i][j] == 16776960) { // 색값이 16776960일 경우 (노란색)
						jellyList.add(new Jelly(jelly1.getImage(), i * 40, j * 40, 30, 30, 0)); // 좌표에 40을 곱하고, 넓이와
																									// 높이는 30으로 한다.
					}

				}
			}

			for (int i = 0; i < maxX; i += 2) { // 장애물은 4칸 이상을 차지한다. 추후 수정
				for (int j = 0; j < maxY; j += 2) {
					if (colorArr[i][j] == 16711680) { // 색값이 16711680일 경우 (빨간색)
						tacleList.add(new Tacle(tacle1.getImage(), i * 40, j * 40, 80, 80, 0)); // 좌표에 40을 곱하고, 넓이와 높이는
																								// 30으로 한다.
					}

				}
			}
			
			new Thread(new Runnable() {
				
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

						if (backX < -(back.getWidth(null)-1)) {
							backX = back.getWidth(null);
						}
						if (back1X < -(back.getWidth(null)-1)) {
							back1X = back.getWidth(null);
						}

						backX--;
						back1X--;
						
						
						

						// 발판위치를 -4 씩 해준다.
						for (int i = 0; i < fieldList.size(); i++) {
							
							Foot tempFoot = fieldList.get(i);
							
							if(tempFoot.getX() < -90) { // 발판의  x좌표가 -90 미만이면 해당 발판을 제거한다.
								fieldList.remove(tempFoot);
							} else {
								tempFoot.setX(tempFoot.getX() - 4);						
							}
						}

						// 젤리위치를 -4 씩 해준다.
						for (int i = 0; i < jellyList.size(); i++) {
							Jelly tempJelly = jellyList.get(i);
							
							if(tempJelly.getX() < -90) {
								fieldList.remove(tempJelly);
							} else {
								tempJelly.setX(tempJelly.getX() - 4);							
								if(tempJelly.getY() > imgY 
										&& tempJelly.getY() < imgY+fallOverY
										&& tempJelly.getX() > 160
										&& tempJelly.getX() < 240) {
									tempJelly.setImage(eff1.getImage());
									
								}
							}
						}
						// 장애물위치를 - 4 씩 해준다.
						for (int i = 0; i < tacleList.size(); i++) {
							Tacle tempTacle = tacleList.get(i);
							if(tempTacle.getX() < -90) {
								fieldList.remove(tempTacle);
							} else {
								tempTacle.setX(tempTacle.getX() - 4);	
								if(
										!invincible
										&& tempTacle.getY() > imgY 
										&& tempTacle.getY() < imgY+fallOverY
										&& tempTacle.getX() > 160
										&& tempTacle.getX() < 240) {
									invincible = true;								
									
									new Thread(new Runnable() {
										
										@Override
										public void run() {
											
											img = ichit.getImage();
											
											cookieAlpha = 80;
											try {
												Thread.sleep(500);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
											img = ic.getImage();
											
											
											for (int j = 0; j < 11; j++) {
												if(cookieAlpha == 80) {
													cookieAlpha = 160;
												} else {
													cookieAlpha = 80;
												}
												try {
													Thread.sleep(250);
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
											}
											cookieAlpha = 255;
											
											
											invincible = false;
											System.out.println("무적종료");
										}
									}).start();
								}
							}
						}

//						range = 160; // 캐릭터가 서있을 수 있는 위치 ( 나중에 조절해야됨)

						List<Integer> countList = new ArrayList<>(); // 쓰레드 안에 임시적으로 선언한 리스트

						int tempField; // 발판위치를 계속 스캔하는 변수
						int tempNowField;
						if (invincible) {
							tempNowField = 400; // nowField를 세팅해주는 임시 변수
						} else {
							tempNowField = 2000; // nowField를 세팅해주는 임시 변수
						}

						for (int i = 0; i < fieldList.size(); i++) {

							int tempX = fieldList.get(i).getX(); // 발판의 x값

							if (tempX >= 160 && tempX < 240) { // 발판이 캐릭 범위 안이라면

								tempField = fieldList.get(i).getY(); // 발판의 y값

//								System.out.println(imgY + fallOverY + "  " + tempField);
								// 발판위치가 tempNowField보다 작고, 발바닥의 위치가 tempField보다 위에 있다면.
								if (tempField < tempNowField && imgY + fallOverY <= tempField) {

									tempNowField = tempField;

								}
							}
						}

						nowField = tempNowField; // 결과를 nowField에 업데이트 한다.

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
			
			super.paintComponent(buffg);

			buffg.drawImage(back, backX, 0,back.getWidth(this), (int) (back.getHeight(this) * 1.5),
					null);
			buffg.drawImage(back1, back1X, 0, back.getWidth(this), (int) (back.getHeight(this) * 1.5),
					null);

			for (int i = 0; i < fieldList.size(); i++) {

				Foot tempFoot = fieldList.get(i);

				if (tempFoot.getX() > -90 && tempFoot.getX() < 810) { // 사양을 잡아먹지 않게 하기위한 조치
					buffg.drawImage(tempFoot.getImage(), tempFoot.getX(), tempFoot.getY(), tempFoot.getWidth(),
							tempFoot.getHeight(), null);
				}

			}

			for (int i = 0; i < jellyList.size(); i++) {

				Jelly tempJelly = jellyList.get(i);

				if (tempJelly.getX() > -90 && tempJelly.getX() < 810) {
					buffg.drawImage(tempJelly.getImage(), tempJelly.getX(), tempJelly.getY(), tempJelly.getWidth(),
							tempJelly.getHeight(), null);
				}
			}

			for (int i = 0; i < tacleList.size(); i++) {

				Tacle tempTacle = tacleList.get(i);

				if (tempTacle.getX() > -90 && tempTacle.getX() < 810) {
					buffg.drawImage(tempTacle.getImage(), tempTacle.getX(), tempTacle.getY(), tempTacle.getWidth(),
							tempTacle.getHeight(), null);
				}
			}
			Graphics2D g2 = (Graphics2D)buffg;

			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)cookieAlpha/255);
		    g2.setComposite(alphaComposite);
		    
			buffg.drawImage(img, 160, imgY, img.getWidth(null), img.getHeight(null), this);
			
			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)255/255);
		    g2.setComposite(alphaComposite);
			
			
			g.drawImage(buffImage, 0, 0, this);
			
			g.drawLine(160, 0, 160, 500);
			g.drawLine(240, 0, 240, 500);

		}

	}

	/**
	 * Create the application.
	 */
	public Foots7() {
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