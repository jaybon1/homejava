package Test5;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClearPanel extends JPanel {
private JLabel testLa;

public ClearPanel() {
	testLa = new JLabel("����Ŭ�����г�");
	testLa.setBounds(0,0, 100, 20);
	add(testLa);
}
}
