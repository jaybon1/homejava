package satsocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {

	ServerSocket serverSocket;
	Socket socket;
	BufferedReader br;

	public MySocketServer() throws Exception {

		serverSocket = new ServerSocket(15000);
		
		socket = serverSocket.accept();
		
		System.out.println("요청이 들어옴");
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		String msg = "";
		
		while (true) {
			
			msg = br.readLine();
			
			if(msg == null) {
				break;
			}
			
			System.out.println("상대방 : " + msg);
		}

		br.close();
		socket.close();
		serverSocket.close();
		
		System.out.println("서버종료");
		
	}

	public static void main(String[] args) {
		
		try {
			new MySocketServer();
		} catch (Exception e) {}
	}
}
