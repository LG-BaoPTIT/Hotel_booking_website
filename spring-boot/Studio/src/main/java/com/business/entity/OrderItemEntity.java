package com.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderItem")
public class OrderItemEntity extends BaseEntity {
	
	@Column(name = "quantity")
	private Long quantity;
	
	@ManyToOne
	@JoinColumn(name = "order_id",referencedColumnName = "id")
	private OrderEntity order;
	
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id")
	private ProductEntity product;
	
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	
	
}
