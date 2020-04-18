package sangsok2;

class 술 {
	int num = 3;
	
	public int 술가져오기() {
		return num;
	}
}

class 위스키 extends 술 {
	int num = 4;
	
	public int 술가져오기() {
		return num;
	}
}

public class S1 {
	
	public static void main(String[] args) {
		술 s1 = new 위스키();
		
		System.out.println(s1.술가져오기());
		
	}
}
