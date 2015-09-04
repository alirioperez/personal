package com.seabware.framework.domain.services;


import com.seabware.framework.domain.model.AbstractBaseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Base class for all atomic services providing basic CRUD operations
 *
 * @param <RT> the underlying repository type
 * @param <ET> the underlying Entity type
 */
public abstract class AbstractBaseService<RT extends PagingAndSortingRepository<ET, Long>, ET extends AbstractBaseEntity>
{
    private RT repository;

    public AbstractBaseService(RT repository)
    {
        this.repository = repository;
    }

    /**
     * Saves an entity
     *
     * @param entity the entity to be saved
     * @return the saved entity
     */
    public ET save(ET entity)
    {
        return getRepository().save(entity);
    }

    /**
     * Find one entity given its primary key
     *
     * @param primaryKey the primary key of the entity
     * @return the entity associated to the given primary key
     */
    public ET findOne(Long primaryKey)
    {
        return getRepository().findOne(primaryKey);
    }

    /**
     * Finds all entities
     *
     * @return a iterable structure containing all entities
     */
    public Iterable<ET> findAll()
    {
        return getRepository().findAll();
    }

    /**
     * Counts all entities in the repo
     *
     * @return the count of all entities
     */
    public Long count()
    {
        return getRepository().count();
    }

    /**
     * Deletes an entity provided
     *
     * @param entity the entity to be deleted
     */
    public void delete(ET entity)
    {
        getRepository().delete(entity);
    }

    /**
     * Checks whether an entity exists or not given its primary key
     *
     * @param primaryKey the primary key of the entity to check
     * @return a boolean indicating whether the entity exists or not
     */
    public boolean exists(Long primaryKey)
    {
        return getRepository().exists(primaryKey);
    }

    /**
     * Accesor for the repo
     *
     * @return the repo used in this service
     */
    public RT getRepository()
    {
        return this.repository;
    }

    /**
     * Setter for the repo
     *
     * @param repository the repo to be set
     */
    public void setRepository(RT repository)
    {
        this.repository = repository;
    }
}
