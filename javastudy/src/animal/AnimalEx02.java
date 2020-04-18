package animal;

// 인터페이스를 만들면 모든 코드를 그것에 맟춰서 만들어야 한다. (표준)
// 또한 조종기 역할을 할 수 있다. (틀이 정해져 있기때문에 데이터를 사용하기 좋다.)


// 추상클래스는 구체클래스들의 공통점을 뽑아서 만드는 (상향식)
// 인터페이스는 미리 규칙을 만들고 강제성을 부여 (하향식), 다만 필요한 경우 추가할 수 있다.

// 인터페이스를 먼저 제시하고 구체적인 것을 구현하게 만든다.
interface Animal{
	void run();
	void sound();
}


class Dog implements Animal{

	@Override
	public void run() {
		System.out.println("강아지 달린다");
		
	}

	@Override
	public void sound() {
		System.out.println("멍멍");
		
	}


}

class Bird implements Animal {

	@Override
	public void run() {
		System.out.println("새는 달린다");
		
	}

	@Override
	public void sound() {
		System.out.println("짹짹");
		
	}
	
	public void fly() {
		System.out.println("새는 난다");
	}
}

public class AnimalEx02 {
	
	static void start(Animal a) {
		try {
			a.run();
			a.sound();
//			if(a instanceof Bird) { // Bird 클래스로 만든 인스턴스인 것을 확인
//				((Bird)a).fly();
//			}
			((Bird)a).fly();
		} catch (Exception e) {
			System.out.println("ㄹ어ㅏㅣㅁ");
		}

	}
	
	public static void main(String[] args) {
		start(new Dog());
		start(new Bird());
	}
}
