package satmultisocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
	
	Socket socket; // 소켓 저장
	BufferedReader reader;
	PrintWriter writer;
	Scanner sc;

	public SocketClient() {
		try {
			socket = new Socket("localhost", 15000); // 상대방의 아이피와 포트를 입력하고 변수에 저장
			SocketThread st = new SocketThread(); // 소켓 연결을 유지할 스레드 생성
			st.start(); // 스레드 시작

			writer = new PrintWriter(socket.getOutputStream(), true); // 버퍼드라이터에 소켓 스트림 연결
			sc = new Scanner(System.in);
			while (true) {
				
				String line = sc.nextLine(); // 채팅창
				
				if(line.equals("종료")) {
					break;
				}
				
				// ALL:안녕
				// MSG:white:안녕
				writer.println(line);
			}
			
			writer.close();
			sc.close();
			socket.close();
			System.out.println("클라이언트 종료");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class SocketThread extends Thread {
		@Override
		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = null;
				while ((line = reader.readLine()) != null) {
					System.out.println("from server : " + line);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		new SocketClient();
	}
}
