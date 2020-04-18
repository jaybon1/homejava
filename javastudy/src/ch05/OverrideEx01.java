package ch05;

class A {
	
	void run() {
		System.out.println("A 달린다.");
	}
}

class B extends A {
	
	
	
	@Override
	void run() {
		System.out.println("B 달린다.");
	}
}

class C extends B {
	
	String name = "C";
	
	@Override
	void run() {
		System.out.println(name + "달린다.");
	}
}

public class OverrideEx01 {
	public static void main(String[] args) {
		A c1 = new C();
		c1.run(); // 가리키는 것은 A지만 다운캐스팅을 하지 않고도 C의 변수를 찾을 수 있다.
		
		B c2 = new C();
		c2.run();
		
		C c3 = new C();
		c3.run();
		
		A b1 = new B();
		b1.run();
		
		B b2 = new B();
		b2.run();
		
		A a1 = new A();
		a1.run();
	}
}
