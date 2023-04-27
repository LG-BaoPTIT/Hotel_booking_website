package com.hotel.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hotel.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
