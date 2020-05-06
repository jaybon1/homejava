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

	private IntroPanel introPanel; // 인트로

	private LoginPanel loginPanel; // 로그인

	private SignPanel signPanel; // 회원가입

	private RankPanel rankPanel; // 랭킹패널

	private SelectPanel selectPanel; // 캐릭터 및 맵 선택

	private GamePanel gamePanel; // 게임진행

	private EndPanel endPanel; // 게임종료

	private ClearPanel clearPanel; // 게임 클리어

	private CardLayout cl; // 카드 레이이웃 오브젝트

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
		cl = new CardLayout(0, 0); // 카드레이아웃 객체 생성
		frame.getContentPane().setLayout(cl); // 프레임을 카드레이아웃으로 변경

		introPanel = new IntroPanel();
		loginPanel = new LoginPanel(this); // this를 쓴 이유 - 이 클래스의 객체가 리스너의 역할도 같이하기 때문
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
			// 널포인트 에러 방지
		} else if (e.getComponent().getName().equals("loginBtn")) {
			System.out.println(loginPanel.getId() + " " + loginPanel.getPw());
			cl.show(frame.getContentPane(), "rank");
		} else if (e.getComponent().getName().equals("signBtn")) {
			System.out.println("회원가입으로 이동");
			cl.show(frame.getContentPane(), "sign");
		}
	}
}
