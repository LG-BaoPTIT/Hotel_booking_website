package com.business.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.converter.UserConverter;
import com.business.dto.UserDTO;
import com.business.entity.UserEntity;
import com.business.repository.UserRepository;
import com.business.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		UserEntity existingUser = userRepository.findByUsername(userDTO.getUserName());
		if(existingUser != null) {
			throw new RuntimeException("Username đã được sử dụng");
		}
		String hashedPassWord = BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt());
		userDTO.setPassword(hashedPassWord);
		userEntity = userRepository.save(userConverter.toEntity(userDTO));
		return userConverter.toDTO(userEntity);
	}

	@Override
	public UserDTO login(String userName, String password) {
		UserEntity userEntity = userRepository.findByUsername(userName);
	    if(userEntity == null) {
	        throw new RuntimeException("Tên người dùng không tồn tại");
	    }
	    if(!BCrypt.checkpw(password, userEntity.getPassword())) {
	        throw new RuntimeException("Mật khẩu không chính xác");
	    }
	    return userConverter.toDTO(userEntity);
	}
	
	

	
}
