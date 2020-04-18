package simple;

class Car {

	void run() {
		System.out.println("기본 움직임");
	}

}

class Sonata extends Car {

	// 오버라이드 : 부모 클래스의 메서드를 무효화 시키는 것 (재사용과는 다르다는 것을 주의)
	// [실행시!!]에 부모 메서드를 무시한다!
	// 동적 바인딩 (C언어에서는 동적 로딩 이라고 한다)
	@Override // 어노테이션
	void run() {
		super.run(); // super는 부모의 heap
		System.out.println("소나타만의 움직임");
	}
}

public class CarEx01 {

	public static void main(String[] args) {

		Car c1 = new Car();
		c1.run();

		System.out.println("----------");

		Car s1 = new Sonata();
		s1.run();

	}

}
