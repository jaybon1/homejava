package ch03;

public class Mem{
	
	int num = 10;
	
	static String name = "홍길동"; // 전역변수(static)
	
	void test() {
		
		// 지역변수(main 내의 변수도 지역변수)
		// 함수내의 변수들은 리턴하지 않으면 호출 종료시 소멸
		int num = 5;
	}
	
	public static void main(String[] args) {
		int sum = 100;
		System.out.println("sum : " + sum);
		
		Mem m = new Mem();
		m.test();
		System.out.println("번호 : " + m.num);
		System.out.println(1);
		System.out.println(2);
		System.out.println("프로그램 종료");
	}
}
