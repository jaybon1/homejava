package test;

class 소고기 {
	
	private String 부위 = "우삼겹";

	public String get부위() {
		
		return 부위;
		
	}
}

public class Test2 {

	public static void main(String[] args) {

		소고기 s1 = new 소고기();		

		System.out.println(s1.get부위());

	}

}
