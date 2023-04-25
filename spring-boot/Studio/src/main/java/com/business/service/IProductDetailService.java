package com.business.service;

import java.util.List;

import com.business.dto.CategoryDTO;
import com.business.dto.ProductDetailDTO;

public interface IProductDetailService {
	ProductDetailDTO save(ProductDetailDTO productDetailDTO);
	void delete(long id);
	List<CategoryDTO> getAllProductDetail();
}
