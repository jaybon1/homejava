package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;
import model.Drugstore;

public class DrugstoreDAO {

	private final static String TAG = "DrugstoreDAD : ";

	private static DrugstoreDAO instance = new DrugstoreDAO(); // 싱글톤

	public static DrugstoreDAO getInstance() { // 싱글톤 객체 리턴
		return instance;
	}

	private DrugstoreDAO() {
		// 생성자
	}

	public Drugstore getFirstLine() { // 테스트용으로 DB 에서 첫 데이터를 뽑아보자

		final String SQL = "SELECT * FROM drugstore";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Drugstore ds = null;

		try {
			// 1. 스트림 연결
			conn = DBConnection.getConnection();

			// 2. 버퍼달기
			pstmt = conn.prepareStatement(SQL);

			// 4. 쿼리전송(flush+rs받기)
			rs = pstmt.executeQuery();

			if (rs.next()) { // rs.next()는 리턴값이 참 거짓

				ds = Drugstore.builder().name(rs.getString(1)).loc(rs.getString(2)).build();
			}

			return ds;

		} catch (Exception e) {
			// e.getMessage()해당 오류만 보여줌
			// e.getStackTrace() 해당 오류로 일어나는 모든 오류를 보여줌
			System.out.println(TAG + "전체목록 오류 : " + e.getMessage());

		} finally { // 무조건 실행
			DBConnection.close(conn, pstmt, rs);
		}

		return null;
	}

	public Drugstore getFirstLine(String loc) { // 테스트용으로 DB 에서 첫 데이터를 뽑아보자
		
		if(loc == null) {
			loc = "";
		}
		
		final String SQL = "SELECT * FROM drugstore WHERE loc LIKE ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Drugstore ds = null;

		try {
			// 1. 스트림 연결
			conn = DBConnection.getConnection();

			// 2. 버퍼달기
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, "%" + loc + "%");

			// 4. 쿼리전송(flush+rs받기)
			rs = pstmt.executeQuery();

			if (rs.next()) { // rs.next()는 리턴값이 참 거짓

				ds = Drugstore.builder().name(rs.getString(1)).loc(rs.getString(2)).build();
			}

			return ds; // 연습용이라 첫줄만 출력하도록 한다

		} catch (Exception e) {
			// e.getMessage()해당 오류만 보여줌
			// e.getStackTrace() 해당 오류로 일어나는 모든 오류를 보여줌
			System.out.println(TAG + "전체목록 오류 : " + e.getMessage());

		} finally { // 무조건 실행
			DBConnection.close(conn, pstmt, rs);
		}

		return null;
	}

	// 테스트
	public static void main(String[] args) {
		System.out.println(DrugstoreDAO.getInstance().getFirstLine());
	}

}
