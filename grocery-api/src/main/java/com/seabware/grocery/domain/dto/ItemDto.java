package com.seabware.grocery.domain.dto;

import com.seabware.framework.domain.dto.AbstractBaseDto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemDto extends AbstractBaseDto
{
	private static final long serialVersionUID = 1L;

	private String name;

    private String unitOfMeasure;

	//--------------------------------------------------------------------------------------------------------------------------------
	public String getName()
	{
		return name;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public void setName(String name)
	{
		this.name = name;
	}

    //--------------------------------------------------------------------------------------------------------------------------------
    public String getUnitOfMeasure()
    {
        return unitOfMeasure;
    }

    //--------------------------------------------------------------------------------------------------------------------------------
    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
