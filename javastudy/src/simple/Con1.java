package simple;

class Animal1{
	String name;
	String sound;
	
	public Animal1(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}
	
	// 오버로딩
	public Animal1(String sound) {
		this("사람", sound);
	}
	
	// 오버로딩1
	public Animal1() {

	}
	
}




public class Con1 {
	public static void main(String[] args) {
		
		
		
	}
}
