package com.seabware.framework.domain.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Base exception class.
 */
public class BaseException extends RuntimeException
{
    private static final long serialVersionUID = -3737363614162576677L;

    protected List<Violation> violations = new ArrayList<Violation>();

    /**
     * Default constructor
     */
    public BaseException()
    {
        super();
    }

    /**
     * Constructor with:
     *
     * @param message
     * @param cause
     */
    public BaseException(String message, Throwable cause)
    {
        super(message, cause);
    }


    /**
     * Constructor with:
     *
     * @param message the exception message
     */
    public BaseException(String message)
    {
        this(message, (Throwable) null);
    }

    /**
     * Constructor with:
     *
     * @param message                   the exception message
     * @param violationMessageKey       violation message key for localization purposes
     * @param violationMessageArguments arguments of violations
     */
    public BaseException(String message, String violationMessageKey, Object... violationMessageArguments)
    {
        this(message, (Throwable) null, violationMessageKey, violationMessageArguments);
    }

    /**
     * Constructor with:
     *
     * @param message             the exception message
     * @param cause               the cause
     * @param violationMessageKey violation message key for localization purposes
     * @param arguments           arguments of violations
     */
    public BaseException(String message, Throwable cause, String violationMessageKey, Object... arguments)
    {
        this(message, cause);
        Violation violation = new Violation();
        violation.setMessageKey(violationMessageKey);
        violation.setArguments(arguments);
        violations.add(violation);
    }


    /**
     * Constructor with:
     *
     * @param message    the exception message
     * @param violations set of javax.validation.ConstraintViolation to report
     */
    public BaseException(String message, Set<javax.validation.ConstraintViolation<?>> violations)
    {
        super(message);
        for (javax.validation.ConstraintViolation<?> violation : violations)
        {
            this.violations.add(new Violation(violation));
        }
    }

    /**
     * Constructor with:
     *
     * @param message   the exception message
     * @param violation a violation to report
     */
    public BaseException(String message, Violation violation)
    {
        super(message);
        violations.add(violation);
    }

    /**
     * Constructor with:
     *
     * @param message    the exception message
     * @param violations a list of violations to report
     */
    public BaseException(String message, List<Violation> violations)
    {
        super(message);
        this.violations.addAll(violations);
    }

    /**
     * Accesor for violations
     *
     * @return a list of violations
     */
    public List<Violation> getViolations()
    {
        return violations;
    }
}
