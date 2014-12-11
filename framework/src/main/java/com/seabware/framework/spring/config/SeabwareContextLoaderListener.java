package com.seabware.framework.spring.config;

import javax.servlet.ServletContextEvent;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;


public class SeabwareContextLoaderListener extends org.springframework.web.context.ContextLoaderListener
{
	// --------------------------------------------------------------------------------------------------------------------------------
	public void contextDestroyed(javax.servlet.ServletContextEvent event)
	{
		super.contextDestroyed(event);

		// This manually de-registers JDBC driver, which prevents Tomcat 7 from complaining about memory leaks wrto this class
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements())
		{
			Driver driver = drivers.nextElement();
			try
			{
				DriverManager.deregisterDriver(driver);
				//LOG.log(Level.INFO, String.format("deregistering jdbc driver: %s", driver));
			}
			catch (SQLException e)
			{
				//LOG.log(Level.SEVERE, String.format("Error deregistering driver %s", driver), e);
			}

		}
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	@Override
	public void contextInitialized(final ServletContextEvent event)
	{
		super.contextInitialized(event);
	}
}
