package gui.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.DBConnection;

@SuppressWarnings("serial")
public class Login extends CustomUI {

	private JFrame frame = new JFrame();
	private JPanel backgroundPanel;
	private JTextField txtUserId;
	private JPasswordField txtPassword;
	private JButton btnLogin, btnJoin;
	private JLabel lbLogo, lbSearch;

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static final String SQL = "SELECT * FROM USERS WHERE USER_ID = ? AND PASSWORD = ? AND DEL_FG = 'N'";

	public Login() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		
		// MouseListener 대신 MouseAdapter를 사용하는 게 나을 듯!
		lbSearch.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "관리자에게 문의하세요.", "오류", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		txtPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogin.doClick();
			}
		});
		
		// button 클릭시에 액션 이벤트 발생하고 등록된 ActionListener 구현 객체의 actionPerformed() 실행됨
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userId = txtUserId.getText();
				String password = String.valueOf(txtPassword.getPassword());
				
				conn = DBConnection.getConnection();
				
				try {
					pstmt = conn.prepareStatement(SQL);
					pstmt.setString(1, userId);
					pstmt.setString(2, password);
					rs = pstmt.executeQuery();
					System.out.println(SQL);
					System.out.println(userId);
					System.out.println(password);

					// rs.next()가 true인 것은 해당 아이디와 비밀번호의 사용자가 Users 테이블에 존재한다는 것!
					if (rs.next()) {
						// 아래 if문은 해당 사용자가 관리자인 경우와 그외 일반 사용자인 경우에 로그인 후 각기 다른 창을 보여준다.
						if(rs.getString("ADMIN_FG").equals("Y")) {	// 해당 사용자가 관리자인 경우
							new gui.admin.Main(); // 관리자용 새창 띄우고
							frame.dispose();	 // 현재창 닫기
						} else {
							new Main(userId);	//  일반 사용자용 새창 띄우고
							frame.dispose();	// 현재창 닫기
						}
					} else {	// 해당 아이디 비번으로 Users 테이블에 사용자가 없는 경우
						JOptionPane.showMessageDialog(frame, "일치하는 사용자가 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(frame, "인증되지 않았습니다.");	// 주로 데이터베이스 연결이 안되었을 경우
				}
			}
		});
		
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Join();			// 회원가입창 열고
				frame.dispose();	// 현재창 닫기
			}
		});

		// MouseListener 대신 MouseAdapter를 사용하는 게 나을 듯!
		frame.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				frame.requestFocus();	// TextField나 Button 등을 제외한 Frame의 나머지 부분을 클릭시
			}							// 포커스가 frame에 가도록 함. 이것 호출 직후 탭키를 누를 시 첫번째 컴포넌트에 포커스가 이동
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});

		frame.setSize(426, 779);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	private void init() {
		backgroundPanel = new JPanel();
		frame.setContentPane(backgroundPanel);
		frame.setTitle("영화 예매 프로그램 ver1.0");

//		CustomUI custom = new CustomUI(backgroundPanel);
		CustomUI custom = new CustomUI(backgroundPanel);
		custom.setPanel();
		
		lbLogo = custom.setLbImg("lbLogo", 4, 150, 150);
		txtUserId = custom.setTextField("txtUserId", "ID", 35, 290, 350, 45);
		txtPassword = custom.setPasswordField("txtPassword", "Password", 35, 345, 350, 45);
		btnLogin = custom.setBtnBlue("btnLogin", "로그인", 425);
		btnJoin = custom.setBtnWhite("btnJoin", "회원가입", 480);
		lbSearch = custom.setLb("lbSearch", "아이디 찾기 ｜ 비밀번호 찾기", 100, 535, 200, 40, "center", 15, "plain");
	}

	public static void main(String[] args) {
		new Login();
	}
}