package com.seabware.framework.domain.facade;

import com.seabware.framework.domain.dto.AbstractDto;
import com.seabware.framework.domain.exceptions.DataNotFoundException;
import com.seabware.framework.domain.exceptions.Violation;
import com.seabware.framework.domain.model.AbstractEntity;
import com.seabware.framework.domain.services.AbstractService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

// ---------------------------------------------------------------------------------------------------------------------------

/**
 * Base class for facades. Provides basic CRUD operations.
 * @param <ST> the underlying Service type.
 * @param <DTOT> the underlying DTO type.
 * @param <ET> the underlying Entity type
 */
// ---------------------------------------------------------------------------------------------------------------------------
public class AbstractFacade<ST extends AbstractService, DTOT extends AbstractDto, ET extends AbstractEntity>
{
    @Autowired
    protected ST service;
    @Autowired
    protected MapperFacade mapper;

    private Class<DTOT> dtoTypeClass = (Class<DTOT>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    private Class<ET> entityTypeClass = (Class<ET>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];

    // ---------------------------------------------------------------------------------------------------------------------------
    public DTOT findOne(Long id)
    {
        ET entity = (ET) service.findOne(id);

        if (entity == null)
        {
            throw new DataNotFoundException("Entity not found", new Violation(id, entityTypeClass.getSimpleName()));
        }

        DTOT dto = mapper.map(entity, dtoTypeClass);

        return dto;
    }

    // ---------------------------------------------------------------------------------------------------------------------------
    public Iterable<DTOT> findAll()
    {
        Iterable<ET> entities = service.findAll();

        List<DTOT> dtos = new ArrayList<>();

        for (ET entity : entities)
        {
            DTOT dto = mapper.map(entity, dtoTypeClass);
            dtos.add(dto);
        }

        return dtos;
    }

    // ---------------------------------------------------------------------------------------------------------------------------
    public DTOT create(DTOT dto)
    {
        ET entityToBeSaved = mapper.map(dto, entityTypeClass);
        ET entityResult = (ET) service.save(entityToBeSaved);
        DTOT dtoToReturn = mapper.map(entityResult, dtoTypeClass);

        return dtoToReturn;
    }

    // ---------------------------------------------------------------------------------------------------------------------------
    @Transactional
    public DTOT update(Long id, DTOT dto)
    {
        ET entity = (ET) service.findOne(id);

        if (entity != null)
        {
            Long tempId = entity.getId();
            mapper.map(dto, entity);
            entity.setId(tempId);

            ET entityResult = (ET) service.save(entity);

            DTOT dtoToReturn = mapper.map(entityResult, dtoTypeClass);

            return dtoToReturn;
        }
        else
        {
            throw new DataNotFoundException("Entity not found", new Violation(id, entityTypeClass.getSimpleName()));
        }
    }

    // ---------------------------------------------------------------------------------------------------------------------------
    public void delete(Long id)
    {
        ET entity = (ET) service.findOne(id);

        if (entity != null)
        {
            service.delete(entity);
        }
        else
        {
            throw new DataNotFoundException("Entity not found", new Violation(id, entityTypeClass.getSimpleName()));
        }
    }
}
