package com.seabware.framework.domain.exceptions;

import javax.validation.ConstraintViolation;
import java.util.Set;

//--------------------------------------------------------------------------------------------------------------------------------

/**
 * Entity validation exception class. To be used when a create/update operation fails because of validations.
 */
//--------------------------------------------------------------------------------------------------------------------------------
public class EntityValidationException extends BaseException
{
	private static final long serialVersionUID = 2472834262313647000L;

	//--------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Default constructor
	 */
	//--------------------------------------------------------------------------------------------------------------------------------
	public EntityValidationException()
	{
		super();
	}

	//--------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Constructor with message
	 */
	//--------------------------------------------------------------------------------------------------------------------------------
	public EntityValidationException(String message)
	{
		super(message);
	}

	//--------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Constructor with message and violation
	 */
	//--------------------------------------------------------------------------------------------------------------------------------
	public EntityValidationException(String message, Violation violation)
	{
		super(message, violation);
	}

	//--------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Constructor with message and violation message
	 */
	//--------------------------------------------------------------------------------------------------------------------------------
	public EntityValidationException(String message, String violationMessageKey, Object... args)
	{
		super(message, violationMessageKey, args);
	}

	//--------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Constructor with message and violation message
	 */
	//--------------------------------------------------------------------------------------------------------------------------------
	public EntityValidationException(String message, Throwable cause, String violationMessageKey, Object... args)
	{
		super(message, cause, violationMessageKey, args);
	}

	//--------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Constructor with message and root cause
	 */
	//--------------------------------------------------------------------------------------------------------------------------------
	public EntityValidationException(String message, Throwable cause)
	{
		super(message, cause);
	}

	// --------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Constructor with message and reported constraint violations
	 */
	// --------------------------------------------------------------------------------------------------------------------------------
	public EntityValidationException(String message, Set<ConstraintViolation<?>> pViolations)
	{
		super(message, pViolations);
	}
}
