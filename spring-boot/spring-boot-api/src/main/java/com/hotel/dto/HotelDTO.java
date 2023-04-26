package com.hotel.dto;

public class HotelDTO extends AbstractDTO {
	private String name;
	private String description;
	private String address;
	private String imgLink;
	private Long quantityRoom;
	private int status;
	private int rating;
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
	
}
