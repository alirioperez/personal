package com.seabware.grocery.domain.dto;

import com.seabware.framework.domain.dto.AbstractDto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemDto extends AbstractDto
{
	private static final long serialVersionUID = 1L;

	private String name;

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
}
