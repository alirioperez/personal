package com.seabware.grocery.domain.facades;

import com.seabware.grocery.domain.dto.ItemDto;

public interface ItemFacade
{
    ItemDto findOne(Long id);

    Iterable<ItemDto> findAll();

    ItemDto create(ItemDto item);

    ItemDto save(ItemDto item);

    void delete(Long id);
}
