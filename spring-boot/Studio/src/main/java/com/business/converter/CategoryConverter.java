package com.business.converter;

import org.springframework.stereotype.Component;

import com.business.dto.CategoryDTO;
import com.business.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		return entity;
	}
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCode(entity.getCode());
		return dto;
	}
	public CategoryEntity toEntity(CategoryDTO dto, CategoryEntity entity) {
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}
}
