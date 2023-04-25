package com.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findByCode(String code);
}
