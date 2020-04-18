package simple.composite;

public class 라면1 {
	String item1;
	String item2;
	String item3;

	public 라면1(String item1, String item2, String item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}

	public 라면1() {
		this("물", "건더기스프", "분말스프");
	}

	public 라면1(String item1) {
		this(item1, "건더기스프", "분말스프");
	}

	public static void main(String[] args) {
		라면1 l1 = new 라면1("불", "건더기스프", "분말스프");
		System.out.println(l1.item1);
		라면1 l2 = new 라면1();
		System.out.println(l2.item1);
		라면1 l3 = new 라면1("쌀뜨물");

	}
}
