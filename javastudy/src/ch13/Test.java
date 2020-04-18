package ch13;

class A {
	int a = 10;
}

public class Test {
	
	static void sample(A a) {
		System.out.println(a.a);
	}
	
	
	public static void main(String[] args) {
		
	// 기본자료형은 데이터 자체를 저장한다
	int a1 = 10;
	int a2 = a1;
	
	a1 = a1 + 10;
	System.out.println(a1);
	System.out.println(a2);
	
	
	// 클래스자료형은 인스턴스의 주소값을 저장한다
	A test = new A();
	A test1 = test;
	
	test.a = test.a + 10;
	System.out.println(test.a);
	System.out.println(test1.a);
	
	
	// 서로 다른 인스턴스 이기 때문에 데이터가 따로 계산된다
	A test2 = new A();
	A test3 = new A();
	
	test2.a = test2.a + 10;
	System.out.println(test2.a);
	System.out.println(test3.a);
	}
}
