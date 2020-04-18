package stars1.zerg;

import stars1.Behavior;

public abstract class Zerg implements Behavior{
	// 움직임과 쉴드 치료는 프로토스 유닛 공통이기 때문에 추상 클래스에 바로 만들어준다

	public void move() {
		System.out.println("이동");
	}

	public void repair() {
		System.out.println("SCV 치료");
	}

	// 공격은 근거리 원거리 등 다르기때문에 추상 메서드로만 생성
	// public abstract void attack();

	public static void upgrade() {
		Hydra.attack++;
		Ultra.attack++;
		System.out.println("프로토스 업그레이드 완료");
	}

}
