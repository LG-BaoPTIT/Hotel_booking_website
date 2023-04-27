package com.hotel.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hotel.entities.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
	
}
