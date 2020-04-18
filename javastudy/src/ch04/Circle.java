package ch04;

public class Circle {
	private int radius;
	private String name;

	public Circle() {
	};

	public double getArea() {
		return 3.14 * radius * radius;
	}

	void setRadius(int radius) {
		this.radius = radius;
	}

	void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Circle pizza = new Circle();
		pizza.setName("효선피자");
		pizza.setRadius(10);
		System.out.println(pizza.getArea());;
		
		Rectangle r1 = new Rectangle();
		r1.
	}
}
// 화이팅!!!
