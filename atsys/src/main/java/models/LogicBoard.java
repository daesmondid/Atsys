package models;

import enumerations.ConnectionStatus;

public class LogicBoard {

	private int id;
	private String name;
	private String address;
	private ConnectionStatus connectionStatus;
	private User user;
	
	public LogicBoard(int id, String name, String address, ConnectionStatus connectionStatus, User user) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.connectionStatus = connectionStatus;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ConnectionStatus getConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(ConnectionStatus connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}