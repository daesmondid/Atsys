package utils;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServerService implements Runnable {

	@Override
	public void run() {
		
		try {
			
			ServerSocket serverSocket = new ServerSocket(1234);
	        System.out.println("Listening");
	        while (true) {
	            Socket sock = serverSocket.accept();
	            System.out.println("Connected");
	            Thread thread = new Thread(new MultiThreadServer(sock));
	            thread.start();
	        }
			
		}
		catch (Exception exception) {
			
		}
		
	}

}
