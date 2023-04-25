package com.business.converter;

import org.springframework.stereotype.Component;

import com.business.dto.ProductDTO;
import com.business.entity.ProductEntity;

@Component
public class ProductConverter {
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setImgLink(dto.getImgLink());
		entity.setCode(dto.getCode());
		return entity;
	}
	public ProductDTO toDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setImgLink(entity.getImgLink());
		dto.setCode(entity.getCode());
		return dto;
	}
	public ProductEntity toEntity(ProductDTO dto, ProductEntity entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setImgLink(dto.getImgLink());
		entity.setCode(dto.getCode());
		return entity;
	}
}
