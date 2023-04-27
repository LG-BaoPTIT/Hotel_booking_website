package com.hotel.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_Order")
public class OrderEntity extends BaseEntity {
	
	@Column(name = "totalPrice")
	private BigDecimal totalPrice;
	
	@Column(name = "payMethod")
	private String payMethod;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity user;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderDetailEntity> orderdetails = new ArrayList<>();
	
	
	
	public OrderEntity() {
		super();
	}
	
	
	
	public OrderEntity(BigDecimal totalPrice, String payMethod, UserEntity user, List<OrderDetailEntity> orderdetails) {
		super();
		this.totalPrice = totalPrice;
		this.payMethod = payMethod;
		this.user = user;
		this.orderdetails = orderdetails;
	}



	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public List<OrderDetailEntity> getOrderdetails() {
		return orderdetails;
	}
	public void setOrderdetails(List<OrderDetailEntity> orderdetails) {
		this.orderdetails = orderdetails;
	}
	
	
}
