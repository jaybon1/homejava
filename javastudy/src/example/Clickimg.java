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
			super.paintComponent(g); // ĵ���� ����
			g.drawImage(img, 50, 50, this); // �̹��� �׸���

		}

		public MyPanel() {
			setFocusable(true); // �Է� ��Ŀ�� �ޱ�
			addMouseListener(new MouseAdapter() { // ���콺 ������ �߰��ϱ�

				@Override
				public void mouseClicked(MouseEvent e) { // ���콺�� Ŭ���Ǹ� �۵��ϱ�

					// �̹����� ic1�� �̹����� ic2�� �̹����� �ٲٱ�
					if (img == ic1.getImage()) {
						img = ic2.getImage();
						repaint();
					} else {
						img = ic1.getImage();
					}
					repaint(); // �׸� �ٽñ׸���
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
