package com.seabware.framework.domain.exceptions;

import org.springframework.validation.BindingResult;

/**
 * To be used to throw data binding errors from request at resource level.
 */
public class BindingErrorsException extends BaseException
{
    private static final long serialVersionUID = -4101765751423521391L;

    private BindingResult errors;

    /**
     * Default constructor
     */
    public BindingErrorsException()
    {
        super();
    }

    /**
     * Constructor with:
     *
     * @param message the exception message
     */
    public BindingErrorsException(String message)
    {
        super(message);
    }

    /**
     * Constructor with:
     *
     * @param message the exception message
     * @param cause   the exception cause
     */
    public BindingErrorsException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * Constructor with:
     *
     * @param message the exception message
     * @param errors  the BindingResult wrapper object
     */
    public BindingErrorsException(String message, BindingResult errors)
    {
        super(message);
        this.errors = errors;
    }

    /**
     * Accesor for errors
     *
     * @return a BindingResult wrapper object
     */
    public BindingResult getErrors()
    {
        return errors;
    }
}
