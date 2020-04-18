package ch05;


// 추상 클래스는 일반 메서드를 가질 수 있다.
// 추상 클래스는 내가 구현할 수 없는 메서드를 오브젝트에게 미룰 수 있다.
// 추상 클래스는 abstract를 붙인다.
// 추상 클래스를 통해서 순서를 정할 수 있다.
abstract class Food {
	
	abstract void standby();
	
	// protected는 자식만 사용가능
	
	protected void eat() {
		System.out.println("음식을 먹습니다."); // 공통적인것은 사용
	}

	abstract void cook(); // 공통적인데 오브젝트마다 조금씩 다르다면 추상메서드 사용
	
	void auto() {  // 이렇게 제작하면 순서 실수를 하지 않는다 (요리 -> 섭취)
		standby();
		cook();
		eat();
	}
}

class 라면 extends Food {
	
	

	@Override
	void cook() {
		System.out.println("냄비에 끓입니다.");

	}

	@Override
	void standby() {
		System.out.println("라면과 냄비를 준비합니다.");
		
	}

}

class 삼겹살 extends Food {

	@Override
	void cook() {
		System.out.println("불판에 굽습니다.");
	}
	
	@Override
	void standby() {
		System.out.println("고기와 불판을 준비합니다.");
		
	}

}

public class FoodEx02 {
	
	static void start(Food f) {
		f.auto();
	}
	
	
	public static void main(String[] args) {
		start(new 라면());
	}
}
