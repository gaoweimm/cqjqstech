package com.hgpm.cqkzcyw.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_soft_text")
public class SoftText {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer soft_text_id;
	private String soft_top;
	private String soft_text_body;
	private String soft_text_type;

	public Integer getSoft_text_id() {
		return soft_text_id;
	}

	public void setSoft_text_id(Integer soft_text_id) {
		this.soft_text_id = soft_text_id;
	}

	public String getSoft_top() {
		return soft_top;
	}

	public void setSoft_top(String soft_top) {
		this.soft_top = soft_top;
	}

	public String getSoft_text_body() {
		return soft_text_body;
	}

	public void setSoft_text_body(String soft_text_body) {
		this.soft_text_body = soft_text_body;
	}

	public String getSoft_text_type() {
		return soft_text_type;
	}

	public void setSoft_text_type(String soft_text_type) {
		this.soft_text_type = soft_text_type;
	}

}
