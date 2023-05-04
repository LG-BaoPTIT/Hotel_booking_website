package com.hotel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends AbstractDTO{
	
	private String name;
	private String username;
	private String password;
	private String address;
	private String phone;
	private int role;
	@Override
	public String toString() {
		return "name=" + name + ";username=" + username + ";address=" + address
				+ ";phone=" + phone + ";role=" + role ;
	}
	
	
}