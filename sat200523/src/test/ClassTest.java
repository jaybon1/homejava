package test;

class ����Ʈ�� {
	
	private String name;
	
	
	public ����Ʈ��(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
}

public class ClassTest {
	
	public static void main(String[] args) {
		
		// 1�� ���
		
		����Ʈ�� sp1 = new ����Ʈ��("s10");
		 
		System.out.println(sp1.getName());
		
		
		// 2�� ���
		System.out.println(new ����Ʈ��("s20").getName());
		 
	}

}











