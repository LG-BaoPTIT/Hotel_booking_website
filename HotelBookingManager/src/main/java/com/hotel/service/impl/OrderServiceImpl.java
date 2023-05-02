package com.hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dto.OrderDTO;
import com.hotel.entities.OrderEntity;
import com.hotel.repositories.OrderRepository;
import com.hotel.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public OrderEntity save(OrderEntity entity) {
		return orderRepository.save(entity);
	}

	@Override
	public List<OrderEntity> saveAll(List<OrderEntity> entities) {
		return (List<OrderEntity>)orderRepository.saveAll(entities);
	}

	@Override
	public Optional<OrderEntity> findById(Long id) {
		return orderRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return orderRepository.existsById(id);
	}

	@Override
	public List<OrderEntity> findAll() {
		return (List<OrderEntity>)orderRepository.findAll();
	}

	@Override
	public List<OrderEntity> findAllById(List<Long> ids) {
		return (List<OrderEntity>)orderRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return orderRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		orderRepository.deleteById(id);
	}

	@Override
	public void delete(OrderEntity entity) {
		orderRepository.delete(entity);
	}

	@Override
	public void deleteAllById(List<Long> ids) {
		orderRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<OrderEntity> entities) {
		orderRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		orderRepository.deleteAll();
	}

	@Override
	public OrderEntity toEntity(OrderDTO dto) {
		OrderEntity entity = new OrderEntity();
		entity.setId(dto.getId());
		entity.setPayMethod(dto.getPayMethod());
		entity.setTotalPrice(dto.getTotalPrice());
		return entity;
	}

	@Override
	public OrderDTO toDTO(OrderEntity entity) {
		OrderDTO dto = new OrderDTO();
		dto.setId(entity.getId());
		dto.setPayMethod(entity.getPayMethod());
		dto.setTotalPrice(entity.getTotalPrice());
		return dto;
	}
	
	
}
