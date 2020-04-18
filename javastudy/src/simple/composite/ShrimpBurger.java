package simple.composite;

import lombok.Data;

@Data
public class ShrimpBurger extends Burger {

	public ShrimpBurger() {
		super(3500, "쉬림프버거");
	}

	public ShrimpBurger(int price, String desc) {
		super(price, desc);
	}
	
	public static void main(String[] args) {
		System.out.println(new ShrimpBurger().getPrice());
	}
}
