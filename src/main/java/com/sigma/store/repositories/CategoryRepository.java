package com.sigma.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sigma.store.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}