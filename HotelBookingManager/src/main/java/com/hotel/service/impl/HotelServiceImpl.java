package com.hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dto.HotelDTO;
import com.hotel.entities.HotelEntity;
import com.hotel.repositories.HotelRepository;
import com.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
	HotelRepository hotelRepository;
	@Override
	public HotelEntity save(HotelEntity entity) {
		return hotelRepository.save(entity);
	}

	@Override
	public List<HotelEntity> saveAll(List<HotelEntity> entities) {
		return (List<HotelEntity>)hotelRepository.saveAll(entities);
	}

	@Override
	public Optional<HotelEntity> findById(Long id) {
		return hotelRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return hotelRepository.existsById(id);
	}

	@Override
	public List<HotelEntity> findAll() {
		return (List<HotelEntity>)hotelRepository.findAll();
	}

	@Override
	public List<HotelEntity> findAllById(List<Long> ids) {
		return (List<HotelEntity>)hotelRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return hotelRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		hotelRepository.deleteById(id);
	}

	@Override
	public void delete(HotelEntity entity) {
		hotelRepository.delete(entity);
	}

	@Override
	public void deleteAllById(List<Long> ids) {
		hotelRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<HotelEntity> entities) {
		hotelRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		hotelRepository.deleteAll();
	}

	@Override
	public HotelEntity toEntity(HotelDTO dto) {
		HotelEntity entity = new HotelEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setAddress(dto.getAddress());
		entity.setImgLink(dto.getImgLink());
		entity.setQuantityRoom(dto.getQuantityRoom());
		entity.setStatus(dto.getStatus());
		entity.setRating(dto.getRating());;
		return entity;
	}

	@Override
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
	
	
	
	
}
