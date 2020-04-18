package simple.composite;

import lombok.Data;

@Data
public class BigBurger extends Burger {
	public BigBurger() {
		super(4000, "ºò¹ö°Å");
	}
	
	public BigBurger(int price, String desc) {
		super(price, desc);
	}
	
	public static void main(String[] args) {
		System.out.println(new BigBurger().getPrice());
	}
}

