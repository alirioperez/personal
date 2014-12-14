package com.seabware.framework.domain.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seabware.framework.domain.exceptions.BaseException;
import com.seabware.framework.domain.exceptions.DataNotFoundException;
import com.seabware.framework.domain.exceptions.Violation;
import com.seabware.framework.domain.exceptions.ViolationList;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// --------------------------------------------------------------------------------------------------------------------------------
public abstract class AbstractWebResource
{
    private static Logger log = LoggerFactory.getLogger(AbstractWebResource.class);

    protected static final String REQUESTBODY_MALFORMED_EXCEPTION = "requestBodyMalFormedException";

    // --------------------------------------------------------------------------------------------------------------------------------
    public AbstractWebResource()
    {
    }

    // --------------------------------------------------------------------------------------------------------------------------------
    protected ViolationList generateSingleViolation(Exception exception)
    {
        Violation violation = new Violation();

        if (!StringUtils.isEmpty(exception.getMessage()))
            violation.setMessageKey(exception.getMessage());
        else
            violation.setMessageKey(exception.getClass().getSimpleName());

        violation.setMessage(violation.getMessageKey());
        //violation.setMessage(resourceBundleService.getMessage(violation.getMessageKey(), violation.getMessageKey()));

        return new ViolationList(Arrays.asList(new Violation[]{violation}));
    }

    // --------------------------------------------------------------------------------------------------------------------------------
    protected ViolationList generateViolationList(BaseException exception)
    {
        List<Violation> violations = exception.getViolations();

        if (exception.getViolations().isEmpty())
            return generateSingleViolation(exception);

        for (Violation violation : violations)
        {
            if (StringUtils.isEmpty(violation.getMessage()))
            {
                //violation.setMessage(resourceBundleService.getMessage(violation.getMessageKey(), violation.getMessageKey(), violation.getArguments()));
                violation.setMessage(violation.getMessageKey());
            }

        }
        return new ViolationList(violations);
    }

    // --------------------------------------------------------------------------------------------------------------------------------
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler()
    public void defaultExceptionHandler(Exception exception)
    {
        log.error("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.INTERNAL_SERVER_ERROR", exception);
    }


    //	// ----------------------------------------------------------------------------------------
//	@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
//	@ExceptionHandler(NewVersionAvailableException.class)
//	@ResponseBody
//	public ViolationList newVersionAvailableExceptionHandler(NewVersionAvailableException exception)
//	{
//		log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.MOVED_PERMANENTLY",
//				exception);
//		String messageKey = "newVersionAvailable";
//		Violation violation = new Violation();
//		violation.setEntity(exception.getModelClass().getName());
//		violation.setVersion(exception.getVersion());
//		violation.setMessageKey(messageKey);
//		violation.setMessage(resourceBundleService.getMessage(messageKey));
//
//		List<Violation> violations = new ArrayList<Violation>();
//		violations.add(violation);
//		return new ViolationList(violations);
//	}

//	// ----------------------------------------------------------------------------------------
//	@ResponseStatus(HttpStatus.FORBIDDEN)
//	@ExceptionHandler(IllegalStateException.class)
//	@ResponseBody
//	public ViolationList illegalStateExceptionHandler(IllegalStateException exception)
//	{
//		log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.FORBIDDEN", exception);
//		String messageKey = "illegalStateException";
//		Violation violation = new Violation();
//		violation.setEntity(exception.getModelClass().getName());
//		violation.setPrimaryKey(exception.getPrimaryKey());
//		violation.setProperty(exception.getProperty());
//		violation.setExtendedInfo(exception.getState());
//		violation.setMessageKey(messageKey);
//		violation.setMessage(resourceBundleService.getMessage(messageKey));
//
//		List<Violation> violations = new ArrayList<Violation>();
//		violations.add(violation);
//		return new ViolationList(violations);
//	}

//	// --------------------------------------------------------------------------------------------------------------------------------
//	@ResponseStatus(HttpStatus.NOT_MODIFIED)
//	@ExceptionHandler(NotModifiedException.class)
//	@ResponseBody
//	public ViolationList notModifiedExceptionHandler(NotModifiedException exception)
//	{
//		log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.NOT_MODIFIED", exception);
//
//		return generateViolationList(exception);
//	}

//	// --------------------------------------------------------------------------------------------------------------------------------
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(IllegalArgumentException.class)
//	@ResponseBody
//	public ViolationList illegalArgumentExceptionHandler(IllegalArgumentException exception)
//	{
//		log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.BAD_REQUEST", exception);
//
//		Violation violation = new Violation();
//		violation.setMessage(exception.getMessage());
//		return new ViolationList(Arrays.asList(new Violation[]
//			{ violation }));
//
//	}

//	// --------------------------------------------------------------------------------------------------------------------------------
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(InvalidRequestException.class)
//	@ResponseBody
//	public ViolationList invalidRequestExceptionHandler(InvalidRequestException exception)
//	{
//		log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.BAD_REQUEST", exception);
//
//		return generateViolationList(exception);
//	}

    // --------------------------------------------------------------------------------------------------------------------------------

