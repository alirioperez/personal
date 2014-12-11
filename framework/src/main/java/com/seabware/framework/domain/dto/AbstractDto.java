package com.seabware.framework.domain.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public abstract class AbstractDto implements Serializable
{
	private static final long serialVersionUID = 7855076355718651865L;

	private Long id;
	private Long version;

	// ---------------------------------------------------------------------------------------------------------------------------
	public void copyValuesFrom(Object source)
	{
		org.springframework.beans.BeanUtils.copyProperties(source, this);
	}

	// ---------------------------------------------------------------------------------------------------------------------------
	public void copyValuesFrom(Object source, String[] ignoreProperties)
	{
		org.springframework.beans.BeanUtils.copyProperties(source, this, ignoreProperties);
	}

	// ---------------------------------------------------------------------------------------------------------------------------
	public void copyValuesTo(Object target)
	{
		org.springframework.beans.BeanUtils.copyProperties(this, target);
	}

	// ---------------------------------------------------------------------------------------------------------------------------
	public void copyValuesTo(Object target, String[] ignoreProperties)
	{
		org.springframework.beans.BeanUtils.copyProperties(this, target, ignoreProperties);
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public Long getId()
	{
		return id;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public void setId(Long id)
	{
		this.id = id;
	}

	// ---------------------------------------------------------------------------------------------------------------------------
	public Long getVersion()
	{
		return version;
	}

	// ---------------------------------------------------------------------------------------------------------------------------
	public void setVersion(Long version)
	{
		this.version = version;
	}

}
