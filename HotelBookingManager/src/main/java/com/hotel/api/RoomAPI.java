package com.hotel.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.RoomDTO;
import com.hotel.entities.RoomEntity;
import com.hotel.service.RoomService;

@RestController
@CrossOrigin
@RequestMapping("/api/rooms")
public class RoomAPI {
	@Autowired
	RoomService roomService;
	
	@GetMapping(value = "")
	public List<RoomDTO> getAllRoom(){
		List<RoomDTO> result = new ArrayList<>();
		List<RoomEntity> entities = roomService.findAll();
		for(RoomEntity entity : entities) {
			result.add(roomService.toDTO(entity));
		}
		return result;
	}
	
	@PostMapping(value = "")
	public ResponseEntity<RoomEntity> addRoom(@RequestBody RoomDTO model){
		try {
			RoomEntity room = new RoomEntity();
			room = roomService.save(roomService.toEntity(model));
			return ResponseEntity.ok(room);
		}catch(RuntimeException ex) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return null;
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<RoomEntity> updateRoom(@RequestBody RoomDTO model){
		try {
			RoomEntity room = roomService.save(roomService.toEntity(model));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			
		}
	}
	@DeleteMapping(value = "/delete/{id}")
	public void deleteRoom(@PathVariable("id") Long id) {
		roomService.deleteById(id);
	}
	

}
