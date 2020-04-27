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

public class ThreadSwing1 {

	private JFrame frame;

	ImageIcon ic = new ImageIcon("img/z.png"); // �̹��������� ��ü ����
	Image img = ic.getImage(); // �̹��� ��ü ����

	int imgX = 50;
	int imgY = 50;

	MyPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadSwing1 window = new ThreadSwing1();
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
	public ThreadSwing1() {
		initialize();
	}

	class MyPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); // ĵ���� ����
			g.drawImage(img, imgX, imgY, this); // �̹��� �׸���

		}

		public MyPanel() {
			setFocusable(true); // �Է� ��Ŀ�� �ޱ�

			Thread nt = new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {

						repaint(); // �׸� �ٽñ׸���
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});

			nt.setDaemon(true); // �����带 �������� ������ ������ �����Ҷ� ���� ����ȴ�.
			nt.start(); // ������ ����

			// addMouseListener(new MyMouseListener());
			addMouseMotionListener(new MouseAdapter() { // �巡�״� ��Ǹ����ʴ�

				@Override
				public void mouseDragged(MouseEvent e) {
					imgX = e.getX(); // ���콺�� ��ǥ�� �޾Ƽ� �̹��� ��ǥ�� ����
					imgY = e.getY();
					System.out.println(e.getX());
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
