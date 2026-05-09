package com.sigma.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sigma.store.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
