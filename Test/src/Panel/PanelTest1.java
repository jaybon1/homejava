package Panel;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelTest1 {
	
	JFrame frame;
	
	public PanelTest1() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setBounds(0, 0, 500, 300);
		MyPanel mp = new MyPanel();
		mp.setLayout(null);
		frame.getContentPane().add(mp, BorderLayout.CENTER);
		
	}
	
	private class MyPanel extends JPanel{
		
		ImageIcon ic;
		
		
		public MyPanel() {
			ic = new ImageIcon("img/back1.png");
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(ic.getImage(), 0, 0, null);
		}
	}
	
	public static void main(String[] args) {
		new PanelTest1().frame.setVisible(true);
	}
}
