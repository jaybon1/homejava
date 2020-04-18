package ch05;

// 어댑터

interface 칼 {
	abstract void kill();

	abstract void cook();

	abstract void repair();
}


// 상속 받는 추상 클래스는 부모 클래스의 모든 클래스를 오버라이딩 할 필요가 없다.
// 요리사 어댑터 - 필요없는 기능만 입력한다. (cook메서드만 자식클래스에 구현을 미룬다.)
abstract class 요리사 implements 칼 {
	
	@Override
	public void kill() {}
	
	@Override
	public void repair() {}

}

// 요리사 클래스가 구현하지 않은 기능만 구현하면 된다.
class 백종원 extends 요리사{

	@Override
	public void cook() {
		// TODO Auto-generated method stub	
	}
}

public class FoodEx03 {

	
	public static void main(String[] args) {
		백종원 b1 = new 백종원();

	}
}
