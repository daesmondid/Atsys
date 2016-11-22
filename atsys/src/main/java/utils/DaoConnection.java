package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoConnection {
	
	protected Connection connect = null;
	protected Statement statement = null;
	protected ResultSet resultSet = null;
	
	final protected String xhost = "188.166.238.168";
	final protected String xuser = "atsysuser";
	final protected String xpasswd = "d@H!2brTg5D4";
	final protected String xdatabase = "atsys";
	
//	final protected String xhost = "127.0.0.1";
//	final protected String xuser = "root";
//	final protected String xpasswd = "";
//	final protected String xdatabase = "atsys";
	
	public DaoConnection() {
		
		try {
			connectToDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void connectToDB() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://" + xhost + "/"
					+ xdatabase + "?" + "user=" + xuser + "&password=" + xpasswd);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			
			if (statement != null) {
				statement.close();
			}
			
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			
		}
	}

}
