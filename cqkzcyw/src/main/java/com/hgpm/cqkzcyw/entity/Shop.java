package com.hgpm.cqkzcyw.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tb_shop")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer shop_id;
	private String shop_name;
	private String shop_address;
	private String contact_person1;
	private String contact_person2;
	private String contact_qq;
	private String contact_email;
	private String contact_phone;
	private String contact_number;
	public Shop() {
	}

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getShop_address() {
		return shop_address;
	}

	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}

	public String getContact_person1() {
		return contact_person1;
	}

	public void setContact_person1(String contact_person1) {
		this.contact_person1 = contact_person1;
	}

	public String getContact_person2() {
		return contact_person2;
	}

	public void setContact_person2(String contact_person2) {
		this.contact_person2 = contact_person2;
	}

	public String getContact_qq() {
		return contact_qq;
	}

	public void setContact_qq(String contact_qq) {
		this.contact_qq = contact_qq;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
}
