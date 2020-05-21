package Builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class Wbtest {

	private JFrame frame;
	JPanel panel;
	JButton clockBtn;
	JButton eatBtn;
	JButton moveBtn;
	JButton sleepBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wbtest window = new Wbtest();
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
	public Wbtest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		clockBtn = new JButton("time");
		clockBtn.setBounds(0, 0, 97, 23);
		panel.add(clockBtn);
		
		eatBtn = new JButton("\uBC25\uBA39\uAE30");
		eatBtn.setBounds(0, 238, 97, 23);
		panel.add(eatBtn);
		
		moveBtn = new JButton("\uC6B4\uB3D9\uD558\uAE30");
		moveBtn.setBounds(167, 238, 97, 23);
		panel.add(moveBtn);
		
		sleepBtn = new JButton("\uC7A0\uC790\uAE30");
		sleepBtn.setBounds(337, 238, 97, 23);
		panel.add(sleepBtn);
		
	}
}
