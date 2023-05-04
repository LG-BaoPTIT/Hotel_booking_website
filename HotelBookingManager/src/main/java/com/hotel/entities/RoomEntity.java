package com.hotel.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;



@Entity
@Table(name = "tb_room")
public class RoomEntity extends BaseEntity {
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "img_link")
	private String imgLink;
	
	@Column(name = "rate")
	private Long rate;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "status")
	private Long status;
	

	
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderDetailEntity> orderDetails = new ArrayList<>();
	
	public RoomEntity() {
		super();
	}
	
	public RoomEntity(String name, String description, String imgLink, Long rate, BigDecimal price, Long status,
			List<OrderDetailEntity> orderDetails) {
		super();
		this.name = name;
		this.description = description;
		this.imgLink = imgLink;
		this.rate = rate;
		this.price = price;
		this.status = status;
		
		this.orderDetails = orderDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}


	public List<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	
}

/*
 * mappedBy: cho biết quan hệ này sẽ được ánh xạ thông qua thuộc category của product
 * 
 * cascade = CascadeType.ALL : cho phép các thao tác CRUD được áp dụng đến cả hai bảng
 * 
 * orphanRemoval = true : đảm bảo khi một đối tượng ProductEntity bị xóa khỏi danh sách products thì nó cũng sẽ bị
 * xóa trong cơ sở dữ liệu
 */