package com.hgpm.cqkzcyw.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tb_shop_detail")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ShopDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer detail_id;
	private String detail_top;
	private String detail_name;
	private String detail_introduction;
	private String detail_sale;
	private String detail_traffic;
	private String detail_contact;
	private String detail_pic1;
	private String detail_pic2;
	private String detail_pic3;
	private String detail_pic4;
	private String detail_pic5;
	private Integer shop_id;

	public Integer getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(Integer detail_id) {
		this.detail_id = detail_id;
	}

	public String getDetail_top() {
		return detail_top;
	}

	public void setDetail_top(String detail_top) {
		this.detail_top = detail_top;
	}

	public String getDetail_name() {
		return detail_name;
	}

	public void setDetail_name(String detail_name) {
		this.detail_name = detail_name;
	}

	public String getDetail_introduction() {
		return detail_introduction;
	}

	public void setDetail_introduction(String detail_introduction) {
		this.detail_introduction = detail_introduction;
	}

	public String getDetail_sale() {
		return detail_sale;
	}

	public void setDetail_sale(String detail_sale) {
		this.detail_sale = detail_sale;
	}

	public String getDetail_traffic() {
		return detail_traffic;
	}

	public void setDetail_traffic(String detail_traffic) {
		this.detail_traffic = detail_traffic;
	}

	public String getDetail_contact() {
		return detail_contact;
	}

	public void setDetail_contact(String detail_contact) {
		this.detail_contact = detail_contact;
	}

	public String getDetail_pic1() {
		return detail_pic1;
	}

	public void setDetail_pic1(String detail_pic1) {
		this.detail_pic1 = detail_pic1;
	}

	public String getDetail_pic2() {
		return detail_pic2;
	}

	public void setDetail_pic2(String detail_pic2) {
		this.detail_pic2 = detail_pic2;
	}

	public String getDetail_pic3() {
		return detail_pic3;
	}

	public void setDetail_pic3(String detail_pic3) {
		this.detail_pic3 = detail_pic3;
	}

	public String getDetail_pic4() {
		return detail_pic4;
	}

	public void setDetail_pic4(String detail_pic4) {
		this.detail_pic4 = detail_pic4;
	}

	public String getDetail_pic5() {
		return detail_pic5;
	}

	public void setDetail_pic5(String detail_pic5) {
		this.detail_pic5 = detail_pic5;
	}

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

}
