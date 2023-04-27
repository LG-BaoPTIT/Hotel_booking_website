//package com.hotel.converter;
//
//import org.springframework.stereotype.Component;
//
//import com.hotel.dto.UserDTO;
//import com.hotel.entities.UserEntity;
//
//@Component
//public class UserConverter {
//	
//	public UserEntity toEntity(UserDTO dto) {
//		UserEntity entity = new UserEntity();
//		entity.setName(dto.getName());
//		entity.setUsername(dto.getUsername());
//		entity.setPassword(dto.getPassword());
//		entity.setPhone(dto.getPhone());
//		entity.setRole(dto.getRole());
//		return entity;
//	}
//	
//	public UserDTO toDTO(UserEntity entity) {
//		UserDTO dto = new UserDTO();
//		dto.setName(entity.getName());
//		dto.setUsername(entity.getUsername());
//		dto.setPassword(entity.getPassword());
//		dto.setPhone(entity.getPhone());
//		dto.setRole(entity.getRole());
//		return dto;
//		
//	}
//	
//}
