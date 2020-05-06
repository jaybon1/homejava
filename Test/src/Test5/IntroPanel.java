package Test5;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class IntroPanel extends JPanel {

	ImageIcon introIc = new ImageIcon("img/out/intro.png"); // 인트로 이미지

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(introIc.getImage(), -60, 0, /* this.getWidth(), this.getHeight(), */ null);
	}
}

