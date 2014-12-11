package com.seabware.grocery.domain.dao.repositories;

import com.seabware.grocery.domain.model.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long>
{

	public List<Item> findByName(@Param("name") String name);

}
