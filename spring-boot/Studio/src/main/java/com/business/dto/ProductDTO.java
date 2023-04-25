package com.business.dto;

import java.util.List;

public class ProductDTO extends AbstractDTO {
	private String name;
	private String description;
	private String imgLink;
	private String code;
	private String categoryCode;
	private List<ProductDetailDTO> productDetailDTOs;
	
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
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public List<ProductDetailDTO> getProductDetailDTOs() {
		return productDetailDTOs;
	}
	public void setProductDetailDTOs(List<ProductDetailDTO> productDetailDTOs) {
		this.productDetailDTOs = productDetailDTOs;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
