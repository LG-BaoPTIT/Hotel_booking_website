package com.hotel.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hotel.entities.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
	OrderEntity findOneById(Long id);
	List<OrderEntity> findAll();
	List<OrderEntity> findByUserId(Long id);
	List<OrderEntity> findByRoomId(Long id);
}
