package com.hgpm.cqkzcyw.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer comment_id;
	private String comment_text;
	private String comment_level;
	private String shop_id;
	private String user_id;
	private Date create_date;
	private String pic_1;
	private String pic_2;
	private String pic_3;
	private String pic_4;
	private String pic_5;
	private String pic_6;

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public String getComment_level() {
		return comment_level;
	}

	public void setComment_level(String comment_level) {
		this.comment_level = comment_level;
	}

	public String getPic_1() {
		return pic_1;
	}

	public void setPic_1(String pic_1) {
		this.pic_1 = pic_1;
	}

	public String getPic_2() {
		return pic_2;
	}

	public void setPic_2(String pic_2) {
		this.pic_2 = pic_2;
	}

	public String getPic_3() {
		return pic_3;
	}

	public void setPic_3(String pic_3) {
		this.pic_3 = pic_3;
	}

	public String getPic_4() {
		return pic_4;
	}

	public void setPic_4(String pic_4) {
		this.pic_4 = pic_4;
	}

	public String getPic_5() {
		return pic_5;
	}

	public void setPic_5(String pic_5) {
		this.pic_5 = pic_5;
	}

	public String getPic_6() {
		return pic_6;
	}

	public void setPic_6(String pic_6) {
		this.pic_6 = pic_6;
	}
}
