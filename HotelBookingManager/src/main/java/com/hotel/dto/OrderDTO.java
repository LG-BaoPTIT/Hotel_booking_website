package com.hotel.dto;

import java.math.BigDecimal;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO extends AbstractDTO{

	private BigDecimal totalPrice;

	private String payMethod;
}
