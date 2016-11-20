package utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enumerations.ConnectionStatus;
import enumerations.DoorStatus;
import enumerations.LockStatus;
import enumerations.PowerStatus;
import enumerations.TicketStatus;
import enumerations.UserType;

public final class AtsysDefaultUtil {
	
	public static String getSaltString() {
		
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public static int getSaltInt() {
		
		String SALTCHARS = "123456789";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 9) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return Integer.parseInt(saltStr);
		
	}
	
	public static HashMap<String, ConnectionStatus> getStringConnectionStatusMap() {
		
		HashMap<String, ConnectionStatus> hashMap = new HashMap<String, ConnectionStatus>();
		hashMap.put("Unknown", ConnectionStatus.UNKNOWN);
		hashMap.put("Offline", ConnectionStatus.OFFLINE);
		hashMap.put("Online", ConnectionStatus.ONLINE);
		
		return hashMap;
		
	}
	
	public static HashMap<Integer, ConnectionStatus> getIntConnectionStatusMap() {
		
		HashMap<Integer, ConnectionStatus> hashMap = new HashMap<Integer, ConnectionStatus>();
		hashMap.put(1, ConnectionStatus.UNKNOWN);
		hashMap.put(2, ConnectionStatus.OFFLINE);
		hashMap.put(3, ConnectionStatus.ONLINE);
		
		return hashMap;
		
	}
	
	public static HashMap<ConnectionStatus, Integer> getConnectionStatusMap() {
		
		HashMap<ConnectionStatus, Integer> hashMap = new HashMap<ConnectionStatus, Integer>();
		hashMap.put(ConnectionStatus.UNKNOWN, 1);
		hashMap.put(ConnectionStatus.OFFLINE, 2);
		hashMap.put(ConnectionStatus.ONLINE, 3);
		
		return hashMap;
		
	}
	
	public static HashMap<String, TicketStatus> getStringTicketStatusMap() {
		
		HashMap<String, TicketStatus> hashMap = new HashMap<String, TicketStatus>();
		hashMap.put("Awaiting Admin Reply", TicketStatus.ADMIN);
		hashMap.put("Awaiting User Reply", TicketStatus.USER);
		hashMap.put("Closed", TicketStatus.CLOSED);
		
		return hashMap;
		
	}
	
	public static HashMap<Integer, TicketStatus> getIntTicketStatusMap() {
		
		HashMap<Integer, TicketStatus> hashMap = new HashMap<Integer, TicketStatus>();
		hashMap.put(1, TicketStatus.ADMIN);
		hashMap.put(2, TicketStatus.USER);
		hashMap.put(3, TicketStatus.CLOSED);
		
		return hashMap;
		
	}
	
	public static HashMap<TicketStatus, Integer> getTicketStatusMap() {
		
		HashMap<TicketStatus, Integer> hashMap = new HashMap<TicketStatus, Integer>();
		hashMap.put(TicketStatus.ADMIN, 1);
		hashMap.put(TicketStatus.USER, 2);
		hashMap.put(TicketStatus.CLOSED, 3);
		
		return hashMap;
		
	}
	
	public static HashMap<String, PowerStatus> getStringPowerStatusMap() {
		
		HashMap<String, PowerStatus> hashMap = new HashMap<String, PowerStatus>();
		hashMap.put("Unknown", PowerStatus.UNKNOWN);
		hashMap.put("Powered Off", PowerStatus.OFF);
		hashMap.put("Powered On", PowerStatus.ON);
		
		return hashMap;
		
	}
	
	public static HashMap<Integer, PowerStatus> getIntPowerStatusMap() {
		
		HashMap<Integer, PowerStatus> hashMap = new HashMap<Integer, PowerStatus>();
		hashMap.put(1, PowerStatus.UNKNOWN);
		hashMap.put(2, PowerStatus.OFF);
		hashMap.put(3, PowerStatus.ON);
		
		return hashMap;
		
	}
	
