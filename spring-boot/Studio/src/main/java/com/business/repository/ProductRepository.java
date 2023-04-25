package com.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	ProductEntity findByCode(String code);
	List<ProductEntity> findAllByCategoryId(long id);
}
