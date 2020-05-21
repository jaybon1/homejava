package Test3;

import javax.swing.JFrame;



public class FrameTest1 { // 아무것도 상속받지 않은 클래스
	
	private JFrame frame; // 클래스 내부에 다른 클래스의 레퍼런스를 준비

	public FrameTest1() { // 클래스 생성자
		
		frame = new JFrame(); // JFrame 인스턴스 생성
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 엑스버튼 누르면 프로그램 종료
		
		frame.setLocationRelativeTo(null); // 화면을 모니터 정중앙에 배치
		
		// 순서대로 시작 x좌표, y좌표 // 넓이, 높이
		// 다만 위에서 frame.setLocationRelativeTo(null)을 했기 때문에 시작위치는 무엇을 입력해도 고정
		frame.setBounds(0, 0, 500, 500);
		
		// 프레임을 화면에 보이게 하는것
		// 프레임이 화면에 떠 있는 것이 프로그램을 유지 시킨다 (증거로 setVisible(false)를 하면 프로그램이 종료된다)
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new FrameTest1(); // 메인에서 FrameTest1 인스턴스 생성
		
	}
}
