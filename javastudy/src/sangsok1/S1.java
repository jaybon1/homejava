package sangsok1;

class ���� {
	public String ����(){		
		return "������ �����մϴ�";
	}
}

class ���� extends ���� {
}

class �� extends ���� {
	
	public String ����(){
		return "���� �����մϴ�";
	}
}

class ����Ű extends �� {
	
	public String ����(){
		return "����Ű�� �����մϴ�";
	}
}

public class S1 {
	public static void main(String[] args) {
		���� f1 = new ����();
		System.out.println(f1.����() + "\n");
		
		�� ff1 = new  ����Ű();
		System.out.println(ff1.����() + "\n");

		���� f2 = new ����();
		System.out.println(f2.����() + "\n");

		���� f5 = new ����Ű();
		System.out.println(f5.����() + "\n");
	}
}