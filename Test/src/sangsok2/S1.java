package sangsok2;

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

public class S1 {
	
	public static void main(String[] args) {
		�� s1 = new ����Ű();
		
		System.out.println(s1.����������());
		
	}
}
