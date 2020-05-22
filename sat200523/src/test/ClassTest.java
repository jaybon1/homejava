package test;

class 스마트폰 {
	
	private String name;
	
	
	public 스마트폰(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
}

public class ClassTest {
	
	public static void main(String[] args) {
		
		// 1번 방식
		
		스마트폰 sp1 = new 스마트폰("s10");
		 
		System.out.println(sp1.getName());
		
		
		// 2번 방식
		System.out.println(new 스마트폰("s20").getName());
		 
	}

}











