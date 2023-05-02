package com.hotel.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hotel.entities.OrderDetailEntity;

public interface OrderDetailRepository extends CrudRepository<OrderDetailEntity, Long>{

}
