package com.seabware.framework.spring.config;

import javax.servlet.ServletContextEvent;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;


/**
 * Base Spring context loader listener to be used in apps.
 */
public class SeabwareContextLoaderListener extends org.springframework.web.context.ContextLoaderListener
{
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
			}
			catch (SQLException e)
			{
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
