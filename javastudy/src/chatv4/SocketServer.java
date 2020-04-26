package chatv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class SocketServer {
	ServerSocket serverSocket; // ���������� �����û�� ����ϴٰ� ������ �Ǹ� ������ �����ϰ� �������Ͽ� ����� ���� ���´�
	Vector<SocketThread> vc; // ���� �����带 �����ϱ� ���� ����

	public SocketServer() {

		try {
			serverSocket = new ServerSocket(20000); // ��Ʈ�� 20000������ �ϴ� ���������� ����

			vc = new Vector<>(); // ���� �迭 ����

			while (true) {
				System.out.println("��û ���");
				Socket socket = serverSocket.accept(); // �������Ͽ� ��û�� ���� ���� ���
				System.out.println("��û ����");
				SocketThread st = new SocketThread(socket); // ������ �޴� �����带 ����
				st.start(); // ������ ����
				vc.add(st); // ���� �迭�� ������ ����

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	class SocketThread extends Thread { // ��������� �� �����带 ����� ���� ���� Ŭ����
		Socket socket; // �ܺο��� ���� ������ �ִ� ����
		String id; // ���� id ����
		BufferedReader reader;
		PrintWriter writer;

		public SocketThread(Socket socket) {
			this.socket = socket; // �����尡 ���� �Ǹ� ������ �޾Ƽ� �����Ѵ�
		}

		@Override
		public void run() {

			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);

				writer.println("please Sign in"); // ���̵� �Է¹���
				id = reader.readLine();
				System.out.println("��� �����");
				System.out.println(id);
				String line = null;
				while ((line = reader.readLine()) != null) { // ������ ä��
					router(line);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void router(String line) { // ��ο��� ������ �ӼӸ� ���� �����Ͽ� ����
			System.out.println(line);
			String[] gubun = line.split(":"); // : �� �������� ������
			String protocol = gubun[0]; // 0�� ��ġ�� ALL �Ǵ� MSG�� �����״� Ȯ���Ͽ� �б�
			if (protocol.equals(ChatProtocol.ALL)) {
				String msg = gubun[1]; // ALL:�ȳ� �̶�� 1����ġ�� �ȳ��� �ִ�

				allChat(msg);

			} else if (protocol.equals(ChatProtocol.MSG)) {
				String otherId = gubun[1]; // MSG:id:�ȳ� �̶�� 1����ġ�� ���̵� �ְ� 2����ġ�� �޽����� �ִ�
				String msg = gubun[2];

				privateChat(otherId, msg);

			}
		}

		public void allChat(String msg) {
			System.out.println(id + " : " + msg + " ip : " + socket.getInetAddress()); // ���̵�� ������ ���

			for (SocketThread socketThread : vc) { // ��� ������� �޽��� ������
				socketThread.writer.println(id + " : " + msg);
			}

		}

		public void privateChat(String otherId, String msg) {
			System.out.println(id + ":" + msg + " ip : " + socket.getInetAddress()); // ���̵�� ������ ���

			for (SocketThread socketThread : vc) { // ������ ������� �޽��� ������
				if (socketThread.id.equals(otherId)) {
					socketThread.writer.println(id + " : " + msg);
				} else {
					writer.println("���̵� ã�� �� �����ϴ�.");
				}
			}

		}

	}

	public static void main(String[] args) {
		new SocketServer();
	}
}