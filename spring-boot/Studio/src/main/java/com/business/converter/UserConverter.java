package com.business.converter;

import org.springframework.stereotype.Component;

import com.business.dto.UserDTO;
import com.business.entity.UserEntity;

@Component
public class UserConverter {
	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setAddress(dto.getAddress());
		entity.setFullName(dto.getFullName());
		entity.setUsername(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setPhone(dto.getPhone());
		entity.setRole(false);
		return entity;
	}
	public UserDTO toDTO(UserEntity entity) {
		UserDTO dto = new UserDTO();
		dto.setAddress(entity.getAddress());
		dto.setFullName(entity.getFullName());
		dto.setUserName(entity.getUsername());
		dto.setPassword(entity.getPassword());
		dto.setPhone(entity.getPhone());
		dto.setRole(false);
		return dto;
	}
}
