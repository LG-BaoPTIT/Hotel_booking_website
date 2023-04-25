package com.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String name);
}
