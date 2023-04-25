package com.business.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "rate")
	private Long rating;
	
	@ManyToMany
	@JoinTable(name = "product_comment",
	joinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	private List<ProductEntity> products = new ArrayList<>();
	
	@ManyToMany(mappedBy = "comments")
	private List<UserEntity> users = new ArrayList<>();
	

	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}
	
	public List<ProductEntity> getProducts() {
		return products;
	}
	
	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	
	public List<UserEntity> getUsers() {
		return users;
	}
	
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
}
