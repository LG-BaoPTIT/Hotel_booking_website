package com.hotel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends AbstractDTO{
	
	private Long id;
	private String name;
	private String username;
	private String password;
	private String address;
	private String phone;
	private int role;
	
	
}
