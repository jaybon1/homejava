package ch14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


// �͸� Ŭ������ Ÿ�� ����
public class EventEx01 extends JFrame {
	
	public EventEx01() {
		setTitle("Action �̺�Ʈ ������ ����");
		
		// x��ư Ŭ���� �̺�Ʈ �й轺���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		
		// ������ ����
		btn.addActionListener(new ActionListener() {
			
			// Ÿ�� (�̺�Ʈ �й� �����尡 �ݹ�)
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ưŬ����");
				
				// e�� context, e.getSource()�� �̺�Ʈ �ҽ�
				JButton b = (JButton) e.getSource();
				System.out.println(b.getText());
				b.setText("�׼�"); // RePaint()
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