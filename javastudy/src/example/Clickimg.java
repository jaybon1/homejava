package example;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Clickimg {

	private JFrame frame;

	private MyPanel panel;

	ImageIcon ic1 = new ImageIcon("img/shot.png");
	ImageIcon ic2 = new ImageIcon("img/shotR.png");
	Image img = ic1.getImage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clickimg window = new Clickimg();
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
	public Clickimg() {
		initialize();
	}

	class MyPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); // 캔버스 비우기
			g.drawImage(img, 50, 50, this); // 이미지 그리기

		}

		public MyPanel() {
			setFocusable(true); // 입력 포커스 받기
			addMouseListener(new MouseAdapter() { // 마우스 리스너 추가하기

				@Override
				public void mouseClicked(MouseEvent e) { // 마우스가 클릭되면 작동하기

					// 이미지가 ic1의 이미지면 ic2의 이미지로 바꾸기
					if (img == ic1.getImage()) {
						img = ic2.getImage();
						repaint();
					} else {
						img = ic1.getImage();
					}
					repaint(); // 그림 다시그리기
				}
			});
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

}
