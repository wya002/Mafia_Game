package game.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameServer{
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(8080);
			System.out.println("[Mafia Game 서버 시작]");
			System.out.println("[플레이어 연결 대기중..]");
			while(true) {
				socket = serverSocket.accept();
				
				ChatThread chatThread = new ChatThread(socket);
				chatThread.start();
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(serverSocket!=null) {
				try {
					serverSocket.close();
					System.out.println("[서버종료]");
				}catch(IOException e) {
					e.printStackTrace();
					System.out.println("[서버소켓통신에러");
				}
			}
		}
	}
	
	class ChatThread extends Thread{
		static List<PrintWriter> msgList =
				Collections.synchronizedList(new ArrayList<PrintWriter>());
		private Socket socket = null;
		private BufferedReader in = null;
		private PrintWriter out = null;
		
		public ChatThread(Socket socket) {
			this.socket = socket;
			try {
				out = new PrintWriter(socket.getOutputStream());
				in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "MS949"));
				msgList.add(out);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run(){
			String name = "";
			try {
				name = in.readLine();
				System.out.println("[" + name + " 새 연결생성]");
				sendAll("서버 메시지 >> [" + name + "]님이 들어오셨습니다.");
				
				while(in != null) {
					String inputMsg = in.readLine();
					if("quit".equals(inputMsg)) break;
					System.out.println(name + " >> " + inputMsg);
					sendAll(name + " >> " + inputMsg);
					
				}
			} catch (IOException e) {
				System.out.println("[" + name + ": 접속끊김]");
			} finally {
				sendAll("서버 메시지 >> [" + name + "]님이 나가셨습니다.");
				msgList.remove(out);
				try {
					socket.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		private void sendAll(String msg) {
			for(PrintWriter out : msgList) {
				out.println(msg);
				out.flush();
			}
		}
	}
	
	public static void main(String[] args) {
		GameServer server = new GameServer();
		server.start();
	}

}
