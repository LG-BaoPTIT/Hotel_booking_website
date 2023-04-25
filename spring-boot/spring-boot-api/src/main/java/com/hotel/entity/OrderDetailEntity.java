package com.hotel.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_DetailOrder")
public class OrderDetailEntity extends BaseEntity {
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "datein")
	private Date datein;
	
	@Column(name = "dateout")
	private Date dateout;
	
	@ManyToOne
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	private RoomEntity room;
	
	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private OrderEntity order;

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getDatein() {
		return datein;
	}

	public void setDatein(Date datein) {
		this.datein = datein;
	}

	public Date getDateout() {
		return dateout;
	}

	public void setDateout(Date dateout) {
		this.dateout = dateout;
	}

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	
	

}
