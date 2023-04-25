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
import com.business.service.impl.CategoryService;

@CrossOrigin
@RestController
public class CategoryAPI {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping(value = "/api/category")
	public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO model) {
		try {
			CategoryDTO categoryDTO = categoryService.save(model);
			return ResponseEntity.ok(categoryDTO);
			
		} catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }
	
	@PutMapping(value = "/api/category/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO model, @PathVariable("id") long id) {
		try {	
			model.setId(id);
			return ResponseEntity.ok(categoryService.save(model));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@DeleteMapping(value = "/api/category/{id}")
	public void deleteCategory(@PathVariable("id") long id) {
		categoryService.delete(id);
	}
	
	@GetMapping(value = "/api/category")
	public List<CategoryDTO> getAllCategory() {
		return categoryService.getAllCategory();
	}
	
	
	
}
