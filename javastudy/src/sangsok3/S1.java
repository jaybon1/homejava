package sangsok3;

class �� {
	int num = 3;

	public int ����������() {
		return num;
	}
}

class ����Ű extends �� {
	int num = 4;

	public int ����������() {
		return num;
	}
}

class �̰����� extends �� {
	int num = 5;

	public int ����������() {
		return num;
	}
}

public class S1 {

	static void �׽�Ʈ(�� ss1, �� ss2) {
		System.out.println(ss1.num + " " + ss2.num);
		System.out.println(ss1.����������() + "�� ���� " + ss2.����������() + "�� ���� �����Խ��ϴ�");
	}

	public static void main(String[] args) {
		����Ű s1 = new ����Ű();
		�̰����� s2 = new �̰�����();

		�׽�Ʈ(s1, s2);
	}
}
