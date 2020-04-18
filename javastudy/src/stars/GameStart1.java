package stars;

abstract class Protoss {  // ��ü�� ���� ���� �������̵� �Ҷ���  implement ����Ѵ�
	
	// �ʼ� �޼���
	abstract public String getNAME();

	abstract public int getHp();

	abstract public void setHp(int hp);

	abstract public int getAttack();
	
	abstract public void setAttack(int attack);

}

class Zealot extends Protoss {

	private final String NAME; // �ѹ� �ʱ�ȭ�ϸ� Read Only , �빮�ڷ� ���� ���� ���
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

		// ���ݴ��� ���� ü�� ����
		u2.setHp(u2.getHp() - u1.getAttack());

		// �޽������
		System.out.println(u2.getNAME() + "�� " + u1.getNAME() + "�� ���ؼ� ���ݴ��ϰ� �ֽ��ϴ�.");
		if (u2.getHp() <= 0) {
			System.out.println(u2.getNAME() + "�� ü���� : " + u2.getHp() + "�Դϴ�.");
			System.out.println(u2.getNAME() + "�� �׾����ϴ�.");
		} else {
			System.out.println(u2.getNAME() + "�� ü���� : " + u2.getHp() + "�Դϴ�.");
		}
	}

	public static void main(String[] args) {

		// ���ݷ� ���׷��̵��ϱ�
		Zealot.attack++;
		

		// ���� �����ϱ�
		Protoss z1 = new Zealot("1������");
		System.out.println(z1.getNAME() + Zealot.attack);

		Protoss z2 = new Zealot("2������");
		System.out.println(z2.getNAME() + Zealot.attack);

		Protoss d1 = new Dragoon("1�����");
		Protoss d2 = new Dragoon("2�����");

		Protoss dt1 = new DarkTempler("1�� ��ũ���÷�");
		Protoss dt2 = new DarkTempler("2�� ��ũ���÷�");

		Protoss r1 = new River("1�� ����");
		Protoss r2 = new River("2�� ����");

		// �����ϱ�
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