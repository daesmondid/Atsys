package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import enumerations.PowerStatus;
import utils.AtsysDefaultUtil;
import utils.DaoBase;

public class Climate extends DaoBase {

	@Override
	public void add(Object object) {
		
		models.Climate climate = (models.Climate) object;
		
		try {
			
			statement = connect.createStatement();
			String query = "insert into climate (id, name, device_id, pin, logic_board_id, temperature, power_status) values ("+climate.getId()+", '"+climate.getName()+"', '"+climate.getDeviceId()+"', "+climate.getPin()+", "+climate.getLogicBoard().getId()+", "+climate.getTemperature()+", "+AtsysDefaultUtil.getPowerStatusMap().get(climate.getPowerStatus())+")";
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
	    	statement.executeUpdate("delete from climate where id=" + id);
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
	@Override	
	public ArrayList<models.Climate> list() {
		
		ArrayList<models.Climate> list = new ArrayList<models.Climate>();
		
		try {
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from climate");
			
	        while (resultSet.next()) {
	        	
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	int temperature = resultSet.getInt("temperature");
	        	PowerStatus powerStatus = AtsysDefaultUtil.getIntPowerStatusMap().get(resultSet.getInt("power_status"));
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	        	models.Climate climate = new models.Climate(id, name, deviceId, pin, logicBoard, temperature, powerStatus);
	        	
	        	list.add(climate);
	                
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
	public models.Climate get(int id) {
		
		models.Climate climate = null;
		
		try {
			
			statement = connect.createStatement();
	        resultSet = statement.executeQuery("select * from climate where id=" + id);
	        
	        if (resultSet.next()) {
	        	
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	int temperature = resultSet.getInt("temperature");
	        	PowerStatus powerStatus = AtsysDefaultUtil.getIntPowerStatusMap().get(resultSet.getInt("power_status"));
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	        	climate = new models.Climate(id, name, deviceId, pin, logicBoard, temperature, powerStatus);
	        	
	        }
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
        return climate;
    	
	}

	@Override
	public void edit(Object object) {

		models.Climate climate = (models.Climate) object;
		
		try {
			
			statement = connect.createStatement();
			String query = "update climate set name = '"+climate.getName()+"', pin = "+climate.getPin()+", logic_board_id = "+climate.getLogicBoard().getId()+" where id = "+climate.getId();
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
			String query = "update climate set power_status = "+power+" where id = "+id;
			statement.executeUpdate(query.replaceAll("'", "\""));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}

	public void clientEditTemperature(int id, int temperature) {

		try {
			
			statement = connect.createStatement();
			String query = "update climate set temperature = "+temperature+" where id = "+id;
			statement.executeUpdate(query.replaceAll("'", "\""));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
}
