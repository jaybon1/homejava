package ch13;

interface Dog{
	void sound();
}

public class AnomyEx02 {
	
	static void start(Dog d) {
		d.sound();
	}
	
	public static void main(String[] args) {
		
		Dog d = new Dog() {  // 한번 쓰고 버릴때 익명클래스를 사용한다
			
			@Override
			public void sound() {
				System.out.println("멍멍");
				
			}
		};
		
		start(d);
		
	}
}
