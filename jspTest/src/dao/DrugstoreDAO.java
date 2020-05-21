package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnection;
import model.Drugstore;

public class DrugstoreDAO {

	private final static String TAG = "DrugstoreDAD : ";

	private static DrugstoreDAO instance = new DrugstoreDAO(); // �̱���

	public static DrugstoreDAO getInstance() { // �̱��� ��ü ����
		return instance;
	}

	private DrugstoreDAO() {
		// ������
	}

	public Drugstore getFirstLine() { // �׽�Ʈ������ DB ���� ù �����͸� �̾ƺ���

		final String SQL = "SELECT * FROM drugstore";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Drugstore ds = null;

		try {
			// 1. ��Ʈ�� ����
			conn = DBConnection.getConnection();

			// 2. ���۴ޱ�
			pstmt = conn.prepareStatement(SQL);

			// 4. ��������(flush+rs�ޱ�)
			rs = pstmt.executeQuery();

			if (rs.next()) { // rs.next()�� ���ϰ��� �� ����

				ds = Drugstore.builder().name(rs.getString(1)).loc(rs.getString(2)).build();
			}

			return ds;

		} catch (Exception e) {
			// e.getMessage()�ش� ������ ������
			// e.getStackTrace() �ش� ������ �Ͼ�� ��� ������ ������
			System.out.println(TAG + "��ü��� ���� : " + e.getMessage());

		} finally { // ������ ����
			DBConnection.close(conn, pstmt, rs);
		}

		return null;
	}

	public Drugstore getFirstLine(String loc) { // �׽�Ʈ������ DB ���� ù �����͸� �̾ƺ���
		
		if(loc == null) {
			loc = "";
		}
		
		final String SQL = "SELECT * FROM drugstore WHERE loc LIKE ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Drugstore ds = null;

		try {
			// 1. ��Ʈ�� ����
			conn = DBConnection.getConnection();

			// 2. ���۴ޱ�
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, "%" + loc + "%");

			// 4. ��������(flush+rs�ޱ�)
			rs = pstmt.executeQuery();

			if (rs.next()) { // rs.next()�� ���ϰ��� �� ����

				ds = Drugstore.builder().name(rs.getString(1)).loc(rs.getString(2)).build();
			}

			return ds; // �������̶� ù�ٸ� ����ϵ��� �Ѵ�

		} catch (Exception e) {
			// e.getMessage()�ش� ������ ������
			// e.getStackTrace() �ش� ������ �Ͼ�� ��� ������ ������
			System.out.println(TAG + "��ü��� ���� : " + e.getMessage());

		} finally { // ������ ����
			DBConnection.close(conn, pstmt, rs);
		}

		return null;
	}

	// �׽�Ʈ
	public static void main(String[] args) {
		System.out.println(DrugstoreDAO.getInstance().getFirstLine());
	}

}
