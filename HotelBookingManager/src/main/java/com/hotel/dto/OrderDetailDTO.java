package com.hotel.dto;

import java.util.Date;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO extends AbstractDTO{
	
	private Long quantity;
	
	private Date datein;
	
	private Date dateout;
}
