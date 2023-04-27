package com.hotel.repositories;
import org.springframework.data.repository.CrudRepository;

import com.hotel.entities.HotelEntity;
public interface HotelRepository extends CrudRepository<HotelEntity, Long> {

}
