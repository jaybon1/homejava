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
		
		System.out.println("��û�� ����");
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		String msg = "";
		
		while (true) {
			
			msg = br.readLine();
			
			if(msg == null) {
				break;
			}
			
			System.out.println("���� : " + msg);
		}

		br.close();
		socket.close();
		serverSocket.close();
		
		System.out.println("��������");
		
	}

	public static void main(String[] args) {
		
		try {
			new MySocketServer();
		} catch (Exception e) {}
	}
}
