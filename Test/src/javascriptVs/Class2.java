package javascriptVs;

public class Class2 {
	
	static void setNum(int b) {
		b = 2;
	}
	
	public static void main(String[] args) {
		int a = 1;
		setNum(a);
		System.out.println(a);
	}
}
