package com.seabware.grocery.domain.dto.criteria;

import com.seabware.framework.domain.dto.AbstractCriteriaDto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemCriteriaDto extends AbstractCriteriaDto
{
	private static final long serialVersionUID = 1809408999902445342L;

	private String username;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private Boolean admin;

	private Boolean enabled;

	//--------------------------------------------------------------------------------------------------------------------------------
	public String getUsername()
	{
		return username;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public void setUsername(String username)
	{
		this.username = username;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public String getFirstName()
	{
		return firstName;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public String getLastName()
	{
		return lastName;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public String getEmail()
	{
		return email;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public void setEmail(String email)
	{
		this.email = email;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public String getPhone()
	{
		return phone;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public Boolean getAdmin()
	{
		return admin;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public void setAdmin(Boolean admin)
	{
		this.admin = admin;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public Boolean getEnabled()
	{
		return enabled;
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	public void setEnabled(Boolean enabled)
	{
		this.enabled = enabled;
	}
}