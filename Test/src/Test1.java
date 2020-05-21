import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Test1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 window = new Test1();
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
	public Test1() {
		initialize();
	}

	class MyPanel extends JPanel{
		int x;
		public MyPanel() {
			x = 0;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
						x++;
						repaint();
						try {
							Thread.sleep(100);
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
			g.drawRect(x, 50, 50, 50);
			
		}
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
