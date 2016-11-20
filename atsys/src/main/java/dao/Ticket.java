package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import enumerations.TicketStatus;
import utils.AtsysDefaultUtil;
import utils.DaoBase;

public class Ticket extends DaoBase {

	@Override
	public void add(Object object) {
		
		models.Ticket ticket = (models.Ticket) object;
		
		try {
			
			statement = connect.createStatement();
			String query = "insert into ticket (id, name, ticket_status, user_id, device_id) values ("+ticket.getId()+", '"+ticket.getName()+"', "+AtsysDefaultUtil.getTicketStatusMap().get(ticket.getTicketStatus())+", "+ticket.getUser().getId()+", '"+ticket.getDeviceId()+"')";
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
			statement.executeUpdate("delete from ticket where id=" + id);
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close();
		
	}
	
	@Override	
	public ArrayList<models.Ticket> list() {
		
		ArrayList<models.Ticket> list = new ArrayList<models.Ticket>();

		try {
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from atsys.ticket");
	        while (resultSet.next()) {
	        	
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	        	TicketStatus ticketStatus = AtsysDefaultUtil.getIntTicketStatusMap().get(resultSet.getInt("ticket_status"));
	        	String deviceId = resultSet.getString("device_id");
	        	models.User user = new dao.User().get(resultSet.getInt("user_id"));
	        	
	        	models.Ticket ticket = new models.Ticket(id, name, ticketStatus, user, deviceId);
	        	
	        	list.add(ticket);
	                
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
	public models.Ticket get(int id) {

		models.Ticket ticket = null;
		
		try {
			
			statement = connect.createStatement();
	        resultSet = statement.executeQuery("select * from ticket where id=" + id);
	        
	        if (resultSet.next()) {
	        	
	        	String name = resultSet.getString("name");
	        	TicketStatus ticketStatus = AtsysDefaultUtil.getIntTicketStatusMap().get(resultSet.getInt("ticket_status"));
	        	String deviceId = resultSet.getString("device_id");
	        	models.User user = new dao.User().get(resultSet.getInt("user_id"));
	        	
	        	ticket = new models.Ticket(id, name, ticketStatus, user, deviceId);
	        	
	        }
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		return ticket;
        
	}

	@Override
	public void edit(Object object) {

		models.Ticket ticket = (models.Ticket) object;
		
		try {
			
			statement = connect.createStatement();
			String query = "update ticket set name = '"+ticket.getName()+"', ticket_status = "+AtsysDefaultUtil.getTicketStatusMap().get(ticket.getTicketStatus())+", device_id = '"+ticket.getDeviceId()+"' where id = "+ticket.getId();
	    	statement.executeUpdate(query.replaceAll("'", "\""));
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close();
		
	}
	
}
