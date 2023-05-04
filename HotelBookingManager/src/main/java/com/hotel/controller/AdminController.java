package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
@RequestMapping("")
public class AdminController {
	
	@GetMapping("/admin")
	public String adminPage(HttpServletResponse respon) {
		
		return "admin";
	}
	
}
