package com.business.service;

import com.business.dto.UserDTO;

public interface IUserService {
		UserDTO save(UserDTO userDTO);
		UserDTO login(String userName, String password);
}
