package com.business.entity;

import java.util.Date;
import javax.persistence.Id;

public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String createBy;
	private Date creatDate;
	private String modifiedBy;
	private Date modifyDate;

}
