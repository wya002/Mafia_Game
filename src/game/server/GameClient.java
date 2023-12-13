package game.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {

	public void start() {
		Socket socket = null;
		BufferedReader in = null;
		Thread msgThread = null;
		Scanner scanner = null;
		
		try {
			socket = new Socket("127.0.0.1", 8080);
			scanner = new Scanner(System.in);
			System.out.println("[Mafia Game에 입장하셨습니다.]");
			System.out.println("[사용할 닉네임을 입력해주세요.");
			System.out.print("닉네임 : ");
			String name = scanner.nextLine();
		
			msgThread = new MsgThread(socket, name);
			msgThread.start();
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "MS949"));
			
			while(in != null) {
					String inputMsg = in.readLine();
					if(inputMsg == null) break;
					else {
						if(("[" + name + "] 님이 퇴장하셨습니다,").equals(inputMsg)) break;
						System.out.println(inputMsg);
					}
				}
		} catch (IOException e) {
			System.out.println("[서버 접속끊김]");
		} finally {
			try {
				msgThread.interrupt();
				socket.close();
				scanner.close();
			} catch (IOException e) {
				System.out.println("통신에러");
			}
		}	
		System.out.println("[서버 연결 종료]");
	}
	
	public static void main(String[] args){
			GameClient player = new GameClient();
			player.start();
		}
}

	class MsgThread extends Thread{
		Socket socket = null;
		String name;
		
		Scanner scanner = new Scanner(System.in);
		
		public MsgThread(Socket socket, String name) {
			this.socket = socket;
			this.name = name;
		}
		
		@Override
		public void run() {
			try {
				PrintStream out = new PrintStream(socket.getOutputStream());
				out.println(name);
				out.flush();
				
				while(true) {
					String sendMsg = scanner.nextLine();
					out.println(sendMsg);
					out.flush();
					if("quit".equals(sendMsg)) {
						break;
					}
				}
			}catch(IOException e) {
				e.printStackTrace();
				}
			}
		}
