package com.sigma.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sigma.store.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}