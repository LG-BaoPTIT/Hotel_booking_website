package com.hotel.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hotel.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	Optional<UserEntity> findByUsername(String username);

	
}
