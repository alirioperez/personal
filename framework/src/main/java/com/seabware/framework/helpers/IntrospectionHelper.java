package com.seabware.framework.helpers;

import com.seabware.framework.domain.exceptions.BaseException;

public class IntrospectionHelper
{

	private final static IntrospectionHelper INSTANCE = new IntrospectionHelper();

	// --------------------------------------------------------------------------------------------------------------------------------
	public static IntrospectionHelper getInstance()
	{
		return INSTANCE;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public <T> T newInstance(Class<T> modelClass)
	{
		try
		{
			return modelClass.newInstance();
		}
		catch (InstantiationException e)
		{
			throw new BaseException("could not instantiate class " + modelClass, e);
		}
		catch (IllegalAccessException e)
		{
			throw new BaseException("could not instantiate class " + modelClass, e);
		}
	}

	// --------------------------------------------------------------------------------------------------------------------------------
}
