package com.hotel.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.*;
import com.hotel.entities.UserEntity;
import com.hotel.service.UserService;

@RestController
@CrossOrigin
public class UserAPI {
	
	@Autowired
	private UserService userService;

	@GetMapping(value="/api/users")
	public List<UserDTO> getAllUser(){
		List<UserEntity> userEntities = userService.findAll();
		List<UserDTO> result = new ArrayList<>();
		for(UserEntity entity : userEntities) {
			result.add(userService.toDTO(entity));
		}
		return result;
	}
	
	@PostMapping(value = "/api/users",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> addUser(@RequestBody UserDTO model){
		try {
			UserEntity user = new UserEntity();
			user = userService.save(userService.toEntity(model));
			
			return ResponseEntity.ok(user);
		}catch(RuntimeException ex){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@DeleteMapping(value="/api/users/delete/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteById(id);
	}
	
	@PutMapping(value="/api/users/update")
	@ResponseBody
	public ResponseEntity<UserEntity> updateUser(@RequestBody UserDTO model) {
		try {
			UserEntity result =userService.save(userService.toEntity(model));
			return ResponseEntity.ok(result);
		}catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}
	
	
	

}