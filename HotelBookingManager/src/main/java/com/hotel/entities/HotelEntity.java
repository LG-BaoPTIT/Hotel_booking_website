package com.hotel.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_hotel")
public class HotelEntity extends BaseEntity {
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "imgLink")
	private String imgLink;
	
	@Column(name = "quantityRoom")
	private Long quantityRoom;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "rating")
	private int rating;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RoomEntity> rooms = new ArrayList<>();
	
	
	
	public HotelEntity() {
		super();
	}
	
	
	public HotelEntity(String name, String description, String address, String imgLink, Long quantityRoom, int status,
			int rating, List<RoomEntity> rooms) {
		super();
		this.name = name;
		this.description = description;
		this.address = address;
		this.imgLink = imgLink;
		this.quantityRoom = quantityRoom;
		this.status = status;
		this.rating = rating;
		this.rooms = rooms;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImgLink() {
		return imgLink;
	}
	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
	public Long getQuantityRoom() {
		return quantityRoom;
	}
	public void setQuantityRoom(Long quantityRoom) {
		this.quantityRoom = quantityRoom;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public List<RoomEntity> getRooms() {
		return rooms;
	}
	public void setRooms(List<RoomEntity> rooms) {
		this.rooms = rooms;
	}
	
}
