package com.hotel.service;

import java.util.List;
import java.util.Optional;
import com.hotel.dto.HotelDTO;
import com.hotel.entities.HotelEntity;

public interface HotelService {

	void deleteAll();

	void deleteAll(List<HotelEntity> entities);

	void deleteAllById(List<Long> ids);

	void delete(HotelEntity entity);

	void deleteById(Long id);

	long count();

	List<HotelEntity> findAllById(List<Long> ids);

	List<HotelEntity> findAll();

	boolean existsById(Long id);

	Optional<HotelEntity> findById(Long id);

	List<HotelEntity> saveAll(List<HotelEntity> entities);

	HotelEntity save(HotelEntity entity);
	
	HotelEntity toEntity(HotelDTO dto);
	
	HotelDTO toDTO(HotelEntity entity);



}
