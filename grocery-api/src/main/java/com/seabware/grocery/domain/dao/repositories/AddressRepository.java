package com.seabware.grocery.domain.dao.repositories;

import com.seabware.grocery.domain.model.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long>
{
}
