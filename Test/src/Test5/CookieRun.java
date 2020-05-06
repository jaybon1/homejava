package Test5;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Button;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;

public class CookieRun extends listenAdapter {

	private JFrame frame;

	private IntroPanel introPanel; // ��Ʈ��

	private LoginPanel loginPanel; // �α���

	private SignPanel signPanel; // ȸ������

	private RankPanel rankPanel; // ��ŷ�г�

	private SelectPanel selectPanel; // ĳ���� �� �� ����

	private GamePanel gamePanel; // ��������

	private EndPanel endPanel; // ��������

	private ClearPanel clearPanel; // ���� Ŭ����

	private CardLayout cl; // ī�� �����̿� ������Ʈ

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CookieRun window = new CookieRun();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CookieRun() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cl = new CardLayout(0, 0); // ī�巹�̾ƿ� ��ü ����
		frame.getContentPane().setLayout(cl); // �������� ī�巹�̾ƿ����� ����

		introPanel = new IntroPanel();
		loginPanel = new LoginPanel(this); // this�� �� ���� - �� Ŭ������ ��ü�� �������� ���ҵ� �����ϱ� ����
		signPanel = new SignPanel();
		rankPanel = new RankPanel();
		selectPanel = new SelectPanel();
		gamePanel = new GamePanel();
		endPanel = new EndPanel();
		clearPanel = new ClearPanel();

		introPanel.addMouseListener(this);

		introPanel.setLayout(null);
		loginPanel.setLayout(null);
		signPanel.setLayout(null);
		rankPanel.setLayout(null);
		selectPanel.setLayout(null);
		gamePanel.setLayout(null);
		endPanel.setLayout(null);
		clearPanel.setLayout(null);

		frame.getContentPane().add(introPanel, "intro");
		frame.getContentPane().add(loginPanel, "login");
		frame.getContentPane().add(signPanel, "sign");
		frame.getContentPane().add(rankPanel, "rank");
		frame.getContentPane().add(selectPanel, "select");
		frame.getContentPane().add(gamePanel, "game");
		frame.getContentPane().add(endPanel, "end");
		frame.getContentPane().add(clearPanel, "clear");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		System.out.println(str);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getComponent().toString().contains("IntroPanel")) {
			cl.show(frame.getContentPane(), "login");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent().getName() == null) {
			// ������Ʈ ���� ����
		} else if (e.getComponent().getName().equals("loginBtn")) {
			System.out.println(loginPanel.getId() + " " + loginPanel.getPw());
			cl.show(frame.getContentPane(), "rank");
		} else if (e.getComponent().getName().equals("signBtn")) {
			System.out.println("ȸ���������� �̵�");
			cl.show(frame.getContentPane(), "sign");
		}
	}
}
