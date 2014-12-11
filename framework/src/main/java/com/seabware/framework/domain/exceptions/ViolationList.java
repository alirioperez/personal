package com.seabware.framework.domain.exceptions;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ViolationList
{

	@XmlElement(name = "violation")
	private List<Violation> violations = new ArrayList<Violation>();

	// --------------------------------------------------------------------------------------------------------------------------------
	public ViolationList(List<Violation> violations)
	{
		this.violations = violations;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public ViolationList()
	{

	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public List<Violation> getViolations()
	{
		return violations;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public void setViolations(List<Violation> violations)
	{
		this.violations = violations;
	}

}
