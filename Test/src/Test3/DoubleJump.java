package Test3;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class DoubleJump {

	private JFrame frame;

	int field = 300; // 낙하가 멈추는 지점

	ImageIcon ic = new ImageIcon("img/c1.gif");
	Image img = ic.getImage();

	int imgY = 5; // 이미지가 시작하는 시간

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
					DoubleJump window = new DoubleJump();
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

			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {

						// 발바닥 위치는 이미지의 Y위치 + 이미지의 높이 이다.
						int foot = imgY + img.getHeight(null);

						// 발바닥이 땅보다 위에 있으면 작동
						if (jump == false && foot < field && fall == false) { // 점프중이지 않고 공중에 있으며 떨어지는 중이 아닐 때 작동
							fall = true; // 떨어지는 중으로 전환
							System.out.println("낙하");
							long t1 = getTime(); // 현재시간을 가져온다
							long t2;
							int set = 1; // 처음 낙하량 (0~10) 까지 테스트해보자
							while (foot < field) { // 발이 땅에 닿기 전까지 반복
								t2 = getTime() - t1; // 지금 시간에서 t1을 뺀다
								int fallY = set + (int) ((t2) / 60); // 낙하량을 늘린다.
								
								if(foot + fallY >= field) { // 떨어지는 량이 너무크면 땅보다 아래에 갈수 있으니
									imgY = field - img.getHeight(null); // 보정해준다
									break;
								} else {
									imgY = imgY + fallY; // Y좌표에 낙하량을 더한다			
								}
								
								foot = imgY + img.getHeight(null); // 현재 발바닥 위치를 저장한다
								repaint(); // 다시그리기
								
								if(jump == true) { // 떨어지다가 더블 점프를 하면 낙하중지
									break;
								}
								
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							fall = false;
							
							if(jump == false) { // 발이 땅에 닿고 점프 중이 아닐 때 더블점프 카운트를 0으로 변경
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
								
								if(doubleJump == 1) {
									System.out.println("점프");									
								} else if(doubleJump == 2) {
									System.out.println("더블점프");		
								}

								// 발바닥 위치는 이미지의 Y위치 + 이미지의 높이 이다.
								int foot = imgY + img.getHeight(null); // 발바닥의 위치 Y좌표+ 이미지의 높이

								long t1 = getTime(); // 현재시간을 가져온다
								long t2;
								int set = 5; // 점프 계수 설정(0~20) 등으로 바꿔보자
								int jumpY = 8; // 1이상으로만 설정하면 된다.(while문 조건 때문)
								while (jumpY > 0) { // 상승 높이가 0일때까지 반복
									t2 = getTime() - t1; // 지금 시간에서 t1을 뺀다
									jumpY = set - (int) ((t2) / 60); // jumpY 를 세팅한다.
									imgY = imgY - jumpY; // Y값을 변경한다.
									foot = imgY + img.getHeight(null); // 발바닥 위치를 저장한다.
									repaint();
									
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
				}
			});

		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 100, imgY, img.getWidth(null) / 2, img.getHeight(null) / 2, this);

		}

	}

	/**
	 * Create the application.
	 */
	public DoubleJump() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

}
