package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@CrossOrigin
@Controller
@RequestMapping("")
public class LogOutController {
	
	@GetMapping("/logout")
	public String logout(HttpServletResponse respon,HttpSession session) {
//		session.removeAttribute("username");
//		session.removeAttribute("id");
//		session.removeAttribute("role");
		Cookie usernameCookie = new Cookie("username", null);
	    Cookie idCookie = new Cookie("id", null);
	    Cookie nameCookie = new Cookie("name", null);
	    Cookie roleCookie = new Cookie("role", null);
	    usernameCookie.setMaxAge(0);
	    idCookie.setMaxAge(0);
	    nameCookie.setMaxAge(0);
		respon.addCookie(usernameCookie);
		respon.addCookie(idCookie);
		respon.addCookie(nameCookie);
		respon.addCookie(roleCookie);
		return "home";
	}
}
