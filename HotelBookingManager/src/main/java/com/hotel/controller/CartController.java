package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
@RequestMapping("")
public class CartController {
	@GetMapping("/cart")
	public String cartPage(HttpServletResponse respon) {
		return "cart";
	}
}
