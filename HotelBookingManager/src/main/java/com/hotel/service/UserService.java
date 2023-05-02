package com.hotel.service;

import java.util.List;
import java.util.Optional;

import com.hotel.dto.UserDTO;
import com.hotel.entities.UserEntity;


public interface UserService {

	void deleteAll();

	void deleteAll(List<UserEntity> entities);

	void deleteAllById(List<Long> ids);

	void delete(UserEntity entity);

	void deleteById(Long id);

	long count();

	List<UserEntity> findAllById(List<Long> ids);

	List<UserEntity> findAll();

	boolean existsById(Long id);

	Optional<UserEntity> findById(Long id);

	List<UserEntity> saveAll(List<UserEntity> entities);

	UserEntity save(UserEntity entity);
	
	Optional<UserEntity> findByUsername(String username);

	
	public boolean checkLogin(String username, String password);
	
	UserEntity toEntity(UserDTO dto);
	
	UserDTO toDTO(UserEntity entity);

	
}
