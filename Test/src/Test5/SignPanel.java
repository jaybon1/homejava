package Test5;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SignPanel extends JPanel {
	
	private JLabel testLa;

	public SignPanel() {
		testLa = new JLabel("ȸ�������г�");
		testLa.setBounds(0,0, 100, 20);
		add(testLa);
	}
}
