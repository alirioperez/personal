
package com.seabware.framework.domain.exceptions;

import org.springframework.validation.BindingResult;

// --------------------------------------------------------------------------------------------------------------------------------

/**
 * To be used to throw data binding errors from request at resource level.
 */
// --------------------------------------------------------------------------------------------------------------------------------
public class BindingErrorsException extends BaseException
{
	private static final long serialVersionUID = -4101765751423521391L;

	private BindingResult errors;

	// --------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Default constructor
	 */
	// --------------------------------------------------------------------------------------------------------------------------------
	public BindingErrorsException()
	{
		super();
	}

	// --------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Constructor with message
	 */
	// --------------------------------------------------------------------------------------------------------------------------------
	public BindingErrorsException(String message)
	{
		super(message);
	}

	// --------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Constructor with message and root cause
	 */
	// --------------------------------------------------------------------------------------------------------------------------------
	public BindingErrorsException(String message, Throwable cause)
	{
		super(message, cause);
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public BindingErrorsException(String message, BindingResult errors)
	{
		super(message);
		this.errors = errors;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public BindingResult getErrors()
	{
		return errors;
	}

}
