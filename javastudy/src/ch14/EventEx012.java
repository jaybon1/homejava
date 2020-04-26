package ch14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


// ���� Ŭ������ ActionListener�� �����ϰ� this�� ��ü�� �������� Ÿ������ �����
public class EventEx012 extends JFrame implements ActionListener {
	
	public EventEx012() {
		setTitle("Action �̺�Ʈ ������ ����");
		
		// x��ư Ŭ���� �̺�Ʈ �й轺���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		
		// ������ ����
		btn.addActionListener(this);
		c.add(btn);
		setSize(350,150);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ư Ŭ����");
	}
	
	public static void main(String[] args) {
		EventEx012 ex012 = new EventEx012();
	}
}

