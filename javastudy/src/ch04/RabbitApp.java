package ch04;

class Rabbit {
	private String name; // heap변수, 전역변수, 맴버변수, 필드, 속성, 프로퍼티
	private int power;

	public Rabbit(String name, int power) {
		this.name = name;
		this.power = power;
	}

	// 행위 - 객체에 접근하는 것을 메서드로 하는게 객체지향의 시작
	// 변수를 변경하는 행위는 신중하게 접근자를 선택해야한다
	// 메서드는 그 클래스의 책임을 담당한다 (중요)
	boolean drink() {
		if (power >= 100) {
			return false;
		}
		power++;
		return true;
	}

	
//	void drink() {
//		if (power < 100) {
//			power++;
//		}
//	}

	public int getPower() {
		return power;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	

}

public class RabbitApp {
	public static void main(String[] args) {
		Rabbit r1 = new Rabbit("토끼", 20); // power 는 100이 max라고 가정
		System.out.println(r1.getPower());
		r1.drink();
		System.out.println(r1.getPower());
		r1.drink();
		System.out.println(r1.getPower());

		while (r1.drink()) {}
		System.out.println(r1.getPower());
		
		
		//이름변경
		r1.setName("산토끼");
		System.out.println(r1.getName());
	}
}
