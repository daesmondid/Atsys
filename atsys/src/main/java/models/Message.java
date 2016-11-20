package models;

public class Message {

	private int id;
	private String content;
	private String timestamp;
	private Ticket ticket;
	private User user;
	
	public Message(String content, Ticket ticket, User user) {
		super();
		this.id = -1;
		this.content = content;
		this.timestamp = "N/A";
		this.ticket = ticket;
		this.user = user;
	}

	public Message(int id, String content, String timestamp, Ticket ticket, User user) {
		super();
		this.id = id;
		this.content = content;
		this.timestamp = timestamp;
		this.ticket = ticket;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