    /**
     * Encompasses both {JsonMappingException} and {JsonParseException} but {JsonParseException} is hidden by {@link org.springframework.http.converter.HttpMessageNotReadableException}
     */
    // --------------------------------------------------------------------------------------------------------------------------------
    @ExceptionHandler(JsonProcessingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ViolationList jsonProcessingExceptionHandler(JsonProcessingException exception)
    {
        log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.BAD_REQUEST", exception);

        ViolationList generateSingleViolation = generateSingleViolation(new BaseException(REQUESTBODY_MALFORMED_EXCEPTION));

        return generateSingleViolation;
    }

    // --------------------------------------------------------------------------------------------------------------------------------
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ViolationList httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException exception)
    {
        log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.BAD_REQUEST", exception);

        ViolationList generateSingleViolation = generateSingleViolation(new BaseException(REQUESTBODY_MALFORMED_EXCEPTION));

        return generateSingleViolation;
    }

//	// --------------------------------------------------------------------------------------------------------------------------------
//	@ResponseStatus(HttpStatus.FORBIDDEN)
//	@ExceptionHandler(AccessRefusedException.class)
//	@ResponseBody
//	public ViolationList accessRefusedExceptionHandler(AccessRefusedException exception)
//	{
//		log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.FORBIDDEN", exception);
//		return generateViolationList(exception);
//	}

    // --------------------------------------------------------------------------------------------------------------------------------
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ViolationList accessDeniedExceptionHandler(AccessDeniedException exception)
    {
        log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.FORBIDDEN", exception);

        return generateSingleViolation(exception);
    }

    // --------------------------------------------------------------------------------------------------------------------------------

    /**
     * Encountered cases: - a DELETE operation is requested but no key is supplied
     */
    // ----------------------------------------------------------------------------------------
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ViolationList httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException exception)
    {
        log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.BAD_REQUEST", exception);

        return generateSingleViolation(exception);
    }

    // --------------------------------------------------------------------------------------------------------------------------------
    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ViolationList objectNotFoundExceptionHandler(ObjectNotFoundException exception)
    {
        log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.NOT_FOUND", exception);

        ViolationList generateSingleViolation = generateSingleViolation(exception);
        generateSingleViolation.getViolations().get(0).setEntity(exception.getEntityName());

        return generateSingleViolation;

    }

    // --------------------------------------------------------------------------------------------------------------------------------
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ViolationList dataNotFoundExceptionHandler(DataNotFoundException exception)
    {
        log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.NOT_FOUND", exception);

        return generateViolationList(exception);
    }

    // --------------------------------------------------------------------------------------------------------------------------------
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ViolationList javaxConstraintViolationExceptionHandler(ConstraintViolationException exception)
    {
        log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.BAD_REQUEST", exception);

        List<Violation> violations = new ArrayList<Violation>();

        for (ConstraintViolation<?> constraintViolation : exception.getConstraintViolations())
            violations.add(new Violation(constraintViolation));

        return new ViolationList(violations);
    }

//	// --------------------------------------------------------------------------------------------------------------------------------
//	/**
//	 * When a Hibernate ConstraintViolationException is raised WITHIN the transaction as opposed to on commit carried out by the advice,
//	 * the exception is not wrapped in a spring DataIntegrityViolationException.
//	 * It occurs when a partial flush is needed during the transaction as for the access rights check after save in AbstractServiceImpl.save()
//	 * @param exception
//	 * @return
//	 */
//	// --------------------------------------------------------------------------------------------------------------------------------
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
//	@ResponseBody
//	public ViolationList hibernateConstraintViolationExceptionHandler(org.hibernate.exception.ConstraintViolationException exception)
//	{
//		log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.BAD_REQUEST", exception);
//
//		Violation violation = dbmsExceptionProcessor.extractConstraintViolation(exception, resourceBundleService);
//		return new ViolationList(Arrays.asList(new Violation[]
//			{ violation }));
//	}
//
//	// --------------------------------------------------------------------------------------------------------------------------------
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(DataIntegrityViolationException.class)
//	@ResponseBody
//	public ViolationList dataIntegrityViolationExceptionHandler(DataIntegrityViolationException exception)
//	{
//		log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.BAD_REQUEST", exception);
//
//		Violation violation = dbmsExceptionProcessor.extractConstraintViolation(exception, resourceBundleService);
//		return new ViolationList(Arrays.asList(new Violation[]
//			{ violation }));
//	}

//	// --------------------------------------------------------------------------------------------------------------------------------
//	/**
//	 * For instance when filtering or sorting on an unknown field
//	 */
//	// ----------------------------------------------------------------------------------------
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(QueryException.class)
//	@ResponseBody
//	public ViolationList queryExceptionHandler(QueryException exception)
//	{
//		log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.BAD_REQUEST", exception);
//
//		Violation violation = dbmsExceptionProcessor.extractConstraintViolation(exception, resourceBundleService);
//		return new ViolationList(Arrays.asList(new Violation[]
//			{ violation }));
//	}

//	// --------------------------------------------------------------------------------------------------------------------------------
//	/**
//	 * For instance when inserting a non existing foreign key
//	 */
//	// ----------------------------------------------------------------------------------------
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(TransactionSystemException.class)
//	@ResponseBody
//	public ViolationList transactionSystemExceptionHandler(Exception exception)
//	{
//		log.debug("Unexpected exception: " + exception.getClass().getName() + " reported as HttpStatus.BAD_REQUEST", exception);
//
//		Violation violation = dbmsExceptionProcessor.extractConstraintViolation(exception, resourceBundleService);
//		return new ViolationList(Arrays.asList(new Violation[]
//			{ violation }));
//	}
}