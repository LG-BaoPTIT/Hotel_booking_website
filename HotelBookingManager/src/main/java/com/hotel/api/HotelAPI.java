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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.HotelDTO;
import com.hotel.dto.UserDTO;
import com.hotel.entities.HotelEntity;
import com.hotel.entities.UserEntity;
import com.hotel.service.HotelService;

@RestController("")
@CrossOrigin
@RequestMapping("/api/hotels")
public class HotelAPI {
	
	@Autowired
	private HotelService hotelService;
	
	@GetMapping(value="")
	public List<HotelDTO> getAllHotel(){
		List<HotelEntity> hotelEntities = hotelService.findAll();
		List<HotelDTO> result = new ArrayList<>();
		for(HotelEntity entity : hotelEntities) {
			result.add(hotelService.toDTO(entity));
		}
		return result;
	}
	
	@PostMapping(value = "")
	public ResponseEntity<HotelEntity> addHotel(@RequestBody HotelDTO model){
		try {
			HotelEntity hotel = new HotelEntity();
			hotel = hotelService.save(hotelService.toEntity(model));
			
			return ResponseEntity.ok(hotel);
		}catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}		
	}	
	
	@PutMapping(value="/update")
	@ResponseBody
	public ResponseEntity<HotelEntity> updateUser(@RequestBody HotelDTO model) {
		try {
			HotelEntity result =hotelService.save(hotelService.toEntity(model));
			return ResponseEntity.ok(result);
		}catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}
	@DeleteMapping(value = "/delete/{id}")
	public void deleteHotel(@PathVariable("id") Long id) {
		hotelService.deleteById(id);
	}
	
	
	
}
