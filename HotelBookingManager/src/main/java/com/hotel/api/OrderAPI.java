package com.hotel.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.OrderDTO;
import com.hotel.entities.OrderEntity;
import com.hotel.service.OrderService;

@RestController("")
@CrossOrigin
@RequestMapping("/api/orders")
public class OrderAPI {
	@Autowired
	OrderService orderService;
	
	@GetMapping("")
	public List<OrderDTO> getAllOrder(){
		List<OrderDTO> result = new ArrayList<>();
		List<OrderEntity> entities = orderService.findAll();
		for(OrderEntity entity : entities) {
			result.add(orderService.toDTO(entity));
		}
		return result;
	}
	
	@PostMapping("")
	public ResponseEntity<OrderEntity> addOrder(@RequestBody OrderDTO model){
		try {
			OrderEntity entity = new OrderEntity();
			entity = orderService.save(orderService.toEntity(model));
			return ResponseEntity.ok(entity);
			
		}catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<OrderEntity> updateOrder(@RequestBody OrderDTO model){
		try {
			OrderEntity entity = new OrderEntity();
			entity = orderService.save(orderService.toEntity(model));
			return ResponseEntity.ok(entity);
		}catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteOrder(@PathVariable Long id) {
		orderService.deleteById(id);
	}
	
	
}
