package sangsok;

class 음식 {
	int num = 1;
}

class 음료 extends 음식 {

}

class 술 extends 음료 {
	int num = 3;
}

class 위스키 extends 술 {
	int num = 4;
}

public class S1 {
	
	static void 테스트() {
		
	}
	
	public static void main(String[] args) {
		음식 f1 = new 음식();
		System.out.println("음식타입의 음식생성자의 num값 " + f1.num + "\n");

		술 ff1 = new 위스키();
		System.out.println("술타입의 위스키생성자의 num값 " + ff1.num + "\n");

		음료 f2 = new 음료();
		System.out.println("음료타입의 음료생성자의 num값 " + f2.num + "\n");

		음식 f5 = new 위스키();
		System.out.println("음식타입의 위스키생성자의 num값 " + f5.num + "\n");
	}
}
