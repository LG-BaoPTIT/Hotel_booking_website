package com.business.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "order_address")
	private String oderAddress;
	
	@Column(name = "order_tel")
	private String oderTel;
	
	public String getOderAddress() {
		return oderAddress;
	}

	public void setOderAddress(String oderAddress) {
		this.oderAddress = oderAddress;
	}

	public String getOderTel() {
		return oderTel;
	}

	public void setOderTel(String oderTel) {
		this.oderTel = oderTel;
	}

	@Column(name = "total_price")
	private BigDecimal totalPrice;
	
	@Column(name = "Status")
	private String status;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItemEntity> orderitems = new ArrayList<>();
	
    @OneToOne
    @JoinColumn(name = "user_id")
	private UserEntity user;
	

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderItemEntity> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<OrderItemEntity> orderitems) {
		this.orderitems = orderitems;
	}
	
	public UserEntity getUser() {
		return user;
	}
	
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
