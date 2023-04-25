package com.business.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productDetail")
public class ProductDetailEntity extends BaseEntity {
	
	@Column(name = "memory")
	private String memory;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "price_brick")
	private BigDecimal priceBrick;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity product;
	
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPriceBrick() {
		return priceBrick;
	}
	public void setPriceBrick(BigDecimal price_brick) {
		this.priceBrick = price_brick;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	
}
