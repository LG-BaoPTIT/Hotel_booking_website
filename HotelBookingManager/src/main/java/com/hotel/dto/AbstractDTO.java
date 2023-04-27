package com.hotel.dto;

import java.util.Date;
import lombok.*;

@Getter
@Setter
public class AbstractDTO {
	private Long id;
	private String createBy;
	private Date createDate;
	private String modifiedBy;
	private Date modifiedDate;
	
}
