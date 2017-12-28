package com.hgpm.cqkzcyw.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_notice_message")
public class NoticeMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer message_id;
	private String notice_top;
	private String notice_message_body;
	private String notice_message_type;

	public Integer getMessage_id() {
		return message_id;
	}

	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}

	public String getNotice_top() {
		return notice_top;
	}

	public void setNotice_top(String notice_top) {
		this.notice_top = notice_top;
	}

	public String getNotice_message_body() {
		return notice_message_body;
	}

	public void setNotice_message_body(String notice_message_body) {
		this.notice_message_body = notice_message_body;
	}

	public String getNotice_message_type() {
		return notice_message_type;
	}

	public void setNotice_message_type(String notice_message_type) {
		this.notice_message_type = notice_message_type;
	}
}
