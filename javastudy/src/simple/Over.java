package simple;

public class Over {
	
	static String 성수야() {
		
		return "네?";
		
	}
	

	static String 성수야(String 할말) {
		
		if(할말.equals("밥먹자")) {
			
			return "안되요, 공부해야됩니다";
			
		} else if(할말.equals("술먹자")){
			
			return "지금 바로 가시죠";
			
		} else {
			
			return "네?";
			
		}
	}
	
	
	public static void main(String[] args) {
		
		
		System.out.println(성수야());
		
		System.out.println();
		
		System.out.println(성수야("밥먹자"));
		
	}
}
