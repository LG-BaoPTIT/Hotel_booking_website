package com.business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.business.dto.UserDTO;
import com.business.service.impl.UserService;

@CrossOrigin
@RestController 
public class UserAPI {
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/api/signup")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO model) {
		try {
			UserDTO userDTO = userService.save(model);
			return ResponseEntity.ok(userDTO);
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }

	@PostMapping(value = "/api/login")
	public ResponseEntity<String> login(@RequestBody UserDTO model) {
		try {
			userService.login(model.getUserName(), model.getPassword());
			return ResponseEntity.ok("Đăng nhập thành công");
		} catch(RuntimeException ex) {
			if(ex.getMessage().equals("Tên người dùng không tồn tại")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tên người dùng không tồn tại");
			}
			else if(ex.getMessage().equals("Mật khẩu không chính xác")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mật khẩu không chính xác");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("lỗi khác");
		}
	}
}
