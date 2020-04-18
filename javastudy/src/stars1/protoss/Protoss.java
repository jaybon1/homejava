package stars1.protoss;

import stars1.Behavior;

public abstract class Protoss implements Behavior {

	// 움직임과 쉴드 치료는 프로토스 유닛 공통이기 때문에 추상 클래스에 바로 만들어준다

	@Override
	public void move() {
		System.out.println("이동");
		
	}
	
	@Override
	public void repair() {
		System.out.println("쉴드 치료");
		
	}
	
	public static void upgrade() {
		Zealot.attack++;
		Dragoon.attack++;
		System.out.println("프로토스 업그레이드 완료");
	}
}
