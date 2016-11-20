package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import utils.DaoConnection;

public class Device extends DaoConnection {

	public ArrayList<models.Device> list() {
		
		ArrayList<models.Device> list = new ArrayList<models.Device>();
		
		try {
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from device");
	        while (resultSet.next()) {
	        	
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	        	models.Device device = new models.Device(id, name, deviceId, pin, logicBoard);
	        	
	        	list.add(device);
	                
	        }
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		return list;
		
	}
	
}
