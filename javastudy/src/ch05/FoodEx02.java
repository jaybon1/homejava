package ch05;


// �߻� Ŭ������ �Ϲ� �޼��带 ���� �� �ִ�.
// �߻� Ŭ������ ���� ������ �� ���� �޼��带 ������Ʈ���� �̷� �� �ִ�.
// �߻� Ŭ������ abstract�� ���δ�.
// �߻� Ŭ������ ���ؼ� ������ ���� �� �ִ�.
abstract class Food {
	
	abstract void standby();
	
	// protected�� �ڽĸ� ��밡��
	
	protected void eat() {
		System.out.println("������ �Խ��ϴ�."); // �������ΰ��� ���
	}

	abstract void cook(); // �������ε� ������Ʈ���� ���ݾ� �ٸ��ٸ� �߻�޼��� ���
	
	void auto() {  // �̷��� �����ϸ� ���� �Ǽ��� ���� �ʴ´� (�丮 -> ����)
		standby();
		cook();
		eat();
	}
}

class ��� extends Food {
	
	

	@Override
	void cook() {
		System.out.println("���� ���Դϴ�.");

	}

	@Override
	void standby() {
		System.out.println("���� ���� �غ��մϴ�.");
		
	}

}

class ���� extends Food {

	@Override
	void cook() {
		System.out.println("���ǿ� �����ϴ�.");
	}
	
	@Override
	void standby() {
		System.out.println("����� ������ �غ��մϴ�.");
		
	}

}

public class FoodEx02 {
	
	static void start(Food f) {
		f.auto();
	}
	
	
	public static void main(String[] args) {
		start(new ���());
	}
}