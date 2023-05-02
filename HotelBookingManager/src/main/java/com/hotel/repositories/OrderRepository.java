package com.hotel.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hotel.entities.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

}
