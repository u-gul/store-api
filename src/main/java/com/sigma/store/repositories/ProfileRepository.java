package com.sigma.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sigma.store.entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}