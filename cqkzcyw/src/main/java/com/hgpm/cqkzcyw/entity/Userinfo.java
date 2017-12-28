package com.hgpm.cqkzcyw.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * �û���Ϣ
 * 
 */
@Entity()
@Table(name = "tb_user")
public class Userinfo {

	private Integer oper_id; // �û�id
	private String oper_name; // �û�����
	private String oper_qq; // QQ
	private String oper_phone; // ��ϵ�绰
	private String oper_no; // �û�����
	private String oper_pwd; // �û�����
	private String oper_type; // �û�����1������Ա2���̼�3����ͨ�û�
	private Date create_date; // ��������
	private String oper_flag; // �Ƿ�ʧЧ��־0��Ч1ʧЧ

	public Userinfo() {
	}

	public Userinfo(Integer oper_id, String oper_name, String oper_qq, String oper_phone, String oper_no,
			String oper_pwd, String oper_type, Date create_date, String oper_flag) {
		super();
		this.oper_id = oper_id;
		this.oper_name = oper_name;
		this.oper_qq = oper_qq;
		this.oper_phone = oper_phone;
		this.oper_no = oper_no;
		this.oper_pwd = oper_pwd;
		this.oper_type = oper_type;
		this.create_date = create_date;
		this.oper_flag = oper_flag;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "oper_id", unique = true, nullable = false)
	public Integer getOper_id() {
		return oper_id;
	}

	public void setOper_id(Integer oper_id) {
		this.oper_id = oper_id;
	}

	public String getOper_name() {
		return oper_name;
	}

	public void setOper_name(String oper_name) {
		this.oper_name = oper_name;
	}

	public String getOper_qq() {
		return oper_qq;
	}

	public void setOper_qq(String oper_qq) {
		this.oper_qq = oper_qq;
	}

	public String getOper_phone() {
		return oper_phone;
	}

	public void setOper_phone(String oper_phone) {
		this.oper_phone = oper_phone;
	}

	public String getOper_no() {
		return oper_no;
	}

	public void setOper_no(String oper_no) {
		this.oper_no = oper_no;
	}

	public String getOper_pwd() {
		return oper_pwd;
	}

	public void setOper_pwd(String oper_pwd) {
		this.oper_pwd = oper_pwd;
	}

	public String getOper_type() {
		return oper_type;
	}

	public void setOper_type(String oper_type) {
		this.oper_type = oper_type;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getOper_flag() {
		return oper_flag;
	}

	public void setOper_flag(String oper_flag) {
		this.oper_flag = oper_flag;
	}

}