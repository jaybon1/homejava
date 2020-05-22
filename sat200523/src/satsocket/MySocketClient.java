package satsocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

// 클라이언트 출력버퍼 - 서버 스트림라이터 - 스트림 - 서버 스트림리더 - 서버 입력버퍼

public class MySocketClient {
	
	Socket socket;
	BufferedWriter bw;
	BufferedReader br;
	
	public MySocketClient() throws Exception {
		
		socket = new Socket("localhost", 15000);
		
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String msg = "";
		
		while (true) {
			
			msg = br.readLine();
			
			if(msg.equals("종료")) {
				break;
			}
			
			bw.write(msg + "\n");
			System.out.println("내 메시지 : " + msg);
			bw.flush();
		}
		

		bw.close();
		br.close();
		socket.close();
		
	}
	
	public static void main(String[] args) {
		try {
			
			new MySocketClient();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
