package ch13;

abstract class Ani {
	abstract void sound();
}

class Cat extends Ani {
	@Override
	void sound() {
		System.out.println("야옹");
	}
}

class Bird extends Ani {
	@Override
	void sound() {
		System.out.println("짹짹");
	}
}

class Fish extends Ani {
	@Override
	void sound() {
		System.out.println("뻐끔뻐끔");
	}
}

public class AnomyEx04 {

	static void start(Ani a) {
		a.sound();
	}

	public static void main(String[] args) {
		start(new Fish());
		
		start(new Ani() { // 한번쓰고 다시는 안쓸 것 같은 것은 익명클래스를 이용한다
			
			@Override
			void sound() {
				System.out.println("음메");
				
			}
		});
	}
}
