package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.dto.UserDTO;
import com.hotel.entities.UserEntity;
import com.hotel.service.UserService;

@CrossOrigin
@Controller
@RequestMapping("/register")
public class registerController {
		
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public String register() {
		return "register";
	}
	
}
