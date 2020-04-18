package Chat;

interface StarUnit {
	int getHp();
}

abstract class Protoss implements StarUnit{
	abstract int getSh();
}

abstract class Zerg implements StarUnit {}

class Zealot extends Protoss {
	int sh = 100;
	int hp = 100;
	
	@Override
	public int getSh() {
		return sh;
	}
	
	@Override
	public int getHp() {
		return hp;
	}
}

class Ultra extends Zerg {
	int hp = 100;
	
	@Override
	public int getHp() {
		return hp;
	}
	
}

public class FinallyEx01 {
	
	// 상태체크 (hp, sh)
	static void check(StarUnit unit) {
		try {
			Zealot z = (Zealot)unit;
			System.out.println("쉴드" + z.getSh());			
			System.out.println("체력" + z.getHp());			
		} catch (Exception e) {
			// 저그
			Ultra u = (Ultra)unit;
			System.out.println("저그는 쉴드가 없습니다.");
			System.out.println("남은 체력은 : " + u.getHp());
		} finally { // try 들어가면 무조건 실행된다
			System.out.println("나는 무조건 실행돼");
		}
	}
	
	public static void main(String[] args) {
		check(new Ultra());
	}
}
