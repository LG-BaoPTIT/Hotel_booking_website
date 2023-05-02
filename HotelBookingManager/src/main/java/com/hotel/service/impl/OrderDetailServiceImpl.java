package com.hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dto.OrderDetailDTO;
import com.hotel.entities.OrderDetailEntity;
import com.hotel.repositories.OrderDetailRepository;
import com.hotel.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Override
	public OrderDetailEntity save(OrderDetailEntity entity) {
		return orderDetailRepository.save(entity);
	}

	@Override
	public List<OrderDetailEntity> saveAll(List<OrderDetailEntity> entities) {
		return (List<OrderDetailEntity>)orderDetailRepository.saveAll(entities);
	}

	@Override
	public Optional<OrderDetailEntity> findById(Long id) {
		return orderDetailRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return orderDetailRepository.existsById(id);
	}

	@Override
	public List<OrderDetailEntity> findAll() {
		return (List<OrderDetailEntity>)orderDetailRepository.findAll();
	}

	@Override
	public Iterable<OrderDetailEntity> findAllById(Iterable<Long> ids) {
		return orderDetailRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return orderDetailRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		orderDetailRepository.deleteById(id);
	}

	@Override
	public void delete(OrderDetailEntity entity) {
		orderDetailRepository.delete(entity);
	}

	@Override
	public void deleteAllById(List<Long> ids) {
		orderDetailRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<OrderDetailEntity> entities) {
		orderDetailRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		orderDetailRepository.deleteAll();
	}

	@Override
	public OrderDetailEntity toEntity(OrderDetailDTO dto) {
		OrderDetailEntity entity = new OrderDetailEntity();
		entity.setId(dto.getId());
		entity.setQuantity(dto.getQuantity());
		entity.setDatein(dto.getDatein());
		entity.setDateout(dto.getDateout());
		return entity;
	}

	@Override
	public OrderDetailDTO toDTO(OrderDetailEntity entity) {
		OrderDetailDTO dto =new OrderDetailDTO();
		dto.setId(entity.getId());
		dto.setQuantity(entity.getQuantity());
		dto.setDatein(entity.getDatein());
		dto.setDateout(entity.getDateout());
		return dto;
	}
	
	
}
