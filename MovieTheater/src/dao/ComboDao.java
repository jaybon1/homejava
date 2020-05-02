package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import models.Combo;

public class ComboDao {
	private ComboDao(){}
	private static ComboDao instance = new ComboDao();
	
	public static ComboDao getInstance() {
		return instance;
	}
	
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public Vector<Combo> setCombo(String comboContent) {
		Vector<Combo> combos = new Vector<>();
		String sql;
		
		if(comboContent.equals("place")) {
			sql = "SELECT ID AS KEY, NAME AS VALUE FROM PLACE";
			// 위 sql 실행 결과
			// KEY	VALUE
			// 1	서면점
			// 2	부산대점
			// 3	남포점
		} else if(comboContent.equals("seat")) {
			sql = "SELECT ID AS KEY, SEAT_TYPE AS VALUE FROM SEAT";
		} else if(comboContent.equals("discount")) {
			// sql문에서 ||는 문자열 합치기(concatenation)임. 자바에서 문자열을 합치는 기호 +와 동일한 역할!
			// 즉 아래에서 NAME||' ('||VAL||UNIT||')' 부분을 자바로 해보면 NAME + ' (' + VAL + UNIT + ')' 와 같음
			// 실제 DISCOUNT 테이블에서 가져온 결과는 "없음 (0원)", "쿠폰 (2000원)", "멤버십 (10%)" 가 된다.
			// 따라서 아래 Select문 실행해서 Discount 테이블로부터 가져오는 실제 데이터는 아래와 같다.
			// KEY	VALUE
			// 1	없음 (0원)
			// 2	쿠폰 (2000원)
			// 3	멤버십 (10%)
			sql = "SELECT ID AS KEY, NAME||' ('||VAL||UNIT||')' AS VALUE FROM DISCOUNT";
		} else if(comboContent.equals("movie")) {
			sql = "SELECT ID AS KEY, TITLE AS VALUE FROM MOVIE";
		} else {
			sql = "";
		}
		
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			int resultCount = 0;	// rs.getRow()가 의도대로 작동않기에 대신 사용하기 위해 추가해 본 변수임
			
			while(rs.next()){
				Combo combo = new Combo();
				combo.setKey(rs.getInt("KEY"));
				combo.setValue(rs.getString("VALUE"));
				combos.add(combo);
				
				resultCount++;
				
				// System.out.println("KEY :" + rs.getInt("KEY"));		// for debug only
				// System.out.println("VALUE :" + rs.getString("VALUE"));	// for debug only
			}
			
				// 아래에서 rs.getType()을 해보면 1003 이라는 결과가 나오는데 ResultSet 인터페이스 안을 보면
				// 1003은 TYPE_FORWARD_ONLY임을 표시하는 상수값이다.
				System.out.println("rs.getType() :" + rs.getType());  // for debug only
				System.out.println(combos);   // for debug only
				System.out.println("rs.getRow() : " + rs.getRow());  // for debug only
				// 코드가 여기까지 오면 벡터인 combos에는 제대로된 객체들이 세팅되는데
				// rs.getRow()가 0이어서 아래 if문에서 combos를 반환하지 못하고 null을 반환하고 있음.
				// 원래의 작성자는 getRow()가 ResultSet의 마지막행 숫자를 반환할 걸로 생각하고 아래 if문을 만들었는데,
				// ResultSet 클래스의 getRow() 메서드 API 문서를 보면 ResultSet의 타입이 TYPE_FORWARD_ONLY인 경우
				// 이 메서드의 지원은 선택적(optional)이라고 나와 있고
				// 그래서 아마 Oracle DB에서는 구현을 하지 않았다던가 하는 이유로 아래에서는 이 값이 항상 0인 듯.
				
				// *참고사항
				// Oracle DB에서 구현을 하지 않았다고 하는 것이 해당 메서드가 추상 메서드인 채로 존재함을 의미하지는 않는다.
				// 보통 여러 단계의 상속 관계를 거치는 경우가 많으므로 아마 그보다 윗단계 어느 클래스에서 자식 클래스가 적절히 오버라딩이하도록
				// 구체적 구현은 미루어  두고 자신의 메서드에서는 특별한 의미없는 기본값인 0을 바로 반환하도록만 구현해 두었을 가능성이 많다.
				// (MouseAdapter의 아무 것도 하지 않도록 구현된 메서드들을 상상하면 비슷할 듯)
				// 이 상황에서 Oracle DB에서 이를 오버라이딩 하지 않으면 아래 if문에서와 같이 0을 반환하게 되는 것!
			
				
			// rs.getRow()가 의도대로 작동 않기에 if문 조건을 resultCount를 사용하도록 변경함
			// 이걸 변경하지 않으면 예매화면에서 할인항목이 없음으로만 표시된다.
			// if(rs.getRow() == 0) {
			if(resultCount == 0) {
				conn.close();
				return null;
			} else {
				conn.close();
				return combos;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Vector<Combo> setCombo(String comboContent, int id) {
		Vector<Combo> combos = new Vector<>();
		String sql;
		
		sql = "SELECT ID AS KEY, NAME AS VALUE FROM THEATER WHERE PLACE_ID = ?";
		
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if(comboContent.equals("theater")) {
				pstmt.setInt(1, id);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Combo combo = new Combo();
				combo.setKey(rs.getInt("KEY"));
				combo.setValue(rs.getString("VALUE"));
				combos.add(combo);
			}
			
			if(rs.getRow() == 0) {
				conn.close();
				return null;
			} else {
				conn.close();
				return combos;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
