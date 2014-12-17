package com.seabware.framework.domain.facade;

import com.seabware.framework.domain.dto.AbstractDto;
import com.seabware.framework.domain.exceptions.DataNotFoundException;
import com.seabware.framework.domain.exceptions.EntityValidationException;
import com.seabware.framework.domain.exceptions.Violation;
import com.seabware.framework.domain.model.AbstractEntity;
import com.seabware.framework.domain.services.AbstractService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionSystemException;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class for facades. Provides basic CRUD operations.
 *
 * @param <ST>   the underlying Service type.
 * @param <DTOT> the underlying DTO type.
 * @param <ET>   the underlying Entity type
 */
public class AbstractFacade<ST extends AbstractService, DTOT extends AbstractDto, ET extends AbstractEntity>
{
    @Autowired
    protected ST service;
    @Autowired
    protected MapperFacade mapper;

    private Class<DTOT> dtoTypeClass = (Class<DTOT>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    private Class<ET> entityTypeClass = (Class<ET>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];

    /**
     * Finds only one entity given its id or primary key
     *
     * @param id primary key of the entity to be found
     * @return a DTO representation of the entity found
     */
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

    /**
     * Finds all entities
     *
     * @return a Iterable of DTO representations for the underlying entity
     */
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

    /**
     * Creates an entity
     *
     * @param dto the DTO representation of the new entity
     * @return the resulting DTO representation of the new entity
     */
    public DTOT create(DTOT dto)
    {
        ET entityToBeSaved = mapper.map(dto, entityTypeClass);
        ET entityResult = null;

        try
        {
            entityResult = (ET) service.save(entityToBeSaved);

            DTOT dtoToReturn = mapper.map(entityResult, dtoTypeClass);

            return dtoToReturn;
        }
        catch (TransactionSystemException exception)
        {
            EntityValidationException translatedException = translateTransactionSystemException(exception);

            if (translatedException != null)
            {
                throw translatedException;
            }

            throw exception;
        }
    }

    /**
     * Updates an entity given its primary key and the DTO containing the changes
     *
     * @param id  the primary key of the entity to be updated
     * @param dto the DTO representation containing the changes
     * @return the DTO representation of the updated entity
     */
    @Transactional
    public DTOT update(Long id, DTOT dto)
    {
        ET entity = (ET) service.findOne(id);

        if (entity != null)
        {
            Long tempId = entity.getId();
            mapper.map(dto, entity);
            entity.setId(tempId);

            ET entityResult = null;

            try
            {
                entityResult = (ET) service.save(entity);

                DTOT dtoToReturn = mapper.map(entityResult, dtoTypeClass);

                return dtoToReturn;
            }
            catch (TransactionSystemException exception)
            {
                EntityValidationException translatedException = translateTransactionSystemException(exception);

                if (translatedException != null)
                {
                    throw translatedException;
                }

                throw exception;
            }
        }
        else
        {
            throw new DataNotFoundException("Entity not found", new Violation(id, entityTypeClass.getSimpleName()));
        }
    }

    /**
     * Deletes an entity given its primary key
     *
     * @param id the primary key of the entity to be deleted
     */
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

    private EntityValidationException translateTransactionSystemException(TransactionSystemException exception)
    {
        if (exception.getCause() != null)
        {
            if (exception.getCause().getCause() != null && exception.getCause().getCause() instanceof ConstraintViolationException)
            {
                ConstraintViolationException innerException = (ConstraintViolationException) exception.getCause().getCause();

                return new EntityValidationException("Entity not found", innerException.getConstraintViolations());
            }
        }

        return null;
    }
}
