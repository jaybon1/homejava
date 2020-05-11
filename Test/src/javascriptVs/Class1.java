package javascriptVs;

class TestClass {
	private int num;
	
	public TestClass(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
}

public class Class1 {
	public static void main(String[] args) {
		
		TestClass tc = new TestClass(1);
		
		System.out.println(tc.getNum());
		
	}
}

