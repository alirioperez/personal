package com.seabware.grocery.domain.model;

import com.seabware.framework.domain.model.AbstractEntity;
import com.seabware.grocery.domain.model.enums.UnitOfMeasureEnum;

import javax.persistence.*;

@Entity
public class Item extends AbstractEntity
{

	@Id
	@GeneratedValue
	private Long id;

	private String name;

    @Enumerated(EnumType.STRING)
    private UnitOfMeasureEnum unitOfMeasure;

//	@OneToMany
//	private List<Address> addresses;
//	@OneToMany
//	private Map<String, Profile> profiles;

	public Item()
	{
	}

	public Item(Long id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public Item(String name)
	{
		this.name = name;
	}

	public Long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

    public UnitOfMeasureEnum getUnitOfMeasure()
    {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasureEnum unitOfMeasure)
    {
        this.unitOfMeasure = unitOfMeasure;
    }
}
