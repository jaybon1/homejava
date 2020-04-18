package ch04;

class AirPlane {
	String name;
	String color;

	public AirPlane(String name, String color) {

		// this는 동적으로 heap공간을 가리킨다
		this.name = name;
		this.color = color;
	}

}

public class ThisTestEx01 {
	public static void main(String[] args) {
		AirPlane a1 = new AirPlane("제트기", "하얀색");
	}
}
