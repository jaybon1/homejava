package ch13;

class Car {
	void run() {
		System.out.println("�ڵ����� �޸���");
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
// �̷���Ȳ������ �͸�Ŭ������ ���� �ʿ䰡 ����