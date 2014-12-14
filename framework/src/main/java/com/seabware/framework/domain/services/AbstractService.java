package com.seabware.framework.domain.services;


import com.seabware.framework.domain.model.AbstractEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class AbstractService<RT extends PagingAndSortingRepository<ET, ID>, ET extends AbstractEntity, ID extends java.io.Serializable>
{
	private RT repository;

	// --------------------------------------------------------------------------------------------------------------------------------
	public AbstractService(RT repository)
	{
		this.repository = repository;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public <S extends ET> S save(S entity)
	{
		return getRepository().save(entity);
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public ET findOne(ID primaryKey)
	{
		return getRepository().findOne(primaryKey);
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public Iterable<ET> findAll()
	{
		return getRepository().findAll();
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public Long count()
	{
		return getRepository().count();
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public void delete(ET entity)
	{
		getRepository().delete(entity);
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public boolean exists(ID primaryKey)
	{
		return getRepository().exists(primaryKey);
	}

    // --------------------------------------------------------------------------------------------------------------------------------
    public RT getRepository()
    {
        return this.repository;
    }

    // --------------------------------------------------------------------------------------------------------------------------------
    public void setRepository(RT repository)
    {
        this.repository = repository;
    }

}
