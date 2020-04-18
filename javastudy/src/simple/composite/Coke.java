package simple.composite;

import lombok.Data;

@Data
public class Coke {
	private int price;
	private String desc;
	
	public Coke() {
		this(1500, "코카콜라");
	}
	
	public Coke(int price, String desc) {
		this.price = price;
		this.desc = desc;
		System.out.println(desc + "가 만들어졌습니다.");
	}
	
	public static void main(String[] args) {
		System.out.println(new Coke().getPrice());
	}
}
