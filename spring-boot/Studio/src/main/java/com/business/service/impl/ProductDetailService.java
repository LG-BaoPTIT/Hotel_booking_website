package com.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.converter.CategoryConverter;
import com.business.converter.ProductConverter;
import com.business.converter.ProductDetailConverter;
import com.business.dto.CategoryDTO;
import com.business.dto.ProductDTO;
import com.business.dto.ProductDetailDTO;
import com.business.entity.CategoryEntity;
import com.business.entity.ProductDetailEntity;
import com.business.entity.ProductEntity;
import com.business.repository.CategoryRepository;
import com.business.repository.ProductDetailRepository;
import com.business.repository.ProductRepository;
import com.business.service.IProductDetailService;

@Service
public class ProductDetailService implements IProductDetailService {
	
	@Autowired
	private ProductDetailRepository productDetailRepository;
	
	@Autowired
	private ProductDetailConverter productDetailConverter;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public ProductDetailDTO save(ProductDetailDTO productDetailDTO) {
		ProductDetailEntity productDetailEntity = new ProductDetailEntity();
		if (productDetailDTO.getId() != null) {
			ProductDetailEntity existingDetailProduct = productDetailRepository.findOne(productDetailDTO.getId());
			productDetailEntity = productDetailConverter.toEntity(productDetailDTO, existingDetailProduct);
		} else {
			productDetailEntity = productDetailConverter.toEntity(productDetailDTO);
		}
		ProductEntity productEntity = productRepository.findByCode(productDetailDTO.getProductCode());
		productDetailEntity.setProduct(productEntity);
		productDetailRepository.save(productDetailEntity);
		return productDetailConverter.toDTO(productDetailEntity);
	}

	@Override
	public void delete(long id) {
		productDetailRepository.delete(id);
	}

	@Override
	public List<CategoryDTO> getAllProductDetail() {
		List<CategoryEntity> categoryEntities = categoryRepository.findAll();
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		for(CategoryEntity categoryEntity : categoryEntities) {
			CategoryDTO categoryDTO = categoryConverter.toDTO(categoryEntity);
			List<ProductEntity> productEntities = productRepository.findAllByCategoryId(categoryEntity.getId());
			List<ProductDTO> productDTOs = new ArrayList<>();
			for(ProductEntity productEntity : productEntities) {
				ProductDTO productDTO = productConverter.toDTO(productEntity);
				List<ProductDetailEntity> productDetailEntities = productDetailRepository.findAllByProductId(productEntity.getId());
				List<ProductDetailDTO> productDetailDTOs = new ArrayList<>();
				for(ProductDetailEntity productDetailEntity : productDetailEntities) {
					ProductDetailDTO productDetailDTO = productDetailConverter.toDTO(productDetailEntity);
					productDetailDTOs.add(productDetailDTO);
				}
				productDTO.setProductDetailDTOs(productDetailDTOs);
				productDTOs.add(productDTO);
			}
			categoryDTO.setProductDTOs(productDTOs);
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}
	
}
