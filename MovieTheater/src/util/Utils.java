package util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import models.Combo;

public class Utils {

	public int getAge(int birthYear, int birthMonth, int birthDay) {
		Calendar current = Calendar.getInstance();
		int currentYear = current.get(Calendar.YEAR);
		int currentMonth = current.get(Calendar.MONTH) + 1;
		int currentDay = current.get(Calendar.DAY_OF_MONTH);

		int age = currentYear - birthYear;
		// 100을 곱해 주는 의도는 월을 나타내는 숫자 비교가 우선이고 이게 같을 경우에만 날짜 비교를 하기 위함임
		// 즉, 날짜가 2자리 수이므로 월 숫자를 3자리로 만들기 위해 100을 곱함
		// 현재 날짜가 생일을 안 지났을 경우 나이에서 1을 빼는 것! 결과로 나오는 age는 만 나이에 해당
		if (birthMonth * 100 + birthDay > currentMonth * 100 + currentDay)
			age--;

		return age;
	}

	// 이 프로그램에서 콤보박스에 담을 때 key값은 주로 0,1,2.. 가 아니라 1,2,3..으로 나가는 듯.
	// 이런 불확실성 때문에 하나씩 꺼내와서 getKey()로 비교하는 듯.
	// 항상 1,2,3,..으로 나가는 거면 그냥 key-1이 될 텐데
	public int getComboIndex(JComboBox<Combo> comboBox, int key) {
		Combo item;
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			item = comboBox.getItemAt(i);
			if (item.getKey() == key) {
				return i;
			}
		}
		return 0;
	}

	public Vector<String> getTableTitleColum(String table) {
		Vector<String> colName = new Vector<>();

		if (table.equals("user")) {
			colName.add("아이디");
			colName.add("생년월일");
			colName.add("연락처");
			colName.add("탈퇴여부");
		} else if (table.equals("movie")) {
			colName.add("아이디");
			colName.add("영화제목");
			colName.add("가격");
			colName.add("연령제한");
			colName.add("상영시간");
		} else if (table.equals("place")) {
			colName.add("아이디");
			colName.add("지점명");
			colName.add("주소");
		} else if (table.equals("theater")) {
			colName.add("아이디");
			colName.add("상영관명");
			colName.add("지점명");
			colName.add("좌석구분");
		} else if (table.equals("seat")) {
			colName.add("아이디");
			colName.add("좌석구분");
			colName.add("행");
			colName.add("열");
		} else if (table.equals("discount")) {
			colName.add("아이디");
			colName.add("할인명");
			colName.add("할인값");
			colName.add("할인단위");
		} else if (table.equals("reserve")) {
			colName.add("아이디");
			colName.add("사용자아이디");
			colName.add("영화명");
			colName.add("지점명");
			colName.add("상영관명");
			colName.add("예매날짜");
			colName.add("예매시간");
			colName.add("인원");
			colName.add("결제액");
			colName.add("취소여부");
		} else if (table.equals("salesMovie")) {
			colName.add("영화제목");
			colName.add("매출액");
		} else if (table.equals("salesPlace")) {
			colName.add("지점명");
			colName.add("매출액");
		} else if (table.equals("screen")) {
			colName.add("아이디");
			colName.add("영화명");
			colName.add("지점명");
			colName.add("상영관명");
			colName.add("시작일자");
			colName.add("종료일자");
			colName.add("시작시간");
		}
		return colName;
	}

	public void hiddenTableColumn(JTable table, int index) {
		table.getColumnModel().getColumn(index).setMinWidth(0);
		table.getColumnModel().getColumn(index).setMaxWidth(0);
		table.getColumnModel().getColumn(index).setWidth(0);
	}

	public void restrictNumber(JTextField txt, int length) {
		txt.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
			// 키보드 키를 눌렀다가 뗄때마다 호출
			public void keyReleased(KeyEvent e) {
				String text = txt.getText();
				// 방금 입력한 키가 0-9 사이의 숫자를 나타내는 문자 입력이 아닌 경우에는
				// 입력한 문자열 중 가장 끝 한 글자를 제거함
				if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
					txt.setText(text.substring(0, text.length() - 1));
				}
				// 문자열 길이가 length보다 긴 경우에도 맨 마지막 한 문자 제거함
				if (text.length() > length) {
					txt.setText(text.substring(0, text.length() - 1));
				}
			}
		});
	}
}
