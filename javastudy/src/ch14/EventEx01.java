package ch14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


// 익명 클래스로 타겟 생성
public class EventEx01 extends JFrame {
	
	public EventEx01() {
		setTitle("Action 이벤트 리스너 예제");
		
		// x버튼 클릭시 이벤트 분배스레드 끄기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		
		// 리스너 생성
		btn.addActionListener(new ActionListener() {
			
			// 타겟 (이벤트 분배 스레드가 콜백)
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼클릭됨");
				
				// e는 context, e.getSource()는 이벤트 소스
				JButton b = (JButton) e.getSource();
				System.out.println(b.getText());
				b.setText("액션"); // RePaint()
			}
		});
		c.add(btn);
		setSize(350,150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EventEx01();
	}
}