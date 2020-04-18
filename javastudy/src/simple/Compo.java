package simple;

class 음료 {
	String name;

	public 음료(String name) {
		this.name = name;
	}
}

class 과자 {
	String name;

	public 과자(String name) {
		this.name = name;
	}
}

class 바구니 {
	음료 drink;
	과자 snack;
	
	public 바구니(음료 drink, 과자 snack) {
		this.drink = drink;
		this.snack = snack;
	}
}

public class Compo {
	public static void main(String[] args) {
		
		음료 d1 = new 음료("솔의눈");
		과자 s1 = new 과자("치토스");
		
		바구니 a = new 바구니(d1,s1);
		
		System.out.println(a.drink.name);
	}
}
