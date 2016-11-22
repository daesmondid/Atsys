package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import enumerations.PowerStatus;
import utils.AtsysDefaultUtil;
import utils.DaoBase;

public class Appliances extends DaoBase {

	@Override
	public void add(Object object) {
		
		models.Appliances appliances = (models.Appliances) object;
		
		try {
			
			statement = connect.createStatement();
			String query = "insert into appliances (id, name, device_id, pin, logic_board_id, power_status) values ("+appliances.getId()+", '"+appliances.getName()+"', '"+appliances.getDeviceId()+"', "+appliances.getPin()+", "+appliances.getLogicBoard().getId()+", "+AtsysDefaultUtil.getPowerStatusMap().get(appliances.getPowerStatus())+")";
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
	    	statement.executeUpdate("delete from appliances where id=" + id);
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
	@Override	
	public ArrayList<models.Appliances> list() {
		
		ArrayList<models.Appliances> list = new ArrayList<models.Appliances>();
		
		try {
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from appliances");
	        while (resultSet.next()) {
	        	
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	PowerStatus powerStatus = AtsysDefaultUtil.getIntPowerStatusMap().get(resultSet.getInt("power_status"));
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	        	models.Appliances appliances = new models.Appliances(id, name, deviceId, pin, logicBoard, powerStatus);
	        	
	        	list.add(appliances);
	                
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
	public models.Appliances get(int id) {

		models.Appliances appliances = null;
		
		try {
			
			statement = connect.createStatement();
	        resultSet = statement.executeQuery("select * from appliances where id=" + id);
	        
	        if (resultSet.next()) {
	        	
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	PowerStatus powerStatus = AtsysDefaultUtil.getIntPowerStatusMap().get(resultSet.getInt("power_status"));
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	        	appliances = new models.Appliances(id, name, deviceId, pin, logicBoard, powerStatus);
	        	
	        }
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
        return appliances;
		
	}

	@Override
	public void edit(Object object) {

		models.Appliances appliances = (models.Appliances) object;
		
		try {
			
			statement = connect.createStatement();
			String query = "update appliances set name = '"+appliances.getName()+"', pin = "+appliances.getPin()+", logic_board_id = "+appliances.getLogicBoard().getId()+" where id = "+appliances.getId();
			statement.executeUpdate(query.replaceAll("'", "\""));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
    	
	}

	public void clientEditPower(int id, int power) {

		try {
			
			statement = connect.createStatement();
			String query = "update appliances set power_status = "+power+" where id = "+id;
			statement.executeUpdate(query.replaceAll("'", "\""));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
}