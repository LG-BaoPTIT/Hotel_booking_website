package com.business.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
	@Column(name = "name")
	private String name;
	
	@Column(name = "category_code")
	private String code;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<ProductEntity> products = new ArrayList<>();
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<ProductEntity> getProducts() {
		return products;
	}
	
	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	
}

/*
 * mappedBy: cho biết quan hệ này sẽ được ánh xạ thông qua thuộc category của product
 * 
 * cascade = CascadeType.ALL : cho phép các thao tác CRUD được áp dụng đến cả hai bảng
 * 
 * orphanRemoval = true : đảm bảo khi một đối tượng ProductEntity bị xóa khỏi danh sách products thì nó cũng sẽ bị
 * xóa trong cơ sở dữ liệu
 */