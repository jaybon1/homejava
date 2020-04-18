package simple;

abstract class Animal {  // abstract 는 추상 클래스, new로 호출하지 못함
	
	// 오버라이딩 하려면 원본 메서드가 필요하다.
	abstract String getName(); // 추상 메서드, 동적 바인딩 용도
}


class Mouse extends Animal {

	@Override
	String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}

class Dog extends Animal {
	final String NAME = "강아지";
	
	// 오버라이딩
	String getName() {
		return NAME;
	}
}

class Cat extends Animal {
	final String NAME = "고양이";
	
	// 오버라이딩
	String getName() {
		return NAME;
	}
}

class Bird extends Animal {
	final String NAME = "새";

	// 오버라이딩
	String getName() {
		return NAME;
	}
}

public class AnimalEx01 {
	
	
	// 매개변수를 Animal 타입으로 받으니 Dog Cat Bird가 묵시적 업캐스팅이 된다.
	// Animal에는 NAME이 없으니 빨간줄이 뜬다. 
	// 그것을 해결 하려면 오버라이딩을 사용한다.
	// 변수 호출은 자료형 기준이다.
	// 함수(메서드)호출은 생성자 기준이다.(오버라이딩)
	// 자식의 오버라이딩을 찾아 내려가는 것을 동적 바인딩이라고 한다.
	static void attack(Animal u1, Animal u2) {
		System.out.println(u2.getName() + "가 " + u1.getName() + "에게 공격 당했습니다.");
	}

	public static void main(String[] args) {

		Dog d1 = new Dog();
		Cat c1 = new Cat();
		Bird b1 = new Bird();

		System.out.println(d1.NAME + "탄생");
		System.out.println(c1.NAME + "탄생");
		System.out.println(b1.NAME + "탄생");

		// 강아지 vs 고양이
		attack(d1, c1);

		// 강아지 vs 새
		attack(d1, b1);

		// 고양이 vs 새
		attack(c1, b1);

	}

}
