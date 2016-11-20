package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import utils.DaoBase;

public class Message extends DaoBase {

	@Override
	public void add(Object object) {
		
		models.Message message = (models.Message) object;

		try {
			
			statement = connect.createStatement();
	    	String query = "insert into message (user_id, ticket_id, content) values ("+message.getUser().getId()+", "+message.getTicket().getId()+", '"+message.getContent()+"')";
	    	statement.executeUpdate(query.replaceAll("'", "\""));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
    	
	}
	
	@Override
	public void remove(int id) {

		try {
			
			statement = connect.createStatement();
	    	statement.executeUpdate("delete from message where id=" + id);			
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
	@Override	
	public ArrayList<models.Message> list() {
		
		ArrayList<models.Message> list = new ArrayList<models.Message>();
		
		try {
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from message");
	        while (resultSet.next()) {
	        	
	        	int id = resultSet.getInt("id");
	        	String content = resultSet.getString("content");
	        	String timestamp = resultSet.getString("timestamp");
	        	models.Ticket ticket = new dao.Ticket().get(resultSet.getInt("ticket_id"));
	    		models.User user = new dao.User().get(resultSet.getInt("user_id"));
	        	
	        	models.Message message = new models.Message(id, content, timestamp ,ticket, user);
	        	
	        	list.add(message);
	                
	        }
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		return list;
		
	}

	@Override
	public models.Message get(int id) {

		models.Message message = null;
		
		try {
			
			statement = connect.createStatement();
	        resultSet = statement.executeQuery("select * from message where id=" + id);
	        
	        if (resultSet.next()) {
	        	
	        	String content = resultSet.getString("content");
	        	String timestamp = resultSet.getString("timestamp");
	        	models.Ticket ticket = new dao.Ticket().get(resultSet.getInt("ticket_id"));
	    		models.User user = new dao.User().get(resultSet.getInt("user_id"));
	        	
	    		message = new models.Message(id, content, timestamp ,ticket, user);
	        	
	        }
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		return message;
		
	}

	@Override
	public void edit(Object object) {
		// TODO Auto-generated method stub
		
	}
	
}
