package ch02;


class 히드라 {
	String name = "히드라";
	int hp = 75; // 피통
	int mp = 0; // 마나통
	int dmg = 10; // 데미지
	
	void 버로우() {
		System.out.println("히드라가 땅속으로 숨습니다");
	}
}

public class Test1 {
	
	public static void main(String[] args) {
		히드라 h1 = new 히드라();
		System.out.println(h1.hp);
		h1.버로우();
	}
}
