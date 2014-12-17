package com.seabware.framework.helpers;

import com.seabware.framework.domain.exceptions.BaseException;

/**
 * Utility class for introspection functions
 */
public class IntrospectionHelper
{

    private final static IntrospectionHelper INSTANCE = new IntrospectionHelper();

    public static IntrospectionHelper getInstance()
    {
        return INSTANCE;
    }

    /**
     * Creates a new instance for a given class
     *
     * @param modelClass the model class to be instantiated
     * @param <T>        generic class type
     * @return the new instance
     */
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
