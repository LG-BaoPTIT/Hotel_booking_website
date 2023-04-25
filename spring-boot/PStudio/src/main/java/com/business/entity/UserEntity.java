package com.business.entity;



@Entity

public class UserEntity extends BaseEntity {
	private Long id;
	private String name;
	private String passWord;
	private String email;
	private String address;
	private String phone;
	private boolean role;
	
}
