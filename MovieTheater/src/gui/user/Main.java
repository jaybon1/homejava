package gui.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Main extends CustomUI {

	private JFrame frame = new JFrame();
	private JPanel backgroundPanel;
	private JButton btnMovie, btnTheater, btnList, btnInfo, btnLogout;
	
	private String userId;

	public Main(String userId) {
		this.userId = userId;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();

		btnMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectDate(userId, 0, "Movie");	// 영화별 예매 클릭시 띄우는 새창
				frame.dispose();	// 기존창 닫기
			}
		});
		
		btnTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectTheater1(userId);	// 상영관별 예매 클릭시 띄우는 새창
				frame.dispose();	// 기존창 닫기
			}
		});
		
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookingList(userId);	// 예매확인 클릭시 띄우는 새창
				frame.dispose();	// 기존창 닫기
			}
		});
		
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserInfo(userId);	// 내 정보 보기 클릭시 띄우는 새창
				frame.dispose();	// 기존창 닫기
			}
		});
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				frame.dispose();	// 기존창 닫기
			}
		});

		frame.setSize(426, 779);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	private void init() {
		backgroundPanel = new JPanel();
		frame.setContentPane(backgroundPanel);
		frame.setTitle("영화 예매 프로그램 ver1.0");

		CustomUI custom = new CustomUI(backgroundPanel);
		custom.setPanel();
		
		btnMovie = custom.setBtnImg("btnMovie", "영화별 예매", 33, 240);
		btnTheater = custom.setBtnImg("btnTheater", "상영관별 예매", 212, 240);
		btnList = custom.setBtnImg("btnList", "예매 확인", 33, 400);
		btnInfo = custom.setBtnImg("btnInfo", "내 정보 보기", 212, 400);
		btnLogout = custom.setBtnWhite("btnLogout", "로그아웃", 650);
	}
}