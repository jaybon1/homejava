package javascriptVs;

class A {

	void Callback() {
		System.out.println("�ݹ��� �����մϴ�.");
	}

}

public class FirstClass {

	static void method(A callbackClass) {

		callbackClass.Callback();

		System.out.println("�ݹ� ������ Ȯ�� �߽��ϴ�.");

	}

	public static void main(String[] args) {

		method(new A());

	}

}

