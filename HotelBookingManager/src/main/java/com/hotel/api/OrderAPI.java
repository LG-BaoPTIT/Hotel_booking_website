package com.hotel.api;

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
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.OrderDTO;
import com.hotel.service.impl.OrderServiceImpl;

@CrossOrigin
@RestController
public class OrderAPI {
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@PostMapping(value = "/api/order")
	public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO model) {
		try {
			OrderDTO categoryDTO = orderServiceImpl.save(model);
			return ResponseEntity.ok(categoryDTO);
		} catch(RuntimeException ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }
	
	@PutMapping(value = "/api/order/{id}")
	public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO model, @PathVariable("id") long id) {
		try {	
			model.setId(id);
			return ResponseEntity.ok(orderServiceImpl.save(model));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@DeleteMapping(value = "/api/order/{id}")
	public void deleteCategory(@PathVariable("id") long id) {
		orderServiceImpl.delete(id);
	}
	
	@GetMapping(value = "/api/order")
	public List<OrderDTO> getAllOrder() {
		return orderServiceImpl.getAllOrder();
	}
	
	@GetMapping(value = "/api/order/{id}")
	public List<OrderDTO> getOrderByUserId(@PathVariable("id") long id) {
		return orderServiceImpl.getOrderByUserId(id);
	}
}
