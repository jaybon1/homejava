
package Test3;

class A{
	
	// �θ�� hello�޼��尡 ����
	
}

class B extends A{
	
	public void hello() { // �ڽĿ��Ը� �޼��尡 �ִ�
		System.out.println("hello");
	}
	
}


public class Sang1 {
	public static void main(String[] args) {
		
		
		// BŸ���� B�����ڷ� ���� �ν��Ͻ��� hello�޼��带 ����� �� �ִ�.
		
		B test1 = new B();
		test1.hello();
		
		
		// AŸ���� A�����ڷ� ���� �ν��Ͻ��� hello�޼��尡 �翬�� ����.
		
		A test2 = new A();
		test2.hello();
		
		
		// AŸ���� B�����ڷ� ���� �ν��Ͻ��� AŬ������ hello�޼��尡 ���� ������ �������̵��� �ȵǸ�
		// �������̵��� �ȵǱ� ������ �ҷ��� �� ����.
		
		A test3 = new B();
		test3 = (B)test3;
		
		
		// �ذ��1 - �θ� hello�޼��带 ����� �ش�.
		// �ذ��2 - JPanel �� �ڹ� ����Ŭ�������, MyPanel test1 = new MyPanel()ó�� Ÿ����ü�� Ŀ�������ش�.

	}
}

