package com.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.converter.CategoryConverter;
import com.business.dto.CategoryDTO;
import com.business.entity.CategoryEntity;
import com.business.repository.CategoryRepository;
import com.business.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		if(categoryDTO.getId() != null) {
			CategoryEntity existingCategory = categoryRepository.findOne(categoryDTO.getId());
			categoryEntity = categoryRepository.save(categoryConverter.toEntity(categoryDTO, existingCategory));
		}
		else {
			categoryEntity = categoryRepository.save(categoryConverter.toEntity(categoryDTO));
		}
		return categoryConverter.toDTO(categoryEntity);
	}

	@Override
	public void delete(long id) {
		categoryRepository.delete(id);
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<CategoryEntity> categoriesEntity = categoryRepository.findAll();
		List<CategoryDTO> categoriesDTO = new ArrayList<>();
		for(CategoryEntity categoryEntity : categoriesEntity) {
			categoriesDTO.add(categoryConverter.toDTO(categoryEntity));
		}
		return categoriesDTO;
	}

}
