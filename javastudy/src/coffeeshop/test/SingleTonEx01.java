package coffeeshop.test;

class Aaa{
	int a = 1;
	String aa = "집"; // 집 / 집주소
	
}


// 싱글톤 패턴
class 국민은행통장 {
	int 돈 = 0;
	
	private static 국민은행통장 통장1  = new 국민은행통장();
	
	public static 국민은행통장 get통장1() {
		return 통장1;
	}
}


public class SingleTonEx01 {

	public static void main(String[] args) {

		
		국민은행통장 d1 = 국민은행통장.get통장1();
		국민은행통장 d2 = 국민은행통장.get통장1();
		System.out.println(d1.돈);
		d1.돈 = 1000;
		
		System.out.println(d1.돈);
		
		d2.돈 = d2.돈 + 1000;
		
		System.out.println(d1.돈);
	
		
		// d1 은  d2와 같다
	}
}


//싱글톤은 해당 객체가 프로그램 안에 딱 1개 있는 것  