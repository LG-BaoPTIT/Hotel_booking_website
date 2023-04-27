package com.hotel.dto;

import java.math.BigDecimal;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomDTO extends AbstractDTO{
	private String name;
	private String description;
	private String imgLink;
	private Long rate;
	private BigDecimal price;
	private Long status;
}
