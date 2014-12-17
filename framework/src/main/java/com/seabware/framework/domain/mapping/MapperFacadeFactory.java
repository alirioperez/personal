package com.seabware.framework.domain.mapping;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Mapper Facade Factory for the Orika Mapper Framework
 */
@Component
public class MapperFacadeFactory implements FactoryBean<MapperFacade>
{
    public MapperFacade getObject() throws Exception
    {
        return new DefaultMapperFactory.Builder().build().getMapperFacade();
    }

    public Class<?> getObjectType()
    {
        return MapperFacade.class;
    }

    public boolean isSingleton()
    {
        return true;
    }
}
