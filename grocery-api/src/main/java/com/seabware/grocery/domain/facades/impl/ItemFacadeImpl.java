package com.seabware.grocery.domain.facades.impl;


import com.seabware.framework.domain.facade.AbstractBaseFacade;
import com.seabware.grocery.domain.dto.ItemDto;
import com.seabware.grocery.domain.model.Item;
import com.seabware.grocery.domain.services.atomic.ItemService;
import org.springframework.stereotype.Component;

@Component
public class ItemFacadeImpl extends AbstractBaseFacade<ItemService, ItemDto, Item>
{

}
