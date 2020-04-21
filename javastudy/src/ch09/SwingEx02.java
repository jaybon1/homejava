package ch09;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEx02 extends JFrame {
	
	public SwingEx02() {
		setTitle("ControlPane과 JFrame");
		
		// 엑스버튼 누르면 프로그램 종료하도록 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// 컨텐트팬을 알아낸다
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.orange);
		
		// 컨텐트팬에 FlowLayout 배치관리자 달기
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(300, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingEx02();
	}
}
