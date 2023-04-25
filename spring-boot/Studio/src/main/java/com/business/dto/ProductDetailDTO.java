package com.business.dto;

import java.math.BigDecimal;

public class ProductDetailDTO extends AbstractDTO {
	private String memory;
	private BigDecimal price;
	private BigDecimal priceBrick;
	private String productCode;
	private ProductDTO productDTO;
	
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPriceBrick() {
		return priceBrick;
	}
	public void setPriceBrick(BigDecimal priceBrick) {
		this.priceBrick = priceBrick;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
}
