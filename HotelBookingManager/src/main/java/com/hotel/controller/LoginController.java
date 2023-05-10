package com.hotel.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.api.ApiResponse;
import com.hotel.dto.UserDTO;
import com.hotel.entities.UserEntity;
import com.hotel.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@CrossOrigin
@Controller
@RequestMapping("")
public class LoginController {
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping(value = "/checklogin", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> login(@RequestBody UserDTO loginRequest, 
			HttpSession session,ModelMap model, HttpServletResponse respon) {
	    String username = loginRequest.getUsername();
	    String password = loginRequest.getPassword();
	    
	    // xử lý login
	    if(userService.checkLogin(username, password)) { 
	    	Optional<UserEntity> entity = userService.findByUsername(username);
	    	UserEntity user = entity.get();
	        session.setAttribute("username", username);
	        session.setAttribute("id", user.getId());
	        session.setAttribute("role", user.getRole());
	        ApiResponse response = new ApiResponse(true, "Đăng nhập thành công",user.getName());
	        System.out.println("ok");
	        
	     // Lưu thông tin người dùng vào cookie
	        Cookie usernameCookie = new Cookie("username", username);
	        Cookie idCookie = new Cookie("id", String.valueOf(user.getId()));
	        Cookie nameCookie = new Cookie("name", String.valueOf(user.getName().replaceAll(" ", "-")));
	        Cookie roleCookie = new Cookie("role", String.valueOf( user.getRole()));
	        usernameCookie.setMaxAge(3600); // set thời gian sống của cookie (tính theo giây)
	        idCookie.setMaxAge(3600);
	        nameCookie.setMaxAge(3600);
	        roleCookie.setMaxAge(3600);
	        respon.addCookie(usernameCookie);
	        respon.addCookie(idCookie);
	        respon.addCookie(nameCookie);
	        respon.addCookie(roleCookie);
	        
	        return ResponseEntity.ok(response);
	    } else {
	        System.out.println("false");
	    	 ApiResponse response = new ApiResponse(false, "Đăng nhập thất bại",null);
	         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }
	}
	
	

}
