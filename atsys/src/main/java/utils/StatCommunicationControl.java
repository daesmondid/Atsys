package utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StatCommunicationControl implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("Starting up Connection Service!");
		new Thread(new MultiThreadServerService()).start();
		
	}

}
