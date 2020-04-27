package example;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

import java.awt.BorderLayout;

public class WebSwing {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebSwing window = new WebSwing();
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
	public WebSwing() {
		initialize();
	}
	
	class MyPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); // 캔버스 비우기
			g.drawImage(img, 50, 50, this); // 이미지 그리기

		}

		public MyPanel() {
			setFocusable(true); // 입력 포커스 받기
			addMouseListener(new MouseAdapter() { // 마우스 리스너 추가하기

				@Override
				public void mouseDragged(MouseEvent e) {
					
				}
			});
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFXPanel panel = new JFXPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Platform.runLater(new Runnable() {

			public void run() {

				WebEx1.initAndLoadWebView(panel);

			}

		});
		
		
	}

}
