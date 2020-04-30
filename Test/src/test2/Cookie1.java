package test2;

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

public class Cookie1 {

	private JFrame frame;

	MyPanel panel;
	Field f1;
	Cookie c1;
	Stage s1;
	Stage s2;
	Foot nowFoot;
	int countFoot = 0;
	int footNum = 0;

	boolean fall = false;
	boolean jump = false;
	int jumpY = 0;
	int landing = 0;
	int doubleJump = 0;

	long firstTime = CookieUtil.getTime();
	long nowTime;

	int stair2;
	int stair1;
	int field;

	ImageIcon ic = new ImageIcon("img/bonusFirstCookie.png");
	Image cookie = ic.getImage();

	ImageIcon backIc = new ImageIcon("img/back1.png");
	Image backImg = backIc.getImage();

	ImageIcon footIc = new ImageIcon("img/land0001_tm003_fh.png");
	Image foot = footIc.getImage();

	List<Foot> foots = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cookie1 window = new Cookie1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cookie1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

	class MyPanel extends JPanel {
		public MyPanel() {
			setFocusable(true);

			f1 = new Field();
			c1 = new Cookie(cookie, 0, 0, 0);
			s1 = new Stage(backImg, 0, 0, 0);
			s2 = new Stage(backImg, 0, backImg.getWidth(null), 0);

			for (int i = 0; i < 5; i++) {
				int a = i * 124;
				foots.add(new Foot(foot, 0, a, 200));
				nowFoot = foots.get(0);

			}

			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						if (doubleJump != 2) {
							jump = true;
							doubleJump++;
							jump();
						}
					}
				}
			});

			// 화면갱신 쓰레드
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

			// 화면 이동 쓰레드
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {

						if (s1.getX() < -(s1.getImage().getWidth(null))) {
							s1.setX(s1.getImage().getWidth(null));
						}
						if (s2.getX() < -(s2.getImage().getWidth(null))) {
							s2.setX(s2.getImage().getWidth(null));
						}

						s1.setX(s1.getX() - 1);
						s2.setX(s2.getX() - 1);

						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();

			// 발판 이동 쓰레드
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						for (int i = 0; i < foots.size(); i++) {
							foots.get(i).setX(foots.get(i).getX() - 1);
						}
						countFoot++;

						footNum = (int) (countFoot / 124);

						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}).start();

			// 발판 확인 쓰레드
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						for (int i = 0; i < foots.size(); i++) {
							int nowFootX = foots.get(i).getX();
							if (nowFootX >= 125 && nowFootX < 248) {
								nowFoot = foots.get(i);
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

			// 쿠키 포지션 인식 쓰레드
			new Thread(new Runnable() {

				@Override
				public void run() {

					while (true) {
						int pos = c1.getY() + c1.getImage().getHeight(null);
						if(doubleJump == 0) {
							if (pos > 400) {
								landing = 2;

							} else if (pos == 100 && Integer.parseInt((f1.stair2.charAt(footNum) + "")) == 1) {
								landing = 1;
								
							} else if (pos == 150 && Integer.parseInt((f1.stair1.charAt(footNum) + "")) == 1) {
								landing = 1;
								
							} else if (pos == 200 && Integer.parseInt((f1.field.charAt(footNum) + "")) == 1) {
								landing = 1;
								
							} else if (pos < 100) {
								landing = 0;

							} else if (pos > 100 && pos < 200) {
								landing = 0;

							} else if (pos > 200) {
								landing = 0;

							} else if (pos == 100 && Integer.parseInt((f1.stair2.charAt(footNum) + "")) == 0) {
								landing = 0;

							} else if (pos == 150 && Integer.parseInt((f1.stair1.charAt(footNum) + "")) == 0) {
								landing = 0;

							} else if (pos == 200 && Integer.parseInt((f1.field.charAt(footNum) + "")) == 0) {
								landing = 0;

							}
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();

			// 쿠키 하강 쓰레드
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						System.out.println(c1.getY());
						System.out.println("landing" + landing);
						System.out.println("jumpY" + jumpY);
						System.out.println("fall" + fall);

						if (landing == 0 && jumpY <= 0) {
							if (fall == false) {
								fall = true;
								fall();
							}
						}
						if (landing == 2) {
							break;
						}

						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}).start();

		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(s1.getImage(), s1.getX(), s1.getY(), s1.getImage().getWidth(this) + 1,
					s1.getImage().getHeight(this), this);
			g.drawImage(s2.getImage(), s2.getX(), s2.getY(), s2.getImage().getWidth(this) + 1,
					s1.getImage().getHeight(this), this);

			for (int i = 0; i < foots.size(); i++) {
				g.drawImage(foots.get(i).getImage(), foots.get(i).getX(), foots.get(i).getY(), this);
			}

			g.drawImage(c1.getImage(), c1.getX(), c1.getY(), this);

		}
	}

	// 하강 메서드
	void fall() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("하강시작");

				long t1 = CookieUtil.getTime();
				long t2;
				int set = 1;
				while (true) {
					t2 = CookieUtil.getTime() - t1;
					jumpY = set + (int) ((t2) / 40);
					c1.setY(c1.getY() + jumpY);
					int pad = c1.getY() + c1.getImage().getHeight(null);
					if (Integer.parseInt((f1.stair2.charAt(footNum) + "")) == 1 && pad > 101 && pad < 100 + jumpY) {
						c1.setY(100 - c1.getImage().getHeight(null));
						break;
					} else if (Integer.parseInt((f1.stair1.charAt(footNum) + "")) == 1 && pad > 150
							&& pad < 151 + jumpY) {
						c1.setY(150 - c1.getImage().getHeight(null));
						break;
					} else if (Integer.parseInt((f1.field.charAt(footNum) + "")) == 1 && pad > 200
							&& pad < 201 + jumpY) {
						c1.setY(200 - c1.getImage().getHeight(null));
						break;
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				fall = false;
			}
		}).start();

	}

	// 점프 메서드
	void jump() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				if(doubleJump == 1) {					
					System.out.println("점프시작");
				} else if (doubleJump == 2) {
					System.out.println("더블점프시작");
				}

				long t1 = CookieUtil.getTime();
				long t2;
				int set = 7;
				while (true) {
					t2 = CookieUtil.getTime() - t1;
					jumpY = set - (int) ((t2) / 40);
					c1.setY(c1.getY() - jumpY);
					if (jumpY <= 0) {
						break;
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				jump = false;
			}
		}).start();

	}

}

class CookieUtil {

	// 시간 가져오기
	static long getTime() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime();
	}

}
