package com.seabware.grocery.domain.services.atomic;


import com.seabware.framework.domain.services.AbstractService;
import com.seabware.grocery.domain.dao.repositories.ItemRepository;
import com.seabware.grocery.domain.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemService extends AbstractService<ItemRepository, Item>
{
	@Autowired
	public ItemService(ItemRepository repository)
	{
		super(repository);
	}
}
