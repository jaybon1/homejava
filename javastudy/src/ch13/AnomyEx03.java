package ch13;

class Car {
	void run() {
		System.out.println("자동차는 달린다");
	}
}

class Sonata extends Car {

}

class Granger extends Car {

}



public class AnomyEx03 {
	
	static void start(Car car) {
		car.run();
	}
	
	public static void main(String[] args) {
		start(new Sonata());
	}
}
// 이런상황에서는 익명클래스를 만들 필요가 없다