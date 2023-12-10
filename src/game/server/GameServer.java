package game.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class GameServer{
	public static void main(String[] args) {
		BufferedReader in = null;
		PrintWriter out = null;
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			serverSocket = new ServerSocket(8000);
			
			socket = serverSocket.accept();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			while(true){
				String inputMessage = in.readLine();
				if("quit".equalsIgnoreCase(inputMessage))break;
				
				System.out.println("From Client : " + inputMessage);
				System.out.print("전송하기 >>> ");
				
				String outputMessage = scanner.nextLine();
				out.println(outputMessage);
				out.flush();
				if("quit".equalsIgnoreCase(outputMessage))break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				scanner.close();
				socket.close();
				serverSocket.close();
				System.out.println("연결종료");
			}catch(IOException e) {
				System.out.println("소켓통신에러");
			}
		}
	}

}
