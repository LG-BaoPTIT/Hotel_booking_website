package com.hotel.converter;

import org.springframework.stereotype.Component;

import com.hotel.dto.HotelDTO;
import com.hotel.entity.HotelEntity;

@Component
public class HotelConverter {
	public HotelEntity toEntity(HotelDTO dto) {
		HotelEntity entity = new HotelEntity();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setAddress(dto.getAddress());
		entity.setImgLink(dto.getImgLink());
		entity.setQuantityRoom(dto.getQuantityRoom());
		entity.setStatus(dto.getStatus());
		entity.setRating(dto.getRating());;
		return entity;
	}
	public HotelDTO toDTO(HotelEntity entity) {
		HotelDTO dto = new HotelDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setAddress(entity.getAddress());
		dto.setImgLink(entity.getImgLink());
		dto.setQuantityRoom(entity.getQuantityRoom());
		dto.setStatus(entity.getStatus());
		dto.setRating(entity.getRating());
		return dto;
	}
	public HotelEntity toEntity(HotelDTO dto, HotelEntity entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setAddress(dto.getAddress());
		entity.setImgLink(dto.getImgLink());
		entity.setQuantityRoom(dto.getQuantityRoom());
		entity.setStatus(dto.getStatus());
		entity.setRating(dto.getRating());;
		return entity;
	}
}
