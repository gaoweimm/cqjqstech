package com.hgpm.cqkzcyw.service.interfaces;

import java.util.List;

import com.hgpm.cqkzcyw.entity.NoticeMessage;

public interface NoticeMessageService {
	Integer saveNoticeMessage(NoticeMessage noticeMessage);
	NoticeMessage findById(Integer id);
	List<NoticeMessage> findAll();
	void deleteByNoticeMessageId(Integer id);
	void updateNoticeMessage(NoticeMessage noticeMessage);
}
