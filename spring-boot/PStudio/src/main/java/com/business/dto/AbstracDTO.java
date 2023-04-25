package com.business.dto;

import java.util.Date;

public class AbstracDTO {
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDte;
	
//	private List<T> listResult = new ArrayList<>();

	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDte() {
		return modifiedDte;
	}

	public void setModifiedDte(Date modifiedDte) {
		this.modifiedDte = modifiedDte;
	}
	
	
}
