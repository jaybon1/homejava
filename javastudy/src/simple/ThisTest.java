package simple;

import array03.Test1;

class SuperTest {

	public int test1;

	public SuperTest() {
		test1 = 132;
		System.out.println("슈퍼테스트");
	}

	public SuperTest(int test1) {
		this.test1 = test1;
		System.out.println("슈퍼테스트");
	}

}

public class ThisTest extends SuperTest {

	public int test1;

	public ThisTest() {
		super();
		System.out.println("디스테스트");
	}

	public static void main(String[] args) {
		SuperTest b = new SuperTest(123);

		System.out.println(b.test1);

		System.out.println("------------");

		ThisTest a1 = new ThisTest();

		System.out.println(a1.test1);

		System.out.println("------------");

		SuperTest a2 = new ThisTest();

		System.out.println(a2.test1);

	}
}