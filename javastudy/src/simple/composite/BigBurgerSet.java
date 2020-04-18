package simple.composite;

import lombok.Data;

// 자바는 다중 상속이 안됨 (부모가 여럿이 될 수 없음)

@Data
public class BigBurgerSet {
	// 콤포지션(중요) - 상속이 아닌 만들어 놓은 클래스를 가져오는 것
	private BigBurger bigBurger;
	private Coke coke;
	private FrenchFried frenchFried;
	
	public BigBurgerSet() {
		this(new BigBurger(), new Coke(), new FrenchFried());
	}
	
	public BigBurgerSet(BigBurger bigBurger) {
		this.bigBurger = bigBurger;
		this.coke = new Coke();
		this.frenchFried = new FrenchFried();
	}

	public BigBurgerSet(BigBurger bigBurger, Coke coke, FrenchFried frenchFried) {
		this.bigBurger = bigBurger;
		this.coke = coke;
		this.frenchFried = frenchFried;
	}
	
	public static void main(String[] args) {
		System.out.println(new BigBurgerSet().getBigBurger());
	}

}
