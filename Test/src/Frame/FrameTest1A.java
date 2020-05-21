package Frame;

import javax.swing.JFrame;

public class FrameTest1A extends JFrame { // JFrame을 상속받은 클래스
	
	public FrameTest1A() { // 생성자
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로그램이 종료됨
		
		// 순서대로 시작 x좌표, y좌표 // 넓이, 높이
		setBounds(0, 0, 500, 500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new FrameTest1A();
	}

}
