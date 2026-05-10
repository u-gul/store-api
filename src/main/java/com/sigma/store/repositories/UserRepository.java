package com.sigma.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigma.store.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
