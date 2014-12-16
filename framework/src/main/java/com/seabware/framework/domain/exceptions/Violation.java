package com.seabware.framework.domain.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

// --------------------------------------------------------------------------------------------------------------------------------
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Violation implements Serializable
{
	private static final long serialVersionUID = 1607527855319543525L;

	@NotNull
	@XmlElement
	private String entity;

	@XmlElement
	private String property;

	@XmlElement
	private String extendedInfo;

	@NotNull
	@XmlElement
	private String messageKey;

	@XmlElement
	private Serializable id;

	@XmlElement
	private String message;

	@XmlTransient
	/**arguments for resolving messageKey*/
	private Object[] arguments;

	// --------------------------------------------------------------------------------------------------------------------------------
	public Violation()
	{
	}

    public Violation(Serializable id)
    {
        this();
        this.setId(id);
    }

    public Violation(String entity)
    {
        this();
        this.setEntity(entity);
    }

    public Violation(Serializable id, String entity)
	{
		this(id);
		this.setEntity(entity);
	}

	public Violation(String entity, String property)
	{
		this(entity);
		this.setProperty(property);
	}

	public Violation(String entity, String property, String messageKey)
	{
		this(entity, property);
		this.setMessageKey(messageKey);
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public Violation(ConstraintViolation<?> source)
	{
		this();

		entity = source.getRootBeanClass().getSimpleName();
		property = source.getPropertyPath() == null ? null : source.getPropertyPath().toString();
		messageKey = source.getMessageTemplate();
		message = source.getMessage();
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	@Override
	public String toString()
	{
		return "Entity: " + entity + (property == null ? "" : ", Property: " + property) + ", MessageKey: " + messageKey + ", Message: " + message;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public String getEntity()
	{
		return entity;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public void setEntity(String entity)
	{
		this.entity = entity;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public String getProperty()
	{
		return property;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public void setProperty(String property)
	{
		this.property = property;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public String getMessageKey()
	{
		return messageKey;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public void setMessageKey(String messageKey)
	{
		this.messageKey = messageKey;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public String getMessage()
	{
		return message;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public void setMessage(String message)
	{
		this.message = message;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public String getExtendedInfo()
	{
		return extendedInfo;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public void setExtendedInfo(String extendedInfo)
	{
		this.extendedInfo = extendedInfo;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public Serializable getID()
	{
		return id;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public void setId(Serializable id)
	{
		this.id = id;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public Object[] getArguments()
	{
		return arguments;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public void setArguments(Object[] arguments)
	{
		this.arguments = arguments;
	}

}
