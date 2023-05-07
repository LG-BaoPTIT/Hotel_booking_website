package com.hotel.service;

import java.util.List;

import com.hotel.dto.OrderDTO;


public interface OrderService {
	OrderDTO save(OrderDTO orderDTO);
	void delete(long id);
	List<OrderDTO> getAllOrder();
	List<OrderDTO> getOrderByUserId(long id);
	List<OrderDTO> getOrderByRoomId(long id);
}
