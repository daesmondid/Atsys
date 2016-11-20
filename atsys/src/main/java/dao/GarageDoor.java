package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import enumerations.DoorStatus;
import utils.AtsysDefaultUtil;
import utils.DaoBase;

public class GarageDoor extends DaoBase {

	@Override
	public void add(Object object) {
		
		models.GarageDoor garageDoor = (models.GarageDoor) object;

		try {
			
			statement = connect.createStatement();
			String query = "insert into garage_door (id, name, device_id, pin, logic_board_id, door_status) values ("+garageDoor.getId()+", '"+garageDoor.getName()+"', '"+garageDoor.getDeviceId()+"', "+garageDoor.getPin()+", "+garageDoor.getLogicBoard().getId()+", "+AtsysDefaultUtil.getDoorStatusMap().get(garageDoor.getDoorStatus())+")";
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
	    	statement.executeUpdate("delete from garage_door where id=" + id);			
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
	@Override	
	public ArrayList<models.GarageDoor> list() {
		
		ArrayList<models.GarageDoor> list = new ArrayList<models.GarageDoor>();
		
		try {
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from garage_door");
	        while (resultSet.next()) {
	        	
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	DoorStatus doorStatus = AtsysDefaultUtil.getIntDoorStatusMap().get(resultSet.getInt("door_status"));
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	        	models.GarageDoor garageDoor = new models.GarageDoor(id, name, deviceId, pin, logicBoard, doorStatus);
	        	
	        	list.add(garageDoor);
	                
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
	public models.GarageDoor get(int id) {

		models.GarageDoor garageDoor = null;
		
		try {
			
			statement = connect.createStatement();
	        resultSet = statement.executeQuery("select * from garage_door where id=" + id);
	        
	        if (resultSet.next()) {
	        	
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	DoorStatus doorStatus = AtsysDefaultUtil.getIntDoorStatusMap().get(resultSet.getInt("door_status"));
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	    		garageDoor = new models.GarageDoor(id, name, deviceId, pin, logicBoard, doorStatus);
	        	
	        }
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		return garageDoor;
		
	}
	
}