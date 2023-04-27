package com.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.converter.HotelConverter;
import com.hotel.dto.HotelDTO;
import com.hotel.entity.HotelEntity;
import com.hotel.repository.HotelRepository;
import com.hotel.service.IHotelService;

@Service
public class HotelService implements IHotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private HotelConverter hotelConverter;

	@Override
	public HotelDTO save(HotelDTO hotelDTO) {
		HotelEntity hotelEntity = new HotelEntity();
		if(hotelDTO.getId() != null) {
			HotelEntity existingHotel = hotelRepository.findOne(hotelDTO.getId());
			hotelEntity = hotelRepository.save(hotelConverter.toEntity(hotelDTO, existingHotel));
		}
		else {
			hotelEntity = hotelRepository.save(hotelConverter.toEntity(hotelDTO));
		}
		return hotelConverter.toDTO(hotelEntity);
	}
	
	@Override
	public void delete(long id) {
		hotelRepository.delete(id);
	}

	@Override
	public List<HotelDTO> getAllHotel() {
		List<HotelEntity> hotelEntities = hotelRepository.findAll();
		List<HotelDTO> hotelDTOs = new ArrayList<>();
		for(HotelEntity hotelEntity : hotelEntities) {
			hotelDTOs.add(hotelConverter.toDTO(hotelEntity));
		}
		return hotelDTOs;
	}
}
