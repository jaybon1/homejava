package Frame;

import javax.swing.JFrame;

public class FrameTest2 {
	
	private JFrame frame;

	public FrameTest2() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 500, 500);
		
	}
	
	public static void main(String[] args) {
		
		FrameTest2 ft2 = new FrameTest2();
		
		ft2.frame.setVisible(true);
		
	}
}
