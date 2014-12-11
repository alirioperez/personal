package com.seabware.grocery.web.resources;

import com.seabware.framework.domain.web.AbstractWebResource;
import com.seabware.grocery.domain.dto.ItemDto;
import com.seabware.grocery.domain.facades.ItemFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/items")
public class ItemResource extends AbstractWebResource
{
    @Autowired
    private ItemFacade itemFacade;

	// ---------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------
	// GET methods
	// ---------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------

	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	public Iterable<ItemDto> findAll()
	{
		return itemFacade.findAll();
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	/**
	 * Retrieves the matching user resource using given key.
	 */
	// ---------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET})
	@ResponseBody
	public ItemDto findById(@PathVariable Long id)
	{
        return itemFacade.findOne(id);
	}

	// ---------------------------------------------------------------------------------------------------------------------------
	/**
	 * Retrieves the matching user resource using given user name.
	 */
	// ---------------------------------------------------------------------------------------------------------------------------
//	@RequestMapping(value = "/altkey/{username}", method = { RequestMethod.GET })
//	@ResponseBody
//	public PacienteDto findByAlternateKey(@PathVariable String username)
//	{
//		User userPojo = pacienteService.findByAlternateKey(username);
//
//		PacienteDto dto = new PacienteDto();
//		dto.copyValuesFrom(userPojo);
//
//		return dto;
//	}

	// --------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Retrieves the {@link User} resources matching the given search criteria
	 */
	// --------------------------------------------------------------------------------------------------------------------------------
//	@RequestMapping(method = { RequestMethod.GET })
//	@ResponseBody
//	public ListWrapperDto<User> search(@ModelAttribute PacienteCriteriaDto criteria, BindingResult bindingResult)
//	{
//		if (bindingResult.hasErrors())
//			throw new BindingErrorsException("Request's parameter binding errors", bindingResult);
//
//		List<User> list = pacienteService.findWithCriteria(criteria);
//
//		return new ListWrapperDto<User>(list);
//	}

	// ---------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------
	// POST methods
	// ---------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------

	// ---------------------------------------------------------------------------------------------------------------------------
	/**
	 * Inserts the {@link User} resource having the given key.
	 */
	// ---------------------------------------------------------------------------------------------------------------------------
//	@RequestMapping(method = { RequestMethod.POST })
//	@ResponseBody
//	public User save(@RequestBody User userDto)
//	{
////		User userPojo = new User();
////
////		userDto.copyValuesTo(userPojo);
//
//		User savedUser = pacienteService.save(userDto);
//
////		userDto.copyValuesFrom(savedUser);
//
//		return savedUser;
//	}

	// ---------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------
	// PUT methods
	// ---------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------

	// ---------------------------------------------------------------------------------------------------------------------------
	/**
	 * Updates the {@link User} resource having the given key.
	 */
	// ---------------------------------------------------------------------------------------------------------------------------
//	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
//	@ResponseBody
//	public PacienteDto save(@PathVariable Long id, @RequestBody PacienteDto personDto)
//	{
//		User userPojo = pacienteService.findById(id);
//		userPojo.setLastName("changed");
//
//		User savedUser = pacienteService.save(userPojo);
//
//		PacienteDto personDto2 = new PacienteDto();
//		personDto2.copyValuesFrom(savedUser);
//
//		return personDto2;
//	}

}