	public static HashMap<PowerStatus, Integer> getPowerStatusMap() {
		
		HashMap<PowerStatus, Integer> hashMap = new HashMap<PowerStatus, Integer>();
		hashMap.put(PowerStatus.UNKNOWN, 1);
		hashMap.put(PowerStatus.OFF, 2);
		hashMap.put(PowerStatus.ON, 3);
		
		return hashMap;
		
	}
	
	public static HashMap<String, LockStatus> getStringLockStatusMap() {
		
		HashMap<String, LockStatus> hashMap = new HashMap<String, LockStatus>();
		hashMap.put("Unknown", LockStatus.UNKNOWN);
		hashMap.put("Unlocked", LockStatus.UNLOCKED);
		hashMap.put("Locked", LockStatus.LOCKED);
		
		return hashMap;
		
	}
	
	public static HashMap<Integer, LockStatus> getIntLockStatusMap() {
		
		HashMap<Integer, LockStatus> hashMap = new HashMap<Integer, LockStatus>();
		hashMap.put(1, LockStatus.UNKNOWN);
		hashMap.put(2, LockStatus.UNLOCKED);
		hashMap.put(3, LockStatus.LOCKED);
		
		return hashMap;
		
	}
	
	public static HashMap<LockStatus, Integer> getLockStatusMap() {
		
		HashMap<LockStatus, Integer> hashMap = new HashMap<LockStatus, Integer>();
		hashMap.put(LockStatus.UNKNOWN, 1);
		hashMap.put(LockStatus.UNLOCKED, 2);
		hashMap.put(LockStatus.LOCKED, 3);
		
		return hashMap;
		
	}
	
	public static HashMap<String, DoorStatus> getStringDoorStatusMap() {
		
		HashMap<String, DoorStatus> hashMap = new HashMap<String, DoorStatus>();
		hashMap.put("Unknown", DoorStatus.UNKNOWN);
		hashMap.put("Open", DoorStatus.OPEN);
		hashMap.put("Closed", DoorStatus.CLOSED);
		
		return hashMap;
		
	}
	
	public static HashMap<Integer, DoorStatus> getIntDoorStatusMap() {
		
		HashMap<Integer, DoorStatus> hashMap = new HashMap<Integer, DoorStatus>();
		hashMap.put(1, DoorStatus.UNKNOWN);
		hashMap.put(2, DoorStatus.OPEN);
		hashMap.put(3, DoorStatus.CLOSED);
		
		return hashMap;
		
	}
	
	public static HashMap<DoorStatus, Integer> getDoorStatusMap() {
		
		HashMap<DoorStatus, Integer> hashMap = new HashMap<DoorStatus, Integer>();
		hashMap.put(DoorStatus.UNKNOWN, 1);
		hashMap.put(DoorStatus.OPEN, 2);
		hashMap.put(DoorStatus.CLOSED, 3);
		
		return hashMap;
		
	}
	
	public static HashMap<String, UserType> getStringUserTypeMap() {
		
		HashMap<String, UserType> hashMap = new HashMap<String, UserType>();
		hashMap.put("Normal User", UserType.NORMAL);
		hashMap.put("Administrator", UserType.ADMIN);
		
		return hashMap;
		
	}
	
	public static HashMap<Integer, UserType> getIntUserTypeMap() {
		
		HashMap<Integer, UserType> hashMap = new HashMap<Integer, UserType>();
		hashMap.put(1, UserType.NORMAL);
		hashMap.put(2, UserType.ADMIN);
		
		return hashMap;
		
	}
	
	public static HashMap<UserType, Integer> getUserTypeMap() {
		
		HashMap<UserType, Integer> hashMap = new HashMap<UserType, Integer>();
		hashMap.put(UserType.NORMAL, 1);
		hashMap.put(UserType.ADMIN, 2);
		
		return hashMap;
		
	}
	
	public static void validateLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("user") == null) {
			
			response.sendRedirect("Login");
			return;
			
		}
		
	}

}
