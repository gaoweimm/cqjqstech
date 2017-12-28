package com.hgpm.cqkzcyw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hgpm.cqkzcyw.dao.interfaces.NoticeMessageDao;
import com.hgpm.cqkzcyw.entity.NoticeMessage;
import com.hgpm.cqkzcyw.service.BaseService;
import com.hgpm.cqkzcyw.service.interfaces.NoticeMessageService;

public class NoticeMessageServiceImpl extends BaseService implements NoticeMessageService {

	@Autowired
	private NoticeMessageDao noticeMessageDao;
	@Override
	public Integer saveNoticeMessage(NoticeMessage noticeMessage) {

		return noticeMessageDao.saveNoticeMessage(noticeMessage);
	}

	@Override
	public NoticeMessage findById(Integer id) {

		return noticeMessageDao.findById(id);
	}

	@Override
	public List<NoticeMessage> findAll() {

		return noticeMessageDao.findAll();
	}

	@Override
	public void deleteByNoticeMessageId(Integer id) {
		noticeMessageDao.deleteById(id);
		
	}

	@Override
	public void updateNoticeMessage(NoticeMessage noticeMessage) {
		noticeMessageDao.updateNoticeMessage(noticeMessage);
		
	}

}
