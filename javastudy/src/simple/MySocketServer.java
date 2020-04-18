package simple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {

	ServerSocket serverSocket; // 서버소켓은 연결요청을 대기하다가 연결이 되면 소켓을 리턴하고 서버소켓에 연결된 선을 끊는다
	Socket socket; // 서버소켓이 리턴한 소켓을 받는 역할
	BufferedReader br; // 스트림이 연결되면 BufferedReader로 데이터를 받는다

	// throws는 함수의 모든 내용이 try catch가 필요한 경우 사용하면 된다
	public MySocketServer() throws Exception { // throws 는 함수를 호출한 자(여기서는 main)에게 던지는 것이다

		serverSocket = new ServerSocket(15000); // 서버 소켓 생성 (연결을 받는)
		socket = serverSocket.accept(); // 요청을 대기 - 연결이 되면 소켓을 리턴하고 서버소켓에 연결된 선을 끊는다
		System.out.println("요청이 들어옴");
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		String msg = "";
		while ((msg = br.readLine()) != null) { // br로 데이터를 받고 msg에 넣은 후 null값인지 확인한다
			System.out.println("상대방 : " + msg); // 받은 메시지를 출력한다
		}

		// 사용이 끝난 인스턴스를 닫는다
		br.close();
		socket.close();
		serverSocket.close();
	}

	public static void main(String[] args) {
		
		try { // main이 함수를 호출 했기 때문에 여기서 트라이캐치를 사용
			new MySocketServer(); // 소켓서버 가동 메서드 실행;
		} catch (Exception e) {}
	}
}
