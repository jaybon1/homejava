package ch02;


class ����� {
	String name = "�����";
	int hp = 75; // ����
	int mp = 0; // ������
	int dmg = 10; // ������
	
	void ���ο�() {
		System.out.println("����� �������� �����ϴ�");
	}
}

public class Test1 {
	
	public static void main(String[] args) {
		����� h1 = new �����();
		System.out.println(h1.hp);
		h1.���ο�();
	}
}
