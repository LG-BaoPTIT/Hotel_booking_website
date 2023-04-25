package com.hotel.api;

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
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.RoomDTO;
import com.hotel.service.impl.RoomService;

@CrossOrigin
@RestController
public class RoomAPI {
	@Autowired
	private RoomService roomService;
	
	@PostMapping(value = "/api/room")
	public ResponseEntity<RoomDTO> addRoom (@RequestBody RoomDTO model) {
		try {
			RoomDTO roomDTO = roomService.save(model);
			return ResponseEntity.ok(roomDTO);
			
		} catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }
	
	@PutMapping(value = "/api/room/{id}")
	public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomDTO model, @PathVariable("id") long id) {
		try {	
			model.setId(id);
			return ResponseEntity.ok(roomService.save(model));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@DeleteMapping(value = "/api/room/{id}")
	public void deleteRoom(@PathVariable("id") long id) {
		roomService.delete(id);
	}
	
	@GetMapping(value = "/api/room")
	public List<RoomDTO> getAllRoom() {
		return roomService.getAllRoom();
	}
}
