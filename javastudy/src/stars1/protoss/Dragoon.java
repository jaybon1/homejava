package stars1.protoss;

import stars1.Behavior;

public class Dragoon extends Protoss{
	private String name;
	private int hp;
	private int sh; // º¸È£¸·
	public static int attack = 15;
	
	public Dragoon(String name) {
		this.name = name;
		this.hp = 100;
		this.sh = 100;
	}

	@Override
	public void attack(Behavior unit) {
		unit.setHp(unit.getHp() - attack);
		System.out.println(unit.getHp());
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}