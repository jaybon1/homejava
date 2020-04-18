package simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MySocketClient {
	
	Socket socket; // 소켓 생성
	BufferedReader br; // 키보드로 내가 입력한 메시지를 받기위한 br
	BufferedWriter bw; // 내가 입력한 메시지를 소켓으로 보내기 위한 bw 
	
	public MySocketClient() throws Exception {
		
		//스트림
		//"localhost" 또는 127.0.0.1 는 약속된 내용 - 내 컴퓨터의 내부 주소
		socket = new Socket("192.168.0.115", 15000); // 서버소켓의 accept() 함수를 호출
		
		// 소켓 - 버퍼드라이터 연결
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		// 키보드 - 버퍼드리더 연결
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String msg = "";
		
		// 키보드로 입력한 메시지를 확인하여 null이 아니면 bw에 적고 flush
		while ((msg = br.readLine()) != null) {
			bw.write(msg + "\n"); // "\n"은 상대방 소켓에서 읽어들이기 위해서 필요한 것이라 넣은 것
			System.out.println("내 메시지 : " + msg);
			bw.flush(); // 버퍼는 꽉차지 않으면 플러시 되지 않기 때문에 수동으로 플러시 시켜준다
		}
		
		// 인스턴스 닫기
		bw.close();
		br.close();
		socket.close();
		
	}
	
	public static void main(String[] args) {
		try {
			new MySocketClient(); // 클라이언트 메서드 실행
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
