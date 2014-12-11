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
    protected ItemService pacienteService;

    @Autowired
    protected MapperFacade mapper;

    public ItemDto findOne(Long id)
    {
        Item entity = pacienteService.findOne(id);

        ItemDto dto = mapper.map(entity, ItemDto.class);

        return dto;
    }

    public Iterable<ItemDto> findAll()
    {
        Iterable<Item> entities = pacienteService.findAll();

        List<ItemDto> dtos = new ArrayList<>();

        for (Item entity : entities)
        {
            ItemDto dto = mapper.map(entity, ItemDto.class);
            dtos.add(dto);
        }

        return dtos;
    }
}
