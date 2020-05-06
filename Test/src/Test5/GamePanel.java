package Test5;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private JLabel testLa;

	public GamePanel() {
		testLa = new JLabel("게임패널");
		testLa.setBounds(0, 0, 100, 20);
		add(testLa);
	}
}
