package Frame;

import javax.swing.JFrame;



public class FrameTest2A { // 아무것도 상속받지 않은 클래스
	
	private JFrame frame; // 클래스 내부에 다른 클래스의 레퍼런스를 준비

	public FrameTest2A() { // 클래스 생성자
		
		frame = new JFrame(); // JFrame 인스턴스 생성
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 엑스버튼 누르면 프로그램 종료
		
		// 순서대로 시작 x좌표, y좌표 // 넓이, 높이
		frame.setBounds(0, 0, 500, 500);
		
	}
	
	public static void main(String[] args) {
		
		FrameTest2A ft2a = new FrameTest2A(); // 메인에서 FrameTest2A 클래스의 인스턴스 생성
		
		// 프레임을 화면에 보이게 하는것
		// 프레임이 화면에 떠 있는 것이 프로그램을 유지 시킨다 (증거로 setVisible(false)를 하면 프로그램이 종료된다)
		ft2a.frame.setVisible(true);
		
	}
}

