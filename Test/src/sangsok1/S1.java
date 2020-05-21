package sangsok1;

class 음식 {
	public String 섭취(){		
		return "음식을 섭취합니다";
	}
}

class 음료 extends 음식 {
}

class 술 extends 음료 {
	
	public String 섭취(){
		return "술을 섭취합니다";
	}
}

class 위스키 extends 술 {
	
	public String 섭취(){
		return "위스키를 섭취합니다";
	}
}

public class S1 {
	public static void main(String[] args) {
		음식 f1 = new 음식();
		System.out.println(f1.섭취() + "\n");
		
		술 ff1 = new  위스키();
		System.out.println(ff1.섭취() + "\n");

		음료 f2 = new 음료();
		System.out.println(f2.섭취() + "\n");

		음식 f5 = new 위스키();
		System.out.println(f5.섭취() + "\n");
	}
}