package simple.coffee;

import lombok.Data;

@Data // getter, setter 자동생성
public class Coffee {
	private String name;
	private int price;
	
	public Coffee(MenuItem menuItem) {
		this.name = menuItem.getName();
		this.price = menuItem.getPrice();
	}
}
