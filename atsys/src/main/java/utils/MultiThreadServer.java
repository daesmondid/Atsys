package utils;

import java.net.*;

import java.io.*;

public class MultiThreadServer implements Runnable {
    Socket csocket;
    String boardId;
    
    MultiThreadServer(Socket csocket) {
        this.csocket = csocket;
    }
    
    public void run() {
        try {
        	String mensaje;
        	BufferedReader b = new BufferedReader( new InputStreamReader ( csocket.getInputStream() ) );
        	mensaje = b.readLine();
            System.out.println(mensaje);
            boardId = mensaje;
            CommunicationControl.boardConnections.add(this);
            System.out.println("Total Connections: " + CommunicationControl.boardConnections.size());
            DataOutputStream out = new DataOutputStream(csocket.getOutputStream());
            for (int i = 100; i >= 0; i--) {
                out.writeUTF(i + " bottles of beer on the wall<");
            }
            //csocket.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

	public String getBoardId() {
		return boardId;
	}
	
	public void send(String message) {
		
		try {
            DataOutputStream out = new DataOutputStream(csocket.getOutputStream());
            out.writeUTF(message + "<");
        }
        catch (IOException e) {
            System.out.println(e);
        }
		
	}
    
}
