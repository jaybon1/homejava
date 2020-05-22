package logic;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.dong.Dong;
import logic.man.Man;

import java.awt.BorderLayout;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	class MyPanel extends JPanel {

		Man man;
		List<Dong> dongList;

		boolean rightKey;
		boolean leftKey;

		public MyPanel() {
			setFocusable(true);

			man = new Man(50, 50, 50);
			rightKey = false;
			leftKey = false;

			new Thread(new Runnable() {

				@Override
				public void run() {

					while (true) {

						if (rightKey) {
							man.setX(man.getX() + 2);
						}
						if (leftKey) {
							man.setX(man.getX() - 2);
						}

						repaint();
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
					if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						rightKey = true;
					}

					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						leftKey = true;
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						rightKey = false;
					}

					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						leftKey = false;
					}
				}

			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawRect(man.getX(), this.getHeight() - 70, man.getWidth(), man.getHeight());

		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

}
