package ch03;

public class Cal {
	static int add(int n1, int n2) {
		int result = n1 + n2;
		// System.out.println("result : " + result);
		return result; // Ư¡: return�� ���� ��������!
	}

	static int minus(int n1, int n2) {
		return n1 - n2;
	}

	static int multi(int n1, int n2) {
		return n1 * n2;
	}

	static int devide(int n1, int n2) {
		return n1 / n2;
	}
}