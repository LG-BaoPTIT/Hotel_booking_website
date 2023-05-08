package com.hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dto.RoomDTO;
import com.hotel.entities.RoomEntity;
import com.hotel.repositories.RoomRepository;
import com.hotel.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	RoomRepository repository;
	@Override
	public RoomEntity save(RoomEntity entity) {
		return repository.save(entity);
	}

	@Override
	public List<RoomEntity> saveAll(List<RoomEntity> entities) {
		return (List<RoomEntity>)repository.saveAll(entities);
	}

	@Override
	public Optional<RoomEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	@Override
	public List<RoomEntity> findAll() {
		return (List<RoomEntity>)repository.findAll();
	}

	@Override
	public List<RoomEntity> findAllById(List<Long> ids) {
		return (List<RoomEntity>)repository.findAllById(ids);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(RoomEntity entity) {
		repository.delete(entity);
	}

	@Override
	public void deleteAllById(List<Long> ids) {
		repository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends RoomEntity> entities) {
		repository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public RoomEntity toEntity(RoomDTO dto) {
		RoomEntity entity = new RoomEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setImgLink(dto.getImgLink());
		entity.setRate(dto.getRate());
		entity.setPrice(dto.getPrice());
		entity.setStatus(dto.getStatus());
		return entity;
	}

	@Override
	public RoomDTO toDTO(RoomEntity entity) {
		RoomDTO dto = new RoomDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setImgLink(entity.getImgLink());
		dto.setRate(entity.getRate());
		dto.setPrice(entity.getPrice());
		dto.setStatus(entity.getStatus());
		return dto;
	}


}
