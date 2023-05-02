package com.hotel.service;

import java.util.List;
import java.util.Optional;

import com.hotel.dto.OrderDTO;
import com.hotel.entities.OrderEntity;




public interface OrderService {

	void deleteAll();

	void deleteAll(List<OrderEntity> entities);

	void deleteAllById(List<Long> ids);

	void delete(OrderEntity entity);

	void deleteById(Long id);

	long count();

	List<OrderEntity> findAllById(List<Long> ids);

	List<OrderEntity> findAll();

	boolean existsById(Long id);

	Optional<OrderEntity> findById(Long id);

	List<OrderEntity> saveAll(List<OrderEntity> entities);

	OrderEntity save(OrderEntity entity);
	
	public OrderEntity toEntity(OrderDTO dto);
	
	public OrderDTO toDTO(OrderEntity entity);
	
	
}
