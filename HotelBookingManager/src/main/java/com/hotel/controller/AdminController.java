package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@CrossOrigin
@Controller
@RequestMapping("")
public class AdminController {
	
	@GetMapping("/admin")
	public String adminPage(HttpServletResponse respon,HttpSession session) {
	
		if(session.getAttribute("role").equals(0)) {
			return "admin";
		}
		else {
			return "home";
		}
	}
	
	@GetMapping("/adminOderPage")
	public String adminOderPage(HttpServletResponse respon,HttpSession session) {
		if(session.getAttribute("role").equals(0)) {
			return "adminOderPage";
		}
		else {
			return "home";
		}
		
	}
	
	@GetMapping("/account")
	public String accountPage(HttpSession session) {
		if(session.getAttribute("role").equals(0)) {
			return "account";
		}
		else {
			return "home";
		}
		
	}
	
	
}
