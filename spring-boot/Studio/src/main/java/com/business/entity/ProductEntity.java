package com.business.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
	@Column(name = "name")
	private String name;
	
	@Column(name = "product_code")
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "description")
	private String description;
	
	@Column(name = "imgLink")
	private String imgLink;
	
	
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private CategoryEntity category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductDetailEntity> productDetails = new ArrayList<>();
	
	@ManyToMany(mappedBy = "products")
	private List<CommentEntity> comments = new ArrayList<>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItemEntity> cardItems = new ArrayList<>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItemEntity> orderItems = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	public List<ProductDetailEntity> getProductDetails() {
		return productDetails;
	}
	
	public void setProductDetails(List<ProductDetailEntity> productDetails) {
		this.productDetails = productDetails;
	}
	
	public List<CommentEntity> getComments() {
		return comments;
	}
	
	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public List<CartItemEntity> getCardItems() {
		return cardItems;
	}

	public void setCardItems(List<CartItemEntity> cardItems) {
		this.cardItems = cardItems;
	}

	public List<CartItemEntity> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<CartItemEntity> orderItems) {
		this.orderItems = orderItems;
	}
	
}
/*
 * referencedColumnName = "id" thuộc tính này chỉ định tên trường tham chiếu trong bảng liên quan, nếu không
 * có thuộc tính này jpa sẽ sử dụng mặc định trường id để làm tham chiếu vì vậy để rõ ràng hơn ta nên sử dụng thuộc tính này
 * */

