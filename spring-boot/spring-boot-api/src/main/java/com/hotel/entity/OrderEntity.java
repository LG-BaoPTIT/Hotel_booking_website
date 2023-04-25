package com.hotel.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Order")
public class OrderEntity extends BaseEntity {
	
	@Column(name = "totalPrice")
	private BigDecimal totalPrice;
	
	@Column(name = "payMethod")
	private String payMethod;
	
	@ManyToOne
	@JoinColumn(name = "auth_id", referencedColumnName = "id")
	private AuthEntity auth;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderDetailEntity> orderdetails = new ArrayList<>();
	
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
	public AuthEntity getAuth() {
		return auth;
	}
	public void setAuth(AuthEntity auth) {
		this.auth = auth;
	}
	public List<OrderDetailEntity> getOrderdetails() {
		return orderdetails;
	}
	public void setOrderdetails(List<OrderDetailEntity> orderdetails) {
		this.orderdetails = orderdetails;
	}
	
	
}
