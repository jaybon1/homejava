package ch04;

class Rabbit {
	private String name; // heap����, ��������, �ɹ�����, �ʵ�, �Ӽ�, ������Ƽ
	private int power;

	public Rabbit(String name, int power) {
		this.name = name;
		this.power = power;
	}

	// ���� - ��ü�� �����ϴ� ���� �޼���� �ϴ°� ��ü������ ����
	// ������ �����ϴ� ������ �����ϰ� �����ڸ� �����ؾ��Ѵ�
	// �޼���� �� Ŭ������ å���� ����Ѵ� (�߿�)
	boolean drink() {
		if (power >= 100) {
			return false;
		}
		power++;
		return true;
	}

	
//	void drink() {
//		if (power < 100) {
//			power++;
//		}
//	}

	public int getPower() {
		return power;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	

}

public class RabbitApp {
	public static void main(String[] args) {
		Rabbit r1 = new Rabbit("�䳢", 20); // power �� 100�� max��� ����
		System.out.println(r1.getPower());
		r1.drink();
		System.out.println(r1.getPower());
		r1.drink();
		System.out.println(r1.getPower());

		while (r1.drink()) {}
		System.out.println(r1.getPower());
		
		
		//�̸�����
		r1.setName("���䳢");
		System.out.println(r1.getName());
	}
}