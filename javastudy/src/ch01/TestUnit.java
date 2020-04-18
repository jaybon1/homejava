package ch01;

abstract class Unit{
	Point P;
               //상속 받은부분에서 move(Point p) 메서드 재정의해야 사용가능하다.
	abstract void move(Point p);
               //공통적으로 쓸 메서드
	void stop(){
		System.out.println("정지");
	}
}

class Point {
	int x;
	int y;
	
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
}

class Marine extends Unit{ // 보병을 정의한 클래스
	void move(Point p) {
		System.out.println("마린이 언덕을 돌아감 좌표는x : " +p.x + " y : " + p.y);

	}
	void stimPack() {
		System.out.println("스팀패애애액~~~~~~");
	}
}

class Tank extends Unit{ // 탱크에 관한 클래스
	void move(Point p) {
		System.out.println("탱크가 뒤뚱뒤뚱");
	}
	void changeMode() {
		System.out.println("모드변경 쓍 퉁~~~~~~");
	}
}

class Dropship extends Unit{ // 드랍쉽을 정의한 클래스
	void move(Point p) {
		System.out.println("sdfsdf");
	}
	void load() {

	}

	void unload() {
		
	}
}


public class TestUnit {
	public static void main(String[] args) {
		Marine m1 = new Marine();
		Point p1 = new Point(100, 100);
		
		m1.move(p1);
	}
}













