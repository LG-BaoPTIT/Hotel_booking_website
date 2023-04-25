package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entity.RoomEntity;


public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

}
