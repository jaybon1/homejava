package stars1.zerg;

import stars1.Behavior;

public class Ultra extends Zerg{
	private String name;
	private int hp;
	public static int attack = 50;
	
	public Ultra(String name) {
		this.name = name;
		this.hp = 100;
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
		return name;
	}
}