package simple.composite;

import lombok.Data;

@Data
public class ShrimpBurgerSet {

	// 콤포지션(중요) - 상속이 아닌 만들어 놓은 클래스를 가져오는 것
	private ShrimpBurger shrimpBurger;
	private Coke coke;
	private FrenchFried frenchFried;
	
	public ShrimpBurgerSet() {
		this(new ShrimpBurger(), new Coke(), new FrenchFried());
	}
	
	public ShrimpBurgerSet(ShrimpBurger shrimpBurger) {
		this(shrimpBurger, new Coke(), new FrenchFried());
	}
	
	public ShrimpBurgerSet(Coke coke) {
		this(new ShrimpBurger(), coke, new FrenchFried());
	}
	
	public ShrimpBurgerSet(FrenchFried frenchFried) {
		this(new ShrimpBurger(), new Coke(), frenchFried);
	}
	
	public ShrimpBurgerSet(ShrimpBurger shrimpBurger, Coke coke) {
		this(shrimpBurger, coke, new FrenchFried());
	}
	
	public ShrimpBurgerSet(ShrimpBurger shrimpBurger, FrenchFried frenchFried) {
		this(shrimpBurger, new Coke(), frenchFried);
	}
	
	public ShrimpBurgerSet(Coke coke, FrenchFried frenchFried) {
		this(new ShrimpBurger(), coke, frenchFried);
	}
	
	
	// 생성자가 제일 많은 것이 기준
	public ShrimpBurgerSet(ShrimpBurger shrimpBurger, Coke coke, FrenchFried frenchFried) {
		this.shrimpBurger = shrimpBurger;
		this.coke = coke;
		this.frenchFried = frenchFried;
	}
	
	public static void main(String[] args) {
		System.out.println(new ShrimpBurgerSet().getShrimpBurger());
	}
}