package Frame;

import javax.swing.JFrame;

public class FrameTest1A extends JFrame { // JFrame�� ��ӹ��� Ŭ����
	
	public FrameTest1A() { // ������
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â�� ������ ���α׷��� �����
		
		// ������� ���� x��ǥ, y��ǥ // ����, ����
		setBounds(0, 0, 500, 500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new FrameTest1A();
	}

}
