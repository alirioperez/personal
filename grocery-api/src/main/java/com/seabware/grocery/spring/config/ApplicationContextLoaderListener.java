package com.seabware.grocery.spring.config;

import com.seabware.framework.spring.config.SeabwareContextLoaderListener;

import javax.servlet.ServletContextEvent;


public class ApplicationContextLoaderListener extends SeabwareContextLoaderListener
{
	// --------------------------------------------------------------------------------------------------------------------------------
	public void contextDestroyed(javax.servlet.ServletContextEvent event)
	{
		super.contextDestroyed(event);
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	@Override
	public void contextInitialized(final ServletContextEvent event)
	{
		super.contextInitialized(event);
	}
}
