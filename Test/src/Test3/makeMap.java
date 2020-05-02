package Test3;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;

public class makeMap {
	
	ImageIcon jellyIc = new ImageIcon("img/jelly1.png");
	ImageIcon effIc = new ImageIcon("img/effTest1.png");
	
	Jelly j1;
	Jelly j2;
	
	
	private AlphaComposite alphaComposite;
	

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					makeMap window = new makeMap();
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
	public makeMap() {
		initialize();
	}

	class MyPanel extends JPanel {
		

		public MyPanel() {
			
			j1 = new Jelly(jellyIc.getImage(), 500, 150, 20, 20, 255);
			j2 = new Jelly(jellyIc.getImage(), 600, 150, 20, 20, 255);
			
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
						
					}
					
				}
			}).start();
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			
		}
	}
		
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

}
