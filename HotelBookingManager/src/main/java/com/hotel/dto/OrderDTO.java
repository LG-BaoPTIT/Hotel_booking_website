package com.hotel.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO extends AbstractDTO{
	private Long quantity;
	
	private String datein;
	
	private String dateout;
	
	private BigDecimal totalPrice;
	
	private Long user_id;
	private Long room_id;
	
	private RoomDTO room;
	private UserDTO user;
}
