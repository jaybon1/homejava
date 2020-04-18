package simple.composite;

import lombok.Data;

@Data // getter, setter 생성
public class Burger {
	private int price;
	private String desc;

	public Burger() {
		this(1500, "기본버거");
	}

	public Burger(int price, String desc) {
		this.price = price;
		this.desc = desc;
		System.out.println(desc + "가 만들어졌습니다.");
	}
	
	public static void main(String[] args) {
		System.out.println(new Burger().getPrice());
	}
}
