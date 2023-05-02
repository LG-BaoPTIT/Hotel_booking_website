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

import com.hotel.dto.OrderDetailDTO;
import com.hotel.entities.OrderDetailEntity;
import com.hotel.service.OrderDetailService;

@RestController("")
@CrossOrigin
@RequestMapping("/api/orderdetails")
public class OrderDetailAPI {
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@GetMapping("")
	public List<OrderDetailDTO> getAllOrderDetail(){
		List<OrderDetailDTO> result = new ArrayList<>();
		List<OrderDetailEntity> entities =  orderDetailService.findAll();
		for(OrderDetailEntity entity : entities) {
			result.add(orderDetailService.toDTO(entity));
		}
		return result;
	}
	
	@PostMapping("")
	public ResponseEntity<OrderDetailEntity> addOrderDetail(@RequestBody OrderDetailDTO model){
		try {
			OrderDetailEntity entity = new OrderDetailEntity();
			entity = orderDetailService.save(orderDetailService.toEntity(model));
			return ResponseEntity.ok(entity);
		}catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<OrderDetailEntity> updateOrderetail(@RequestBody OrderDetailDTO model){
		try {
			OrderDetailEntity entity = new OrderDetailEntity();
			entity = orderDetailService.save(orderDetailService.toEntity(model));
			return ResponseEntity.ok(entity);
			
		}catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}
	@DeleteMapping("/delete/{id}")
	public void deleteOrderDetail(@PathVariable Long id) {
		orderDetailService.deleteById(id);
	}

}
