package ch05;

class 사람 {
	int num = 10;
}

class 아시아인 extends 사람 {
	int num = 30;

}

class 한국인 extends 아시아인 {

}

class 박서준 extends 한국인 {
	int num = 20;
}

public class EveryPerson {
	public static void main(String[] args) {

		박서준 b1 = new 박서준();
		System.out.println(b1.num);

		한국인 b2 = new 박서준(); // 한국인 자료형이지만 박서준 클래스의 데이터도 메모리에 떠 있다
		System.out.println(b2.num); 
		
		박서준 downB2 = (박서준)b2; // 업캐스팅이 선행되어 new를 한 경우 다운캐스팅이 가능하다
		System.out.println(downB2.num);
		
		System.out.println(((박서준)b2).num);

		사람 b3 = new 한국인();
		System.out.println(b3.num);

//		박서준 b4 = new 한국인(); //오류가 난다
//		System.out.println(b4.num);

	}
}
