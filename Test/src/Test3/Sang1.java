
package Test3;

class A{
	
	// 부모는 hello메서드가 없다
	
}

class B extends A{
	
	public void hello() { // 자식에게만 메서드가 있다
		System.out.println("hello");
	}
	
}


public class Sang1 {
	public static void main(String[] args) {
		
		
		// B타입의 B생성자로 만든 인스턴스는 hello메서드를 사용할 수 있다.
		
		B test1 = new B();
		test1.hello();
		
		
		// A타입의 A생성자로 만든 인스턴스는 hello메서드가 당연히 없다.
		
		A test2 = new A();
		test2.hello();
		
		
		// A타입의 B생성자로 만든 인스턴스는 A클래스에 hello메서드가 없기 때문에 오버라이딩이 안되며
		// 오버라이딩이 안되기 때문에 불러올 수 없다.
		
		A test3 = new B();
		test3 = (B)test3;
		
		
		// 해결법1 - 부모에 hello메서드를 만들어 준다.
		// 해결법2 - JPanel 등 자바 내장클래스라면, MyPanel test1 = new MyPanel()처럼 타입자체를 커스텀해준다.

	}
}

