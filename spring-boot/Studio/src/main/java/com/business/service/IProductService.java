package com.business.service;

import java.util.List;

import com.business.dto.CategoryDTO;
import com.business.dto.ProductDTO;

public interface IProductService {
	ProductDTO save(ProductDTO productDTO);
	void delete(long id);
	List<CategoryDTO> getAllProduct();
}
