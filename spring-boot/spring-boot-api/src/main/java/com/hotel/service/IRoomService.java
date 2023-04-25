package com.hotel.service;

import java.util.List;

import com.hotel.dto.RoomDTO;

public interface IRoomService {
	RoomDTO save(RoomDTO roomDTO);
	void delete(long id);
	List<RoomDTO> getAllRoom();
}
