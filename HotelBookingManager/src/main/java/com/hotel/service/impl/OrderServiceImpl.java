package com.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.converter.OrderConverter;
import com.hotel.dto.OrderDTO;
import com.hotel.entities.OrderEntity;
import com.hotel.entities.RoomEntity;
import com.hotel.entities.UserEntity;
import com.hotel.repositories.OrderRepository;
import com.hotel.repositories.RoomRepository;
import com.hotel.repositories.UserRepository;
import com.hotel.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderConverter orderConverter;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public OrderDTO save(OrderDTO orderDTO) {
		OrderEntity orderEntity = new OrderEntity();
		if(orderDTO.getId() != null) {
			OrderEntity existingOrder = orderRepository.findOneById(orderDTO.getId());
			orderEntity = orderRepository.save(orderConverter.toEntity(orderDTO, existingOrder));
		}
		else {
			orderEntity = orderRepository.save(orderConverter.toEntity(orderDTO));
		}
		Optional<UserEntity> userOptional = userRepository.findById(orderDTO.getUser_id());
		UserEntity userEntity = userOptional.orElse(null);
		
		Optional<RoomEntity> roomOptional = roomRepository.findById(orderDTO.getRoom_id());
		RoomEntity roomEntity = roomOptional.orElse(null);
		
		orderEntity.setUser(userEntity);
		orderEntity.setRoom(roomEntity);
		
		orderRepository.save(orderEntity);
		return orderConverter.toDTO(orderEntity);
	}

	

	@Override
	public List<OrderDTO> getAllOrder() {
		List<OrderEntity> orderEntities = orderRepository.findAll();
		List<OrderDTO> orderDTOs = new ArrayList<>();
		for(OrderEntity orderEntity : orderEntities) {
			orderDTOs.add(orderConverter.toDTO(orderEntity));
		}
		return orderDTOs;
	}



	@Override
	public void delete(long id) {
		orderRepository.deleteById(id);
		
	}

	
	@Override
	public List<OrderDTO> getOrderByUserId(long id) {
		List<OrderEntity> orderEntities = orderRepository.findByUserId(id);
		List<OrderDTO> orderDTOs = new ArrayList<>();
		for(OrderEntity orderEntity : orderEntities) {
			orderDTOs.add(orderConverter.toDTO(orderEntity));
		}
		return orderDTOs;
	}

	@Override
	public List<OrderDTO> getOrderByRoomId(long id) {
		List<OrderEntity> orderEntities = orderRepository.findByRoomId(id);
		List<OrderDTO> orderDTOs = new ArrayList<>();
		for(OrderEntity orderEntity : orderEntities) {
			orderDTOs.add(orderConverter.toDTO(orderEntity));
		}
		return orderDTOs;
	}


}
