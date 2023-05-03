package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
@RequestMapping("")
public class LogOutController {
	
	@GetMapping("/logout")
	public String logout(HttpServletResponse respon) {
		
		Cookie usernameCookie = new Cookie("username", null);
	    Cookie idCookie = new Cookie("id", null);
	    usernameCookie.setMaxAge(0);
	    idCookie.setMaxAge(0);
		respon.addCookie(usernameCookie);
		respon.addCookie(idCookie);
		return "home";
	}
}
