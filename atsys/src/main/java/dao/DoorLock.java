package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import enumerations.LockStatus;
import utils.AtsysDefaultUtil;
import utils.CommunicationControl;
import utils.DaoBase;

public class DoorLock extends DaoBase {

	@Override
	public void add(Object object) {
		
		models.DoorLock doorLock = (models.DoorLock) object;
		
		try {
			
			statement = connect.createStatement();
			String query = "insert into door_lock (id, name, device_id, pin, logic_board_id, lock_status) values ("+doorLock.getId()+", '"+doorLock.getName()+"', '"+doorLock.getDeviceId()+"', "+doorLock.getPin()+", "+doorLock.getLogicBoard().getId()+", "+AtsysDefaultUtil.getLockStatusMap().get(doorLock.getLockStatus())+")";
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
	    	statement.executeUpdate("delete from door_lock where id=" + id);
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
	@Override	
	public ArrayList<models.DoorLock> list() {
		
		ArrayList<models.DoorLock> list = new ArrayList<models.DoorLock>();
		
		try {
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from door_lock");
	        while (resultSet.next()) {
	        	
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	LockStatus lockStatus = AtsysDefaultUtil.getIntLockStatusMap().get(resultSet.getInt("lock_status"));
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	        	models.DoorLock doorLock = new models.DoorLock(id, name, deviceId, pin, logicBoard, lockStatus);
	        	
	        	list.add(doorLock);
	                
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
	public models.DoorLock get(int id) {

		models.DoorLock doorLock = null;
		
		try {
			
			statement = connect.createStatement();
	        resultSet = statement.executeQuery("select * from door_lock where id=" + id);
	        
	        if (resultSet.next()) {
	        	
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	LockStatus lockStatus = AtsysDefaultUtil.getIntLockStatusMap().get(resultSet.getInt("lock_status"));
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	        	doorLock = new models.DoorLock(id, name, deviceId, pin, logicBoard, lockStatus);
	        	
	        }
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
        return doorLock;
		
	}

	@Override
	public void edit(Object object) {

		models.DoorLock doorLock = (models.DoorLock) object;
		
		try {
			
			statement = connect.createStatement();
			String query = "update door_lock set name = '"+doorLock.getName()+"', pin = "+doorLock.getPin()+", logic_board_id = "+doorLock.getLogicBoard().getId()+" where id = "+doorLock.getId();
			statement.executeUpdate(query.replaceAll("'", "\""));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}

	public void clientEditLock(int id, int lock) {
		
		try {
			
			statement = connect.createStatement();
			String query = "update door_lock set lock_status = "+lock+" where id = "+id;
			statement.executeUpdate(query.replaceAll("'", "\""));
			
			CommunicationControl.message(new dao.DoorLock().get(id).getLogicBoard().getId(), ":DOORLOCK:" + id + ":" + lock);
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
}