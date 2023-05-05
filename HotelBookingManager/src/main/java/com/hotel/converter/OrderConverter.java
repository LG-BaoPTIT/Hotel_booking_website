package com.hotel.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.dto.OrderDTO;
import com.hotel.dto.RoomDTO;
import com.hotel.dto.UserDTO;
import com.hotel.entities.OrderEntity;
import com.hotel.entities.RoomEntity;
import com.hotel.entities.UserEntity;
import com.hotel.service.impl.RoomServiceImpl;
import com.hotel.service.impl.UserServiceImpl;

@Component
public class OrderConverter {
	
	@Autowired
	private UserServiceImpl userServiceImpl; 
	
	@Autowired
	private RoomServiceImpl roomServiceImpl;
	
	
	public OrderEntity toEntity(OrderDTO dto) {
		OrderEntity entity = new OrderEntity();
		entity.setQuantity(dto.getQuantity());
		entity.setDatein(dto.getDatein());
		entity.setDateout(dto.getDateout());
		entity.setTotalPrice(dto.getTotalPrice());
		return entity;
	}
	
	public OrderDTO toDTO(OrderEntity entity) {
		OrderDTO dto = new OrderDTO();
		dto.setId(entity.getId());
		dto.setQuantity(entity.getQuantity());
		dto.setDatein(entity.getDatein());
		dto.setDateout(entity.getDateout());
		dto.setTotalPrice(entity.getTotalPrice());
		UserEntity userEntity = entity.getUser();
		UserDTO userDTO = userServiceImpl.toDTO(userEntity);
		RoomEntity roomEntity = entity.getRoom();
		RoomDTO roomDTO = roomServiceImpl.toDTO(roomEntity);
		dto.setUser(userDTO);
		dto.setRoom(roomDTO);
		return dto;
	}
	
	public OrderEntity toEntity(OrderDTO dto,OrderEntity entity) {
		entity.setQuantity(dto.getQuantity());
		entity.setDatein(dto.getDatein());
		entity.setDateout(dto.getDateout());
		entity.setTotalPrice(dto.getTotalPrice());
		return entity;
	}
	
}
