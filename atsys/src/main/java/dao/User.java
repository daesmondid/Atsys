package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import enumerations.UserType;
import utils.AtsysDefaultUtil;
import utils.DaoBase;

public class User extends DaoBase {

	@Override
	public void add(Object object) {
		
		models.User user = (models.User) object;
		
		try {
			
			statement = connect.createStatement();
			String query = "insert into user (id, name, username, password, user_type, address, email, mobile_phone, home_phone) values ("+user.getId()+", '"+user.getName()+"', '"+user.getUsername()+"', '"+user.getPassword()+"', "+AtsysDefaultUtil.getUserTypeMap().get(user.getUserType())+", '"+user.getAddress()+"', '"+user.getEmail()+"', '"+user.getMobilePhone()+"', '"+user.getHomePhone()+"')";
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
			statement.executeUpdate("delete from user where id=" + id);
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close();
    	
	}
	
	@Override	
	public ArrayList<models.User> list() {
		
		ArrayList<models.User> list = new ArrayList<models.User>();

		try {
			
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from user");
	        while (resultSet.next()) {
	        	
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	        	String username = resultSet.getString("username");
	        	String password = resultSet.getString("password");
	        	UserType userType = AtsysDefaultUtil.getIntUserTypeMap().get(resultSet.getInt("user_type"));
	        	String address = resultSet.getString("address");
	        	String email = resultSet.getString("email");
	        	String mobilePhone = resultSet.getString("mobile_phone");
	        	String homePhone = resultSet.getString("home_phone");
	        	
	        	models.User user = new models.User(id, name, username, password, userType, address, email, mobilePhone, homePhone);
	        	
	        	list.add(user);
	                
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
	public models.User get(int id) {

		models.User user = null;
		
		try {
			
			statement = connect.createStatement();
	        resultSet = statement.executeQuery("select * from user where id=" + id);
	        
	        if (resultSet.next()) {
	        	
	        	String name = resultSet.getString("name");
	        	String username = resultSet.getString("username");
	        	String password = resultSet.getString("password");
	        	UserType userType = AtsysDefaultUtil.getIntUserTypeMap().get(resultSet.getInt("user_type"));
	        	String address = resultSet.getString("address");
	        	String email = resultSet.getString("email");
	        	String mobilePhone = resultSet.getString("mobile_phone");
	        	String homePhone = resultSet.getString("home_phone");
	        	
	        	user = new models.User(id, name, username, password, userType, address, email, mobilePhone, homePhone);
	        	
	        }
	        	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close();
		return user;
		
	}
	
	public models.User get(String username, String password) {
		
		models.User user = null;
		
		try {
			
			statement = connect.createStatement();
	        resultSet = statement.executeQuery("select * from user where username = \""+username+"\" and password = \""+password+"\"");
	        
	        if (resultSet.next()) {
	        	
	        	int id = resultSet.getInt("id");
	            String name = resultSet.getString("name");
	            UserType userType = AtsysDefaultUtil.getIntUserTypeMap().get(resultSet.getInt("user_type"));
	        	String address = resultSet.getString("address");
	        	String email = resultSet.getString("email");
	        	String mobilePhone = resultSet.getString("mobile_phone");
	        	String homePhone = resultSet.getString("home_phone");
	        	
	        	user = new models.User(id, name, username, password, userType, address, email, mobilePhone, homePhone);
	        	
	        }
	        	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close();
		return user;
    	
	}
	
	public int countUserMatch(String username, String password) {

		int counter = 0;
		
		try {
			
			statement = connect.createStatement();
	    	resultSet = statement.executeQuery("select * from user where username = \"" + username + "\" and password = \"" + password + "\"");
	        while (resultSet.next()) {
	        	
	        	counter++;
	                
	        }
	        	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                  
		close();
        return counter;
        
    }

	@Override
	public void edit(Object object) {

		models.User user = (models.User) object;
		
		try {
			
			statement = connect.createStatement();
			String query = "update user set name = '"+user.getName()+"', username = '"+user.getUsername()+"', password = '"+user.getPassword()+"', user_type = "+AtsysDefaultUtil.getUserTypeMap().get(user.getUserType())+", address = '"+user.getAddress()+"', email = '"+user.getEmail()+"', mobile_phone = '"+user.getMobilePhone()+"', home_phone = '"+user.getHomePhone()+"' where id = "+user.getId();
			statement.executeUpdate(query.replaceAll("'", "\""));
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close();
		
	}
	
}
