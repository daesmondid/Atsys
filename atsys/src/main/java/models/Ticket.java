package models;

import enumerations.TicketStatus;

public class Ticket {

	private int id;
	private String name;
	private TicketStatus ticketStatus;
	private User user;
	private String deviceId;
	
	public Ticket(int id, String name, TicketStatus ticketStatus, User user, String deviceId) {
		super();
		this.id = id;
		this.name = name;
		this.ticketStatus = ticketStatus;
		this.user = user;
		this.deviceId = deviceId;
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

	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
}
