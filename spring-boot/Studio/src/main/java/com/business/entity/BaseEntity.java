package com.business.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String creatBy;
	@Column
	private Date creatDate;
	@Column
	private String modifyBy;
	@Column
	private Date modifiDate;
	
	
	public Long getId() {
		return id;
	}
	public String getCreatBy() {
		return creatBy;
	}
	public void setCreatBy(String creatBy) {
		this.creatBy = creatBy;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifiDate() {
		return modifiDate;
	}
	public void setModifiDate(Date modifiDate) {
		this.modifiDate = modifiDate;
	}
	
	
}

/*
 * @MappedSuperclass cho phép các thực thể kế thừa các thuộc tính
 * 
 * @Id khai báo xác định xem đâu là thuộc tí primary của entity tương ứng, 
 * mỗi entity bắt buộc phải có thuộc tính này nếu không chạy sẽ bị lỗi 
 * 
 * @Column thêm tên cột vào bảng của một cơ sở MySQL cụ thể
 * 
 *cú pháp : @Column(name = "DESC", nullable = false, length = 512)
 *chuỗi trên mô tả: name - tên cột , nullable - cho phép cột chứa giá trị null, length chiều dài cột
 * */

