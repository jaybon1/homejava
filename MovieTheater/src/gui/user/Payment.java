package gui.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.ComboDao;
import dao.MovieDao;
import dao.ReserveDao;
import models.Combo;
import models.Movies;
import util.Utils;

@SuppressWarnings("serial")
public class Payment extends CustomUI {

	private JFrame frame = new JFrame();
	private JPanel backgroundPanel;
	private JLabel lbTitlePrice, lbPrice, lbTitleDiscount, lbTitleResult, lbResult, lbTitleCard, lbTitlePassword;
	private JComboBox<Combo> comboDiscount;
	private JTextField txtCard1, txtCard4;
	private JPasswordField txtCard2, txtCard3, txtPassword;
	private JButton btnPayment, btnBack;
	
	private String userId, reserveDate, reserveTime, beforePage;
	private int movieId, placeId, theaterId;
	
	public Payment(String userId, String reserveDate, String reserveTime, int movieId, int placeId, int theaterId, String seat, String beforePage) {

		// 좌석번호 2,3,12,13인 4개의 티켓이 예매된 경우 Reserve 테이블의 seat 필드에 "2,3,12,13" 로 들어있으므로
		// 이 문자열 값을 쉼표(,)를 기준으로 나눔(split)
		String splitSeat[] = seat.split("\\,");
		int reserveCnt = splitSeat.length;	// 티켓 예약 매수
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();

		MovieDao mDao = MovieDao.getInstance();
		Movies movie = mDao.selectPrice(movieId);
		
		lbPrice.setText(NumberFormat.getInstance().format(movie.getPrice()) + "원 x " + reserveCnt + "인");
		lbResult.setText(NumberFormat.getInstance().format(movie.getPrice() * reserveCnt)+"원");
		
		comboDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Combo selectedComboItem = (Combo) comboDiscount.getSelectedItem();
				String splitComboItem[] = selectedComboItem.toString().split("\\(");
				String discountContent = splitComboItem[1].replace(")", "");
				// 맨 끝의 한 문자가 할인 단위 표시 문자열이고 이 마지막 한 문자를 추출해 내는 것이므로 substring(discountContent.length()-1)으로 해줘도 된다.
				// 결과로 나오는 discountUnit은 "원", "%" 둘 중 하나
				// String discountUnit = discountContent.substring(discountContent.length()-1, discountContent.length());
				String discountUnit = discountContent.substring(discountContent.length()-1);
				int discountVal = Integer.parseInt(discountContent.replace(discountUnit, ""));	// "2000원" 또는 "10%"에서 원,% 떼내고 앞 숫자를 int값으로
				String priceText = lbPrice.getText().replace(",", "").replace("원", "").replace(" x ", "").replace("인", "");
				priceText = priceText.substring(0, priceText.length()-1);
				int price = Integer.parseInt(priceText);
				
				if(discountUnit.equals("원")) {	// 할일쿠폰 2000원 할인
					price = (price - discountVal) * reserveCnt;
				} else if(discountUnit.equals("%")) {	// 멤버십 10% 할인
					double discountRate = Double.parseDouble(discountVal+"") / 100;
					double discountPrice = price * (1-discountRate);	// price * 0.9
					price = (int)discountPrice * reserveCnt;
				} else {						// 할인혜택 없는 경우
					price = price * reserveCnt;
				}
				lbResult.setText(NumberFormat.getInstance().format(price)+"원");
			}
		});
		
		Utils util = new Utils();
		util.restrictNumber(txtCard1, 4);
		util.restrictNumber(txtCard2, 4);
		util.restrictNumber(txtCard3, 4);
		util.restrictNumber(txtCard4, 4);
		
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnCd = JOptionPane.showConfirmDialog(frame, "결제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(returnCd == JOptionPane.YES_OPTION) {
					int finalPrice = Integer.parseInt(lbResult.getText().replace(",", "").replace("원", ""));
					Combo discount = (Combo) comboDiscount.getSelectedItem();
					int discountId = discount.getKey();
					
					int check = 0;
					check = checkField();
					
					if(check == 0) {
						String cardNo = txtCard1.getText() + "" + String.valueOf(txtCard2.getPassword()) + "" + String.valueOf(txtCard3.getPassword()) + "" + txtCard4.getText();

						ReserveDao rDao = ReserveDao.getInstance();
						int returnCnt = rDao.insert(userId, movieId, placeId, theaterId, reserveDate, reserveTime, reserveCnt, seat, finalPrice, discountId, cardNo);
						
						if(returnCnt == 1) {
							new Result(userId);
							frame.dispose();
						} else {
							JOptionPane.showMessageDialog(frame, "결제에 실패하였습니다. 다시 시도해 주세요.", "오류", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnCd = JOptionPane.showConfirmDialog(frame, "좌석선택부터 다시 시작하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(returnCd == JOptionPane.YES_OPTION) {
					new Seat(userId, movieId, placeId, theaterId, reserveDate, reserveTime, beforePage);
					frame.dispose();
				}
			}
		});

		frame.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				frame.requestFocus();
			}
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

		CustomUI custom = new CustomUI(backgroundPanel);
		custom.setPanel();
		
		lbTitlePrice = custom.setLb("lbTitlePrice", "결제금액", 35, 200, 100, 20, "left", 17, "bold");
		lbPrice = custom.setLb("lbPrice", "14,000원", 200, 200, 180, 20, "right", 17, "plain");

		lbTitleDiscount = custom.setLb("lbTitleDiscount", "할인항목", 35, 270, 100, 20, "left", 17, "bold");

		ComboDao cDao = ComboDao.getInstance();
		Vector<Combo> comboDiscounts = cDao.setCombo("discount");
		System.out.println(comboDiscounts);		// for debug only
		comboDiscount = custom.setCombo("combo", comboDiscounts, 235, 270, 150, 25);

		lbTitleResult = custom.setLb("lbTitleResult", "최종금액", 35, 340, 100, 20, "left", 17, "bold");
		lbResult = custom.setLb("lbText3", "7,000원", 200, 340, 180, 20, "right", 17, "plain");

		lbTitleCard = custom.setLb("lbTitleCard", "카드번호", 35, 410, 100, 20, "left", 17, "bold");
		txtCard1 = custom.setTextField("txtCard1", "****", 170, 408, 50, 25);
		txtCard2 = custom.setPasswordField("txtCard2", "****", 225, 408, 50, 25);
		txtCard3 = custom.setPasswordField("txtCard3", "****", 280, 408, 50, 25);
		txtCard4 = custom.setTextField("txtCard4", "****", 335, 408, 50, 25);

		lbTitlePassword = custom.setLb("lbTitlePassword", "비밀번호", 35, 480, 100, 20, "left", 17, "bold");
		txtPassword = custom.setPasswordField("txtPassword", "", 265, 478, 120, 25);

		btnPayment = custom.setBtnBlue("btnPayment", "결제하기", 600);
		btnBack = custom.setBtnWhite("btnBack", "이전으로", 655);
	}
	
	private int checkField() {
		int check = 0;
		int len1 = txtCard1.getText().length();
		int len2 = String.valueOf(txtCard2.getPassword()).length();
		int len3 = String.valueOf(txtCard3.getPassword()).length();
		int len4 = txtCard4.getText().length();
		int len5 = String.valueOf(txtPassword.getPassword()).length();
		
		if(!(len1 == 4)) {
			JOptionPane.showMessageDialog(frame, "카드입력란 1번의 자리수가 맞지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			check = 1;
		} else if(!(len2 == 4)) {
			JOptionPane.showMessageDialog(frame, "카드입력란 2번의 자리수가 맞지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			check = 1;
		} else if(!(len3 == 4)) {
			JOptionPane.showMessageDialog(frame, "카드입력란 3번의 자리수가 맞지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			check = 1;
		} else if(!(len4 == 4)) {
			JOptionPane.showMessageDialog(frame, "카드입력란 4번의 자리수가 맞지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			check = 1;
		} else if(len5 == 0) {
			JOptionPane.showMessageDialog(frame, "카드 비밀번호를 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
			check = 1;
		}
		return check;
	}
}