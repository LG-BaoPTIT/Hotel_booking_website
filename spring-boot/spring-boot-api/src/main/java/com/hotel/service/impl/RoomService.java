package com.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.converter.RoomConverter;
import com.hotel.dto.RoomDTO;
import com.hotel.entity.RoomEntity;
import com.hotel.repository.RoomRepository;
import com.hotel.service.IRoomService;

@Service
public class RoomService implements IRoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private RoomConverter roomConverter;

	@Override
	public RoomDTO save(RoomDTO roomDTO) {
		RoomEntity roomEntity = new RoomEntity();
		if(roomDTO.getId() != null) {
			RoomEntity existingRoom = roomRepository.findOne(roomDTO.getId());
			roomEntity = roomRepository.save(roomConverter.toEntity(roomDTO, existingRoom));
		}
		else {
			roomEntity = roomRepository.save(roomConverter.toEntity(roomDTO));
		}
		return roomConverter.toDTO(roomEntity);
	}

	@Override
	public void delete(long id) {
		roomRepository.delete(id);
		
	}

	@Override
	public List<RoomDTO> getAllRoom() {
		List<RoomEntity> roomEntities = roomRepository.findAll();
		List<RoomDTO> roomDTOs = new ArrayList<>();
		for(RoomEntity roomEntity : roomEntities) {
			roomDTOs.add(roomConverter.toDTO(roomEntity));
		}
		return roomDTOs;
	}

}
