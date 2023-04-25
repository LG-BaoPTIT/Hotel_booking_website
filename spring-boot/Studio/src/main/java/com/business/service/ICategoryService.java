package com.business.service;

import java.util.List;

import com.business.dto.CategoryDTO;

public interface ICategoryService {
	CategoryDTO save(CategoryDTO categoryDTO);
	void delete(long id);
	List<CategoryDTO> getAllCategory();
}
