package com.hgpm.cqkzcyw.dao.impl;

import java.util.List;

import com.hgpm.cqkzcyw.dao.BaseDao;
import com.hgpm.cqkzcyw.dao.interfaces.NoticeMessageDao;
import com.hgpm.cqkzcyw.entity.NoticeMessage;

public class NoticeMessageDaoImpl extends BaseDao implements NoticeMessageDao{

	@Override
	public Integer saveNoticeMessage(NoticeMessage noticeMessage) {
		
		return (Integer) super.save(noticeMessage);
	}

	@Override
	public NoticeMessage findById(Integer id) {
		
		return super.get(NoticeMessage.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeMessage> findAll() {
		String hql = "from NoticeMessage";
		return super.list(hql, null);
	}

	@Override
	public void deleteById(Integer id) {
		super.delete(NoticeMessage.class, id);
	}

	@Override
	public void updateNoticeMessage(NoticeMessage noticeMessage) {
		super.update(noticeMessage);
		
	}

}
