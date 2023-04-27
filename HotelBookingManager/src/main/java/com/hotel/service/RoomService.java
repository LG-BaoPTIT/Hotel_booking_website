package com.hotel.service;

import java.util.List;
import java.util.Optional;

import com.hotel.dto.RoomDTO;
import com.hotel.entities.RoomEntity;


public interface RoomService {

	void deleteAll();

	void deleteAll(Iterable<? extends RoomEntity> entities);

	void deleteAllById(List<Long> ids);

	void delete(RoomEntity entity);

	void deleteById(Long id);

	long count();

	List<RoomEntity> findAllById(List<Long> ids);

	List<RoomEntity> findAll();

	boolean existsById(Long id);

	Optional<RoomEntity> findById(Long id);

	List<RoomEntity> saveAll(List<RoomEntity> entities);

	RoomEntity save(RoomEntity entity);
	
	public RoomEntity toEntity(RoomDTO dto);
	
	public RoomDTO toDTO(RoomEntity entity);

}
