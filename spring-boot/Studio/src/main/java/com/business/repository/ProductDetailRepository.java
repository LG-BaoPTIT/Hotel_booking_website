package com.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.entity.ProductDetailEntity;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long>{
	List<ProductDetailEntity> findAllByProductId(long id);
}
