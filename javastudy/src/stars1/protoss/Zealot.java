package stars1.protoss;

import stars1.Behavior;

public class Zealot extends Protoss {
	private String name;
	private int hp;
	private int sh; // º¸È£¸·
	static int attack = 10;

	public Zealot(String name) {
		this.name = name;
		this.hp = 100;
		this.sh = 100;
	}

	@Override
	public void attack(Behavior unit) {
		unit.setHp(unit.getHp() - attack);
	}
	
	@Override
	public int getHp() {
		return hp;
	}

	@Override
	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	public String getName() {
		return name;
	}

}