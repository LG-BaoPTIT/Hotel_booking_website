package com.hotel.service;

import java.util.List;
import java.util.Optional;

import com.hotel.dto.OrderDetailDTO;
import com.hotel.entities.OrderDetailEntity;

public interface OrderDetailService {

	void deleteAll();

	void deleteAll(List<OrderDetailEntity> entities);

	void deleteAllById(List<Long> ids);

	void delete(OrderDetailEntity entity);

	void deleteById(Long id);

	long count();

	Iterable<OrderDetailEntity> findAllById(Iterable<Long> ids);

	List<OrderDetailEntity> findAll();

	boolean existsById(Long id);

	Optional<OrderDetailEntity> findById(Long id);

	List<OrderDetailEntity> saveAll(List<OrderDetailEntity> entities);

	OrderDetailEntity save(OrderDetailEntity entity);

	public OrderDetailEntity toEntity(OrderDetailDTO dto);
	
	public OrderDetailDTO toDTO(OrderDetailEntity entity);
}
