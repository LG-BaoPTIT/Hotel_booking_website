package com.business.converter;

import org.springframework.stereotype.Component;

import com.business.dto.ProductDetailDTO;
import com.business.entity.ProductDetailEntity;

@Component
public class ProductDetailConverter {
	public ProductDetailEntity toEntity(ProductDetailDTO dto) {
		ProductDetailEntity entity = new ProductDetailEntity();
		entity.setMemory(dto.getMemory());
		entity.setPrice(dto.getPrice());
		entity.setPriceBrick(dto.getPriceBrick());
		return entity;
	}
	public ProductDetailDTO toDTO(ProductDetailEntity entity) {
		ProductDetailDTO dto = new ProductDetailDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setMemory(entity.getMemory());
		dto.setPrice(entity.getPrice());
		dto.setPriceBrick(entity.getPriceBrick());
		return dto;
	}
	public ProductDetailEntity toEntity(ProductDetailDTO dto, ProductDetailEntity entity) {
		entity.setMemory(dto.getMemory());
		entity.setPrice(dto.getPrice());
		entity.setPriceBrick(dto.getPriceBrick());
		return entity;
	}
}
