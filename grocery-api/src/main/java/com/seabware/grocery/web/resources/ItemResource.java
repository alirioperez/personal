package com.seabware.grocery.web.resources;

import com.seabware.framework.domain.web.AbstractBaseWebResource;
import com.seabware.grocery.domain.dto.ItemDto;
import com.seabware.grocery.domain.facades.ItemFacade;
import com.seabware.grocery.domain.facades.impl.ItemFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemResource extends AbstractBaseWebResource
{
    @Autowired
    private ItemFacadeImpl itemFacade;

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
//		List<User> list = itemService.findWithCriteria(criteria);
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
	 * Inserts the {@link com.seabware.grocery.domain.model.Item} resource.
	 */
	// ---------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(method = { RequestMethod.POST })
	@ResponseBody
	public ItemDto createItem(@RequestBody ItemDto itemDto)
	{
        Assert.isNull(itemDto.getId());

        return itemFacade.create(itemDto);
	}

	// ---------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------
	// PUT methods
	// ---------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------

	// ---------------------------------------------------------------------------------------------------------------------------
	/**
	 * Updates the {@link com.seabware.grocery.domain.model.Item} resource having the given key.
	 */
	// ---------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	@ResponseBody
	public ItemDto update(@PathVariable Long id, @RequestBody ItemDto itemDto)
	{
		return itemFacade.update(id, itemDto);
	}

    // ---------------------------------------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------------------------------------
    // DELETE methods
    // ---------------------------------------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------------------------------------

    // ---------------------------------------------------------------------------------------------------------------------------
    /**
     * Deletes the {@link com.seabware.grocery.domain.model.Item} resource having the given key.
     */
    // ---------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)
    {
        itemFacade.delete(id);
    }

}
