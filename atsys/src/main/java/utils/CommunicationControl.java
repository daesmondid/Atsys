package utils;

import java.net.InetAddress;
import java.util.ArrayList;

public final class CommunicationControl {

	public static ArrayList<MultiThreadServer> boardConnections = new ArrayList<MultiThreadServer>();
	
	public static boolean testConnection(String ipAddress) {
		
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
	
	public static boolean testConnection(int boardId) {
		
		boolean result = false;
		
		for (MultiThreadServer multiThreadServer : boardConnections) {
			
			if (multiThreadServer.getBoardId().equals(String.valueOf(boardId))) {
				
				result = true;
				break;
				
			}
			
		}
		
		return result;
		
	}
	
	public static void message(int boardId, String message) {
		
		for (MultiThreadServer multiThreadServer : boardConnections) {
			
			if (multiThreadServer.getBoardId().equals(String.valueOf(boardId))) {
				
				multiThreadServer.send(message);
				
			}
			
		}
		
	}
	
}
