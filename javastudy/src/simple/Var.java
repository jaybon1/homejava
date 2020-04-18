package simple;


public class Var {
	int num = 1;
	
	public Var() {
		
	}

	// 변수는 자료를 담는 집이다

	public static void main(String[] args) {

		// 기본 자료형 변수는 int, char 등의 자료를 담는다
		
		int one = 0;
		
		
		// 기본자료형은 메서드가 없다
		
		// one.
		
		
		// String은 기본자료형과 클래스타입의 속성을 모두 가지고 있다
		// new를 하지 않아도 생성됨, 인스턴스명으로 데이터를 저장할 수있다
		
		String root; //선언
		
		root = "감자"; // 초기화
		
		root = "고구마"; // 변수값 변경
		
		
		// String은 메서드를 가지고있다
		System.out.println(root.substring(0,1));
		
		
		
		// 기본적인 인스턴스 생성방법
		
		Var test0 = new Var();
		
		test0.num = 2;
		
		
		
		
		// final이 붙으면 '초기화' 이후 값을 변경할 수 없다
		
		final String fruit;
		
		fruit = "사과";
		
		//fruit = "오렌지";
		
		
		// 한 라인에 두가지 변수를 선언 할 수 있다.
		int n1, n2;

		int 숫자1 = 1;

		char 글자1 = '가';

		
		
	
		// 참조 자료형 변수 String, ArrayList, 클래스타입, Integer, Character

		// 레퍼런스 변수

		// 참조 자료형 변수는 주소를 담는다. 주소를 찾아가면 집에 갈수 있다
		
		

		Var test = new Var();
		
		Var test1 = test; // test 의 주소를 test1 이 받는다
		
		
		System.out.println(숫자1);

		System.out.println(글자1);

		System.out.println(test + " <- test라는 레퍼런스 변수, 주소가 출력된다 ");
		
		System.out.println(test1 + " <- test와 같은 주소가 출력된다");
		
		System.out.println(new Var() + " <- 새로 만들어진 인스턴스");
		
		System.out.println(new Var() + " <- 코드에서 1회만 사용할 경우 이렇게 쓴다");
		
		System.out.println(test.num);
		
		System.out.println(new Var().num); 
		
		// new 가 띄워쓰기 되어있다고 객체가 아니라고 생각 할 수 있지만
		// new Var() 자체가 객체(인스턴스)다
		
		
		// 2 > 1 은 띄워져있지만 결국 한덩어리, true가 된다
		System.out.println(true);
		
		System.out.println(2 > 1);
		
		
		

		
		
		
		
//		1. class - 추상적인 설계도, 또는 구체적인 설계도
//
//		추상 클래스 - 가구 - 사람이 상상해서 그 물건의 특성을 떠올릴 수 있지만 실제로 만들 수 없는것
//
//				ex) 의자은 가구의 구체개념이지 의자 자체가 아니다
//
//		구체 클래스 - 의자 - 사람이 상상할 수 있고 제조법이 명확하다
//
//
//
//		2. Object - 실제로 존재할 수 있는 것을 상상 - 만들어질 의자를 머리 속으로 상상(구체 클래스)
//
//
//
//		3. Instance - 클래스를 통해 Object가 실체화 된 것 - 만들어진 의자 (new)
		
		
		//https://npcore.tistory.com/18

	}

}






























