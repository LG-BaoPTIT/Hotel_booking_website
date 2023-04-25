package com.business.api;

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

import com.business.dto.CategoryDTO;
import com.business.dto.ProductDetailDTO;
import com.business.service.impl.ProductDetailService;

@CrossOrigin
@RestController 
public class ProductDetailAPI {
	@Autowired
	private ProductDetailService productDetailService;
	
	@PostMapping(value = "/api/product/detail")
	public ResponseEntity<ProductDetailDTO> addProductDetail(@RequestBody ProductDetailDTO model) {
		try {
			ProductDetailDTO productDetailDTO = productDetailService.save(model);
			return ResponseEntity.ok(productDetailDTO);
		} catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PutMapping(value = "/api/product/detail/{id}")
	public ResponseEntity<ProductDetailDTO> updateProductDetail(@RequestBody ProductDetailDTO model, @PathVariable("id") long id) {
		try {	
			model.setId(id);
			return ResponseEntity.ok(productDetailService.save(model));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@DeleteMapping(value = "/api/product/detail/{id}")
	public void deleteProduct(@PathVariable("id") long id) {
		productDetailService.delete(id);
	}
	
	@GetMapping(value = "/api/product/detail")
	public List<CategoryDTO> getAllProductDetail() {
		return productDetailService.getAllProductDetail();
	}
}
