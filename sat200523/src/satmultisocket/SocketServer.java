package satmultisocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class SocketServer {
	ServerSocket serverSocket; // 서버소켓은 연결요청을 대기하다가 연결이 되면 소켓을 리턴하고 서버소켓에 연결된 선을 끊는다
	Vector<SocketThread> vc; // 소켓 스레드를 저장하기 위한 변수

	public SocketServer() {

		try {
			serverSocket = new ServerSocket(15000); // 포트를 20000번으로 하는 서버소켓을 생성

			vc = new Vector<>(); // 벡터 배열 생성

			while (true) {
				System.out.println("요청 대기");
				Socket socket = serverSocket.accept(); // 서버소켓에 요청이 오는 것을 대기
				System.out.println("요청 받음");
				SocketThread st = new SocketThread(socket); // 소켓을 받는 스레드를 생성
				st.start(); // 스레드 시작
				vc.add(st); // 벡터 배열에 스레드 저장

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	class SocketThread extends Thread { // 소켓통신을 할 스레드를 만들기 위한 내부 클래스
		Socket socket; // 외부에서 받은 소켓을 넣는 공간
		String id; // 유저 id 저장
		BufferedReader reader;
		PrintWriter writer;

		public SocketThread(Socket socket) {
			this.socket = socket; // 스레드가 생성 되면 소켓을 받아서 저장한다
		}

		@Override
		public void run() {

			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);

				writer.println("please Sign in"); // 아이디 입력받음
				id = reader.readLine();
				System.out.println("요거 실행됨");
				System.out.println(id);
				String line = null;
				while (true) { // 무한히 채팅
					try {
						line = reader.readLine();						
					} catch (Exception e) {
						System.out.println(e.getMessage());
						vc.remove(this);
						break;
					}
					
					if(line == null) {
						System.out.println(id +" 널값 종료");
						vc.remove(this);
						break;
					}
					
					router(line);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void router(String line) { // 모두에게 보낼지 귓속말 할지 결정하여 전송
			System.out.println(line);
			String[] gubun = line.split(":"); // : 을 기준으로 나눈다
			String protocol = gubun[0]; // 0번 위치에 ALL 또는 MSG가 있을테니 확인하여 분기
			if (protocol.equals(ChatProtocol.ALL)) {
				String msg = gubun[1]; // ALL:안녕 이라면 1번위치에 안녕이 있다

				allChat(msg);

			} else if (protocol.equals(ChatProtocol.MSG)) {
				String otherId = gubun[1]; // MSG:id:안녕 이라면 1번위치에 아이디가 있고 2번위치에 메시지가 있다
				String msg = gubun[2];

				privateChat(otherId, msg);

			}
		}

		public void allChat(String msg) {
			System.out.println(id + " : " + msg + " ip : " + socket.getInetAddress()); // 아이디와 아이피 출력

			for (SocketThread socketThread : vc) { // 모든 사람에게 메시지 보내기
				socketThread.writer.println(id + " : " + msg);
			}

		}

		public void privateChat(String otherId, String msg) {
			
			int count = 0;
			
			System.out.println(id + ":" + msg + " ip : " + socket.getInetAddress()); // 아이디와 아이피 출력

			for (SocketThread socketThread : vc) { // 지정한 사람에게 메시지 보내기
				if (socketThread.id.equals(otherId)) {
					socketThread.writer.println(id + " : " + msg);
					count = 1;
				} 
			}
			
			if(count == 0) {
				writer.println("아이디를 찾을 수 없습니다.");
			}

		}

	}

	public static void main(String[] args) {
		new SocketServer();
	}
}
