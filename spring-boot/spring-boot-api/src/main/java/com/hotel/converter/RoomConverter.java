package com.hotel.converter;

import org.springframework.stereotype.Component;

import com.hotel.dto.RoomDTO;
import com.hotel.entity.RoomEntity;

@Component
public class RoomConverter {
	public RoomEntity toEntity(RoomDTO dto) {
		RoomEntity entity = new RoomEntity();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setImgLink(dto.getImgLink());
		entity.setRate(dto.getRate());
		entity.setPrice(dto.getPrice());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	public RoomDTO toDTO(RoomEntity entity) {
		RoomDTO dto = new RoomDTO();
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setImgLink(entity.getImgLink());
		dto.setRate(entity.getRate());
		dto.setPrice(entity.getPrice());
		dto.setStatus(entity.getStatus());
		return dto;
	}
	public RoomEntity toEntity(RoomDTO dto, RoomEntity entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setImgLink(dto.getImgLink());
		entity.setRate(dto.getRate());
		entity.setPrice(dto.getPrice());
		entity.setStatus(dto.getStatus());
		return entity;
	}
}
