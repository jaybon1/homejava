package Test5;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RankPanel extends JPanel {
	ImageIcon ic = new ImageIcon("img/back1.png");
	int X =0;
	
	JLabel testLa;
	
	public RankPanel() {
		testLa = new JLabel("·©Å©ÆÐ³Î");
		testLa.setBounds(0,0, 100, 20);
		add(testLa);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					X--;
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
		g.drawImage(ic.getImage(), X, 0, null);
	}
	
}
