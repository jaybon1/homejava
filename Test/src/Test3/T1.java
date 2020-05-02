package Test3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class T1 extends JFrame{

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T1 window = new T1();
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
	public T1() {
		this.initialize();
		this.setSize(1000, 500);
		this.setVisible(true);
	}
	@Override
	public void setSize(int width, int height) {
		
	}
	@Override
	public void setVisible(boolean b) {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(212, 173, 57, 15);
		panel.add(lblNewLabel);
	}
}
