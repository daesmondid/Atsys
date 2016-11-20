package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoConnection {
	
	protected Connection connect = null;
	protected Statement statement = null;
	protected ResultSet resultSet = null;
	
	final protected String xhost = "128.199.111.126";
	final protected String xuser = "remoteuser";
	final protected String xpasswd = "It2014";
	final protected String xdatabase = "atsys";
	
	
	
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