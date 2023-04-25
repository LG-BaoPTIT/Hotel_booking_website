package com.business.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity extends BaseEntity {
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	
    @OneToOne
    @JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItemEntity> cartItems = new ArrayList<>();
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<CartItemEntity> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemEntity> cartItems) {
		this.cartItems = cartItems;
	}
	
	
}
