package sangsok;

class ���� {
	int num = 1;
}

class ���� extends ���� {

}

class �� extends ���� {
	int num = 3;
}

class ����Ű extends �� {
	int num = 4;
}

public class S1 {
	
	static void �׽�Ʈ() {
		
	}
	
	public static void main(String[] args) {
		���� f1 = new ����();
		System.out.println("����Ÿ���� ���Ļ������� num�� " + f1.num + "\n");

		�� ff1 = new ����Ű();
		System.out.println("��Ÿ���� ����Ű�������� num�� " + ff1.num + "\n");

		���� f2 = new ����();
		System.out.println("����Ÿ���� ����������� num�� " + f2.num + "\n");

		���� f5 = new ����Ű();
		System.out.println("����Ÿ���� ����Ű�������� num�� " + f5.num + "\n");
	}
}
