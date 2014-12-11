package com.seabware.grocery.domain.model.validators;

import com.seabware.grocery.domain.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ItemValidator implements Validator
{

	private static final Logger LOG = LoggerFactory.getLogger(ItemValidator.class);

	@Override
	public boolean supports(Class<?> clazz)
	{
		return ClassUtils.isAssignable(clazz, Item.class);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		Item p = (Item) target;
		LOG.debug("validating Paciente " + p);
		ValidationUtils.rejectIfEmpty(errors, "name", "field.name.required", "Field 'name' cannot be blank.");
	}

}
