package com.hgpm.cqkzcyw.dao.interfaces;

import java.util.List;

import com.hgpm.cqkzcyw.entity.NoticeMessage;

public interface NoticeMessageDao {

	Integer saveNoticeMessage(NoticeMessage noticeMessage);
	NoticeMessage findById(Integer id);
	List<NoticeMessage> findAll();
	void deleteById(Integer id);
	void updateNoticeMessage(NoticeMessage noticeMessage);
}
