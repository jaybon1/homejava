package javascriptVs;

class A {

	void Callback() {
		System.out.println("콜백을 시전합니다.");
	}

}

public class FirstClass {

	static void method(A callbackClass) {

		callbackClass.Callback();

		System.out.println("콜백 내용을 확인 했습니다.");

	}

	public static void main(String[] args) {

		method(new A());

	}

}

