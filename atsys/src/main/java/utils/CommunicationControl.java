package utils;

import java.io.DataOutputStream;
import java.net.Socket;

public class CommunicationControl {

	public CommunicationControl() {
		
		
		
	}
	
	public void send(String input, String ip) throws Exception {
		
		Socket clientSocket = new Socket(ip, 23);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		outToServer.writeBytes(input);
		clientSocket.close();
		
	}
	
}
