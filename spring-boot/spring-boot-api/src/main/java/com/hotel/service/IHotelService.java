package com.hotel.service;

import java.util.List;

import com.hotel.dto.HotelDTO;

public interface IHotelService {
	HotelDTO save(HotelDTO hotelDTO);
	void delete(long id);
	List<HotelDTO> getAllHotel();
}
