package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import enumerations.PowerStatus;
import utils.AtsysDefaultUtil;
import utils.DaoBase;

public class AudioSystem extends DaoBase {

	@Override
	public void add(Object object) {
		
		models.AudioSystem audioSystem = (models.AudioSystem) object;

		try {
			
			statement = connect.createStatement();
			String query = "insert into audio_system (id, name, device_id, pin, logic_board_id, volume_level, music_id, power_status) values ("+audioSystem.getId()+", '"+audioSystem.getName()+"', '"+audioSystem.getDeviceId()+"', "+audioSystem.getPin()+", "+audioSystem.getLogicBoard().getId()+", "+audioSystem.getVolumeLevel()+", "+audioSystem.getMusicId()+", "+AtsysDefaultUtil.getPowerStatusMap().get(audioSystem.getPowerStatus())+")";
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
	    	statement.executeUpdate("delete from audio_system where id=" + id);
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		
	}
	
	@Override	
	public ArrayList<models.AudioSystem> list() {
		
		ArrayList<models.AudioSystem> list = new ArrayList<models.AudioSystem>();

		try {
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from audio_system");
	        while (resultSet.next()) {
	        	
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	int volumeLevel = resultSet.getInt("volume_level");
	        	int musicId = resultSet.getInt("music_id");
	        	PowerStatus powerStatus = AtsysDefaultUtil.getIntPowerStatusMap().get(resultSet.getInt("power_status"));
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	        	models.AudioSystem audioSystem = new models.AudioSystem(id, name, deviceId, pin, logicBoard, volumeLevel, musicId, powerStatus);
	        	
	        	list.add(audioSystem);
	                
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
	public models.AudioSystem get(int id) {
		
		models.AudioSystem audioSystem = null;
		
		try {
			
			statement = connect.createStatement();
	        resultSet = statement.executeQuery("select * from audio_system where id=" + id);
	        
	        if (resultSet.next()) {
	        	
	        	String name = resultSet.getString("name");
	        	String deviceId = resultSet.getString("device_id");
	        	int pin = resultSet.getInt("pin");
	        	int volumeLevel = resultSet.getInt("volume_level");
	        	int musicId = resultSet.getInt("music_id");
	        	PowerStatus powerStatus = AtsysDefaultUtil.getIntPowerStatusMap().get(resultSet.getInt("power_status"));
	        	models.LogicBoard logicBoard = new dao.LogicBoard().get(resultSet.getInt("logic_board_id"));
	        	
	        	audioSystem = new models.AudioSystem(id, name, deviceId, pin, logicBoard, volumeLevel, musicId, powerStatus);        	
	        	
	        }
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		return audioSystem;
    	
	}
	
}
