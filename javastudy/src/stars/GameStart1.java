package stars;

abstract class Protoss {  // 몸체가 없는 것을 오버라이딩 할때는  implement 라고한다
	
	// 필수 메서드
	abstract public String getNAME();

	abstract public int getHp();

	abstract public void setHp(int hp);

	abstract public int getAttack();
	
	abstract public void setAttack(int attack);

}

class Zealot extends Protoss {

	private final String NAME; // 한번 초기화하면 Read Only , 대문자로 적는 것이 약속
	private int hp = 100;
	static int attack = 10;

	public Zealot(String name) {
		this.NAME = name;
	}

	public String getNAME() {
		return NAME;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	

}

class Dragoon extends Protoss {

	private final String NAME;
	private int hp = 100;		
	static int attack = 15;

	public Dragoon(String name) {
		this.NAME = name;
	}

	public String getNAME() {
		return NAME;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}

}

class DarkTempler extends Protoss {

	private final String NAME;
	private int hp = 100;
	static int attack = 50;

	public DarkTempler(String name) {
		this.NAME = name;
	}

	public String getNAME() {
		return NAME;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}

}

class River extends Protoss {

	private final String NAME;
	private int hp = 100;
	static int attack = 70;

	public River(String name) {
		this.NAME = name;
	}

	public String getNAME() {
		return NAME;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}

}

public class GameStart1 {

	static void attack(Protoss u1, Protoss u2) {

		// 공격당한 유닛 체력 조정
		u2.setHp(u2.getHp() - u1.getAttack());

		// 메시지출력
		System.out.println(u2.getNAME() + "이 " + u1.getNAME() + "에 의해서 공격당하고 있습니다.");
		if (u2.getHp() <= 0) {
			System.out.println(u2.getNAME() + "의 체력은 : " + u2.getHp() + "입니다.");
			System.out.println(u2.getNAME() + "이 죽었습니다.");
		} else {
			System.out.println(u2.getNAME() + "의 체력은 : " + u2.getHp() + "입니다.");
		}
	}

	public static void main(String[] args) {

		// 공격력 업그레이드하기
		Zealot.attack++;
		

		// 질럿 생성하기
		Protoss z1 = new Zealot("1번질럿");
		System.out.println(z1.getNAME() + Zealot.attack);

		Protoss z2 = new Zealot("2번질럿");
		System.out.println(z2.getNAME() + Zealot.attack);

		Protoss d1 = new Dragoon("1번드라군");
		Protoss d2 = new Dragoon("2번드라군");

		Protoss dt1 = new DarkTempler("1번 다크템플러");
		Protoss dt2 = new DarkTempler("2번 다크템플러");

		Protoss r1 = new River("1번 리버");
		Protoss r2 = new River("2번 리버");

		// 공격하기
		attack(z1, d1);
		attack(z1, z2);
		attack(z1, dt1);
		attack(z1, r1);

		attack(d1, z1);
		attack(d1, d2);
		attack(d1, dt1);
		attack(d1, r1);

		attack(dt1, z1);
		attack(dt1, dt2);
		attack(dt1, d1);
		attack(dt1, r1);

		attack(r1, z1);
		attack(r1, r2);
		attack(r1, d1);
		attack(r1, dt1);

	}
}
