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
import com.business.dto.ProductDTO;
import com.business.service.impl.ProductService;


@CrossOrigin
@RestController 
public class ProductAPI {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/api/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO model) {
		try {
			ProductDTO productDTO = productService.save(model);
			return ResponseEntity.ok(productDTO);
			
		} catch(RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }
	
	@PutMapping(value = "/api/product/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO model, @PathVariable("id") long id) {
		try {	
			model.setId(id);
			return ResponseEntity.ok(productService.save(model));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	@DeleteMapping(value = "/api/product/{id}")
	public void deleteProduct(@PathVariable("id") long id) {
		productService.delete(id);
	}
	
	@GetMapping(value = "/api/product")
	public List<CategoryDTO> getAllProduct() {
		return productService.getAllProduct();
	}
}

/*http_method
post : thêm 
put : sửa
delete : xóa
get : hiển thị dữ liệu
tên API phải là danh từ

@Controller :định nghĩa cls này là API
@RequestBody : matching key của Api với key của DTO
@ResponBody : trả ra dữ liệu ra ngoài kiểu chuỗi Json
@RequestMapping: nhận request từ client

@RestController = @Controller + @ResponBody
@PostMapping = @RequestMapping + method
*/