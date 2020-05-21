package Frame;

import javax.swing.JFrame;

public class FrameTest1 extends JFrame {
	
	public FrameTest1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new FrameTest1();
	}

}

