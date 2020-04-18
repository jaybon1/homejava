package stars1;

// 인터페이스는 추상 클래스와 유사
// 다른점 : 추상 메서드만 존재가능
// 동적 바인딩의 통로로만 사용
// 메서드에 public abstract를 생략가능
// 제작자와 이용자의 약속 - 키보드에서 a를 누르면 작동원리를 몰라도 컴퓨터에 a가 입력된다
// 프로토콜 : 동등한 관계의 상호 협의하에 이루어진 약속
// 인터페이스 : 제작자가 사용법만 알려주고 이용자가 사용하는 식의 약속

public interface Behavior {
	public abstract void move();

	public void repair();

	void attack(Behavior unit);

	
	public String getName();
	
	public int getHp();
	
	public void setHp(int hp);
}


