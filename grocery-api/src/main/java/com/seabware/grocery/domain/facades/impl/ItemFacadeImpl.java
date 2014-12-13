package com.seabware.grocery.domain.facades.impl;


import com.seabware.grocery.domain.dto.ItemDto;
import com.seabware.grocery.domain.facades.ItemFacade;
import com.seabware.grocery.domain.model.Item;
import com.seabware.grocery.domain.services.atomic.ItemService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemFacadeImpl implements ItemFacade
{
    @Autowired
    protected ItemService itemService;

    @Autowired
    protected MapperFacade mapper;

    public ItemDto findOne(Long id)
    {
        Item entity = itemService.findOne(id);

        ItemDto dto = mapper.map(entity, ItemDto.class);

        return dto;
    }

    public Iterable<ItemDto> findAll()
    {
        Iterable<Item> entities = itemService.findAll();

        List<ItemDto> dtos = new ArrayList<>();

        for (Item entity : entities)
        {
            ItemDto dto = mapper.map(entity, ItemDto.class);
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public ItemDto create(ItemDto itemDto)
    {
        Item itemToBeSaved = mapper.map(itemDto, Item.class);
        Item itemResult = itemService.save(itemToBeSaved);
        ItemDto itemDtoToReturn = mapper.map(itemResult, ItemDto.class);
        return itemDtoToReturn;
    }

    @Override
    public ItemDto save(ItemDto item)
    {
        return null;
    }

    @Override
    public void delete(Long id)
    {

    }
}
