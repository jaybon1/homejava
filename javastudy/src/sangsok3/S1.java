package sangsok3;

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

class 이과두주 extends 술 {
	int num = 5;

	public int 술가져오기() {
		return num;
	}
}

public class S1 {

	static void 테스트(술 ss1, 술 ss2) {
		System.out.println(ss1.num + " " + ss2.num);
		System.out.println(ss1.술가져오기() + "번 술과 " + ss2.술가져오기() + "번 술을 가져왔습니다");
	}

	public static void main(String[] args) {
		위스키 s1 = new 위스키();
		이과두주 s2 = new 이과두주();

		테스트(s1, s2);
	}
}
