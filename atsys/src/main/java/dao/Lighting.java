package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import utils.DaoBase;

public class Lighting extends DaoBase {

	@Override
	public void add(Object object) {
		
		models.Lighting lighting = (models.Lighting) object;
		
		try {
			
			statement = connect.createStatement();
			String query = "insert into lighting (id, name, device_id, pin, logic_board_id, intensity) values ("+lighting.getId()+", '"+lighting.getName()+"', '"+lighting.getDeviceId()+"', "+lighting.getPin()+", "+lighting.getLogicBoard().getId()+", "+lighting.getIntensity()+")";
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
	    	statement.executeUpdate("delete from lighting where id=" + id);
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
    	
	}
	
	@Override	
	public ArrayList<models.Lighting> list() {
		
		ArrayList<models.Lighting> list = new ArrayList<models.Lighting>();

		try {
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from lighting");
	        while (resultSet.next()) {
	        	
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	int intensity = resultSet.getInt("intensity");
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	        	models.Lighting lighting = new models.Lighting(id, name, deviceId, pin, logicBoard, intensity);
	        	
	        	list.add(lighting);
	                
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
	public models.Lighting get(int id) {
		
		models.Lighting lighting = null;
		
		try {
			
			statement = connect.createStatement();
	        resultSet = statement.executeQuery("select * from lighting where id=" + id);
	        
	        if (resultSet.next()) {
	        	
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	int intensity = resultSet.getInt("intensity");
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	    		lighting = new models.Lighting(id, name, deviceId, pin, logicBoard, intensity);
	        	
	        }
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
        return lighting;
		
	}

	@Override
	public void edit(Object object) {

		models.Lighting lighting = (models.Lighting) object;
		
		try {
			
			statement = connect.createStatement();
			String query = "update lighting set name = '"+lighting.getName()+"', pin = "+lighting.getPin()+", logic_board_id = "+lighting.getLogicBoard().getId()+" where id = "+lighting.getId();
			statement.executeUpdate(query.replaceAll("'", "\""));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
	public void clientEditIntensity(int id, int intensity) {
		
		try {
			
			statement = connect.createStatement();
			String query = "update lighting set intensity = "+intensity+" where id = "+id;
			statement.executeUpdate(query.replaceAll("'", "\""));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
}