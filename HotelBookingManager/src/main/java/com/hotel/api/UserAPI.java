package com.hotel.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import com.hotel.encrypt.AES;
import com.hotel.entities.UserEntity;
import com.hotel.service.UserService;

@RestController
@CrossOrigin
@Controller
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
	
	@PostMapping(value = "/registeruser",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUser(@RequestBody UserDTO model){
		String username = model.getUsername();
		String pass  = model.getPassword();
		model.setPassword(AES.encrypt(pass, "Aa123!@"));
		
		System.out.print(username);
		if(userService.existsByUsername(username)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false,"Tài khoản đã tồn tại",null));
		}
		try {
			
			UserEntity user = new UserEntity();
			user = userService.save(userService.toEntity(model));
			
			return ResponseEntity.ok(user);
		}catch(RuntimeException ex){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@DeleteMapping(value="/api/users/delete")
	public void deleteUser(@RequestBody UserDTO user) {
		userService.deleteById(user.getId());
	}
	
	@PutMapping(value="/api/users/update")
	@ResponseBody
	public ResponseEntity<UserEntity> updateUser(@RequestBody UserDTO model) {
		try {
			String passw = model.getPassword();
			model.setPassword(AES.encrypt(passw, "Aa123!@"));
			Systr
			UserEntity result =userService.save(userService.toEntity(model));
			return ResponseEntity.ok(result);
		}catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}
	
	
	

}
