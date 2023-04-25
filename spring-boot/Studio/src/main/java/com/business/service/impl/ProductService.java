package com.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.converter.CategoryConverter;
import com.business.converter.ProductConverter;
import com.business.dto.CategoryDTO;
import com.business.dto.ProductDTO;
import com.business.entity.CategoryEntity;
import com.business.entity.ProductEntity;
import com.business.repository.CategoryRepository;
import com.business.repository.ProductRepository;
import com.business.service.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Override
	public ProductDTO save(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		
		if(productDTO.getId() != null) {
			ProductEntity existingProduct = productRepository.findOne(productDTO.getId());
			productEntity = productConverter.toEntity(productDTO,existingProduct);
		} else {
			productEntity = productConverter.toEntity(productDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findByCode(productDTO.getCategoryCode());
		productEntity.setCategory(categoryEntity);
		productRepository.save(productEntity);
		return productConverter.toDTO(productEntity);
	}

	@Override
	public void delete(long id) {
		productRepository.delete(id);
	}

	@Override
	public List<CategoryDTO> getAllProduct() {
		List<CategoryEntity> categoryEntities = categoryRepository.findAll();
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		for(CategoryEntity categoryEntity : categoryEntities) {
			CategoryDTO categoryDTO = categoryConverter.toDTO(categoryEntity);
			List<ProductEntity> productEntities = productRepository.findAllByCategoryId(categoryEntity.getId());
			List<ProductDTO> productDTOs = new ArrayList<>();
			for(ProductEntity productEntity : productEntities) {
				ProductDTO productDTO = productConverter.toDTO(productEntity);
				productDTO.setCategoryCode(categoryDTO.getCode());
				productDTOs.add(productDTO);
			}
			
			categoryDTO.setProductDTOs(productDTOs);
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}
}
