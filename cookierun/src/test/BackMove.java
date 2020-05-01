package test;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class BackMove {
	ImageIcon jellyIc1= new ImageIcon("img/jelly1.png");
	Image jelly1 = jellyIc1.getImage();
	
	ImageIcon bonusFirstCookieIc = new ImageIcon("img/bonusFirstCookie.png");
	Image bonusFirstCookie = bonusFirstCookieIc.getImage();
	
	ImageIcon backIc = new ImageIcon("img/back1.png");
	Image backImg = backIc.getImage();
	
	//jelly1 이미지
	int jelly1X = 2000;
	
	// 1번째 이미지
	int back1X = 0;
	
	// 2번째 이미지가 뒤따라 와야하므로 backImg의 넓이를 가져온다.
	int back2X = backImg.getWidth(null);

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BackMove window = new BackMove();
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
	public BackMove() {
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
	
	class MyPanel extends JPanel{
		
		public MyPanel() {
			
			setFocusable(true);
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
						
						jelly1X--;
						
						back1X--;
						back2X--;
						
						// 이미지가 화면밖으로 완전히 나가면
						// X축을 이미지의 넓이좌표로 다시 옮긴다
						
						// 1번이미지가 먼저 나가서 2번 뒤에 붙고
						// 2번이미지가 나가면 다시 1 번뒤에 붙는다
						if(back1X < -(backImg.getWidth(null))) {
							back1X = backImg.getWidth(null);
						}
						if(back2X < -(backImg.getWidth(null))) {
							back2X = backImg.getWidth(null);
						}
						repaint();
						try {
							Thread.sleep(2);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				
			}).start();
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); // 캔버스를 비워주는 메서드
			
			g.drawImage(backImg, back1X, 0, this); // 1번 그림
			g.drawImage(backImg, back2X, 0, this); // 2번 그림
			
			g.drawImage(jelly1, jelly1X, 100, this);
			
			g.drawImage(bonusFirstCookie, 50, 50, this);
			
			
		}
	}

}
