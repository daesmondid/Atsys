package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import enumerations.ConnectionStatus;
import utils.AtsysDefaultUtil;
import utils.DaoBase;

public class LogicBoard extends DaoBase {

	@Override
	public void add(Object object) {
		
		models.LogicBoard logicBoard = (models.LogicBoard) object;

		try {
			
			statement = connect.createStatement();
			String query = "insert into logic_board (id, name, address, connection_status, user_id) values ("+logicBoard.getId()+", '"+logicBoard.getName()+"', '"+logicBoard.getAddress()+"', "+AtsysDefaultUtil.getConnectionStatusMap().get(logicBoard.getConnectionStatus())+", "+logicBoard.getUser().getId()+")";
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
	    	statement.executeUpdate("delete from logic_board where id=" + id);
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
	@Override	
	public ArrayList<models.LogicBoard> list() {
		
		ArrayList<models.LogicBoard> list = new ArrayList<models.LogicBoard>();
		
		try {
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from logic_board");
	        while (resultSet.next()) {
	        	
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	        	String address = resultSet.getString("address");
	        	ConnectionStatus connectionStatus = AtsysDefaultUtil.getIntConnectionStatusMap().get(resultSet.getInt("connection_status"));
	        	models.User user = new dao.User().get(resultSet.getInt("user_id"));
	        	
	        	models.LogicBoard logicBoard = new models.LogicBoard(id, name, address, connectionStatus, user);
	        	
	        	list.add(logicBoard);
	                
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
	public models.LogicBoard get(int id) {

		models.LogicBoard logicBoard = null;
		
		try {
			
			statement = connect.createStatement();
	        resultSet = statement.executeQuery("select * from logic_board where id=" + id);
	        
	        if (resultSet.next()) {
	        	
	        	String name = resultSet.getString("name");
	        	String address = resultSet.getString("address");
	        	ConnectionStatus connectionStatus = AtsysDefaultUtil.getIntConnectionStatusMap().get(resultSet.getInt("connection_status"));
	        	models.User user = new dao.User().get(resultSet.getInt("user_id"));
	    		
	    		logicBoard = new models.LogicBoard(id, name, address, connectionStatus, user);
	        	
	        }
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		return logicBoard;
		
	}

	@Override
	public void edit(Object object) {

		models.LogicBoard logicBoard = (models.LogicBoard) object;

		try {
			
			statement = connect.createStatement();
			String query = "update logic_board set name = '"+logicBoard.getName()+"', address = '"+logicBoard.getAddress()+"', user_id = "+logicBoard.getUser().getId()+" where id = "+logicBoard.getId();
	    	statement.executeUpdate(query.replaceAll("'", "\""));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
	public void updateConnection(int id, ConnectionStatus connectionStatus) {

		try {
			
			statement = connect.createStatement();
			String query = "update logic_board set connection_status = "+AtsysDefaultUtil.getConnectionStatusMap().get(connectionStatus)+" where id = "+id;
	    	statement.executeUpdate(query.replaceAll("'", "\""));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
}
