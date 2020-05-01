package Test3;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.CropImageFilter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.AWTException;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;

public class Test1 {

	private JFrame frame;

	ImageIcon ic = new ImageIcon("img/tw1.png");
	Image img = ic.getImage();
	
	ImageIcon ic1 = new ImageIcon("img/tw2.png");
	Image img1 = ic1.getImage();
	

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

	class MyPanel extends JPanel {
		public MyPanel() {


		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, 500, 500);
			g.drawImage(img, 50, 50, this);
			g.drawImage(img1, 50, 100, this);



		}

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}
}
