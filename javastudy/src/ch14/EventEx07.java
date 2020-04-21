package ch14;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventEx07 extends JFrame {
	int y = 100;

	public EventEx07() {
		JLabel la = new JLabel("¾È³ç");
		Container c = getContentPane();
		la.setLocation(100, 100);
		la.setSize(30, 30);
		c.setLayout(null);
		c.add(la);
		c.setSize(300, 600);
		c.setVisible(true);
	}

	public static void main(String[] args) {
		new EventEx07();
	}
}


//c.addKeyListener(new KeyAdapter() {
//@Override
//public void keyPressed(KeyEvent e) {
//	if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for (int i = 0; i < 10; i++) {
//					y = y + 10;
//					la.setLocation(100, y);
//				}
//
//			}
//		}).start();
//	}
//}
//});