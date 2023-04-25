package com.business.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "pass_word")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "role")
	private Boolean role;
	
	@ManyToMany
	@JoinTable(name = "user_comment",
	joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id"))
	private List<ProductEntity> comments = new ArrayList<>();
	
	@OneToOne(mappedBy = "user")
	private CartEntity cart;
	
	@OneToOne(mappedBy = "user")
	private OrderEntity order;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

	public List<ProductEntity> getComments() {
		return comments;
	}

	public void setComments(List<ProductEntity> comments) {
		this.comments = comments;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	
}
