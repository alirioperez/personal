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
	public RT getRepository()
	{
		return this.repository;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public void setRepository(RT repository)
	{
		this.repository = repository;
	}


	// --------------------------------------------------------------------------------------------------------------------------------
	public <S extends ET> S save(S entity)
	{
		return getRepository().save(entity);
	}

//	// --------------------------------------------------------------------------------------------------------------------------------
//	public DTOT findOne(ID primaryKey)
//	{
//		ET entity = _findOne(primaryKey);
//		DTOT dto = createDto();
//
//		convert(entity, dto);
//
//		return dto;
//	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public ET findOne(ID primaryKey)
	{
		return getRepository().findOne(primaryKey);
	}

//	// --------------------------------------------------------------------------------------------------------------------------------
//	public Iterable<DTOT> findAll()
//	{
//		Iterable<ET> entities = _findAll();
//
//		List<DTOT> dtos = new ArrayList<>();
//
//		for (ET entity : entities)
//		{
//
//			DTOT dto = createDto();
//
//			convert(entity, dto);
//
//			dtos.add(dto);
//		}
//
//		return dtos;
//	}

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
}
