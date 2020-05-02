package Test3;

class Be{
	private int num = 1;
	
	public int getNum() {
		return num;
	}
}


class Ani extends Be{
	private int num = 2;
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = this.num + num;
	}
}


public class Human extends Ani {
	private int num = 3;
	
	public Human() {
		this.setNum(5);
	}
	
	public static void main(String[] args) {
		Human h = new Human();
		
		System.out.println(h.getNum());

	}
}

