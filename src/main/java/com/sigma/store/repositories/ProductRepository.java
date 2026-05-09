package com.sigma.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigma.store.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}