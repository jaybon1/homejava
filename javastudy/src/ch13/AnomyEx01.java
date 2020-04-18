package ch13;

// 규약
interface Animal {
	void move(); // 추상메서드  - 추상메서드가 있으면 new를 할 수 없다 - 추상적이니 오브젝트가 될 수 없다 
}

abstract class Person {
	abstract void eat();
}

abstract class Person1 {
	void eat() {
		
	}
}

public class AnomyEx01 {
	public static void main(String[] args) {
		//Animal a = new Animal(); 추상 메서드가 구현 되어 있지 않아서 new 할 수 없다
		//Person p = new Person(); 추상 메서드가 구현 되어 있지 않아서 new 할 수 없다
		//Person1 p = new Person1(); 추상클래스는 추상메서드가 들어올 가능성이 있기 때문에 new를 막아둠
	}
}
