package Frame;

import javax.swing.JFrame;



public class FrameTest2A { // �ƹ��͵� ��ӹ��� ���� Ŭ����
	
	private JFrame frame; // Ŭ���� ���ο� �ٸ� Ŭ������ ���۷����� �غ�

	public FrameTest2A() { // Ŭ���� ������
		
		frame = new JFrame(); // JFrame �ν��Ͻ� ����
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ư ������ ���α׷� ����
		
		// ������� ���� x��ǥ, y��ǥ // ����, ����
		frame.setBounds(0, 0, 500, 500);
		
	}
	
	public static void main(String[] args) {
		
		FrameTest2A ft2a = new FrameTest2A(); // ���ο��� FrameTest2A Ŭ������ �ν��Ͻ� ����
		
		// �������� ȭ�鿡 ���̰� �ϴ°�
		// �������� ȭ�鿡 �� �ִ� ���� ���α׷��� ���� ��Ų�� (���ŷ� setVisible(false)�� �ϸ� ���α׷��� ����ȴ�)
		ft2a.frame.setVisible(true);
		
	}
}

