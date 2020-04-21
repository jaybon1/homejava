package ch14;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventEx06 extends JFrame {
	
	int imgX = 140;
	int imgY = 20;
	
	public EventEx06() {
		setTitle("장풍 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 300);
		setLocationRelativeTo(null); // 프레임이 화면 가운데 배치
		setContentPane(new MyPanel()); // 기본패널을 안쓰고 내가 만든 패널을 사용
		setVisible(true);
	}
	
	// paintComponent()는 JFrame안에서 작동안함.
	class MyPanel extends JPanel {
		
		public MyPanel() {
			setFocusable(true);
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					System.out.println("keycode : " + e.getKeyCode());
					System.out.println("keychar : " + e.getKeyChar());
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT: // 0x25
						imgX = imgX - 10;
						break;
					case KeyEvent.VK_RIGHT: // 0x27
						imgX = imgX + 10;
						break;
					case KeyEvent.VK_SPACE:  // 0x20
						new Thread(new Runnable() {
							
							@Override
							public void run() {
								int time = 20;
								while (time > 0) {
									imgX = imgX +10;
									repaint();
									time--;
									try {
										Thread.sleep(100);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								
							}
						}).start();
						break;
					}
				}
			});
		}
		
		// 그림 다시그리기
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g); // 화면 클리어하기
			
			ImageIcon imgRyu = new ImageIcon("img/ryu.png");
			ImageIcon imgPa = new ImageIcon("img/pa.png");
			
			//이미지 추출
			Image ryu = imgRyu.getImage();
			Image pa = imgPa.getImage();
			
			g.drawImage(ryu, 0, 0, null);
			g.drawImage(pa, imgX, imgY, null);
		}
	}
	
	public static void main(String[] args) {
		new EventEx06();
	}
}
