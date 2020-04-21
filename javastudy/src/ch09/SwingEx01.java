package ch09;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEx01 extends JFrame {
	
	public SwingEx01() {
		Container contentPane = getContentPane(); // 패널객체에 접근
		// JFrame의 기본패널은 Border인데 Flow로 바꿔줌
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JButton("첫번째 버튼")); // 버튼을 소환
		contentPane.add(new TextArea(3, 30));
		setTitle("300x300 스윙 프레임 만들기");
		setSize(300, 300);
		setVisible(true); // painting 이때 그림이 그려짐
	}
	
	public static void main(String[] args) {
		new SwingEx01();
	}
}
