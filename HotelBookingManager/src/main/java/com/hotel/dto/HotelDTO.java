package com.hotel.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDTO extends AbstractDTO {
	private String name;
	private String description;
	private String address;
	private String imgLink;
	private Long quantityRoom;
	private int status;
	private int rating;

}
