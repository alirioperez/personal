package com.seabware.grocery.domain.model;

import com.seabware.framework.domain.model.AbstractEntity;
import com.seabware.grocery.domain.model.enums.UnitOfMeasureEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Item extends AbstractEntity
{
	private String name;
    private UnitOfMeasureEnum unitOfMeasure;

//	@OneToMany
//	private List<Address> addresses;
//	@OneToMany
//	private Map<String, Profile> profiles;

	@NotNull
    public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

    @Enumerated(EnumType.STRING)
    public UnitOfMeasureEnum getUnitOfMeasure()
    {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasureEnum unitOfMeasure)
    {
        this.unitOfMeasure = unitOfMeasure;
    }
}
