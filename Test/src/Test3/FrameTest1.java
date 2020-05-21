package Test3;

import javax.swing.JFrame;



public class FrameTest1 { // �ƹ��͵� ��ӹ��� ���� Ŭ����
	
	private JFrame frame; // Ŭ���� ���ο� �ٸ� Ŭ������ ���۷����� �غ�

	public FrameTest1() { // Ŭ���� ������
		
		frame = new JFrame(); // JFrame �ν��Ͻ� ����
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ư ������ ���α׷� ����
		
		frame.setLocationRelativeTo(null); // ȭ���� ����� ���߾ӿ� ��ġ
		
		// ������� ���� x��ǥ, y��ǥ // ����, ����
		// �ٸ� ������ frame.setLocationRelativeTo(null)�� �߱� ������ ������ġ�� ������ �Է��ص� ����
		frame.setBounds(0, 0, 500, 500);
		
		// �������� ȭ�鿡 ���̰� �ϴ°�
		// �������� ȭ�鿡 �� �ִ� ���� ���α׷��� ���� ��Ų�� (���ŷ� setVisible(false)�� �ϸ� ���α׷��� ����ȴ�)
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new FrameTest1(); // ���ο��� FrameTest1 �ν��Ͻ� ����
		
	}
}
