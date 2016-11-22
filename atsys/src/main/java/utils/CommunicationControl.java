package utils;

import java.io.DataOutputStream;
import java.net.InetAddress;
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
	
	public boolean testConnection(String ipAddress) {
		
		boolean result = false;
		
		InetAddress inet;
		try {
			inet = InetAddress.getByName(ipAddress);
			result = inet.isReachable(5000);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
