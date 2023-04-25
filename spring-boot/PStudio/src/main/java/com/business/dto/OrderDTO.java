package com.business.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderDTO extends AbstracDTO {
	private Long id;
	private Long userId;
	private List<ProductDTO> product;
	private BigDecimal totalPrice;
	private String status;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<ProductDTO> getProduct() {
		return product;
	}
	public void setProduct(List<ProductDTO> product) {
		this.product = product;
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
	
	
}
