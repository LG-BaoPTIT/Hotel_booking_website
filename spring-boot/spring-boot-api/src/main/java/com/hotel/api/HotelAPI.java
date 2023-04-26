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

import com.hotel.dto.HotelDTO;
import com.hotel.service.impl.HotelService;

@CrossOrigin
@RestController
public class HotelAPI {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping(value = "/api/hotel")
	public ResponseEntity<HotelDTO> addHotel (@RequestBody HotelDTO model) {
		try {
			HotelDTO hotelDTO = hotelService.save(model);
			return ResponseEntity.ok(hotelDTO);
			
		} catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }
	@PutMapping(value = "/api/hotel/{id}")
	public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO model, @PathVariable("id") long id) {
		try {	
			model.setId(id);
			return ResponseEntity.ok(hotelService.save(model));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@DeleteMapping(value = "/api/hotel/{id}")
	public void deleteHotel(@PathVariable("id") long id) {
		hotelService.delete(id);
	}
	
	@GetMapping(value = "/api/hotel")
	public List<HotelDTO> getAllHotel() {
		return hotelService.getAllHotel();
	}
}
