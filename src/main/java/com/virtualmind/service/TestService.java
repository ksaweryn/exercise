package com.virtualmind.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.virtualmind.dao.TopicDao;
import com.virtualmind.model.Topic;

@Stateless
public class TestService implements Serializable {

	private static final long serialVersionUID = -1174620968201129581L;
	@Inject
	private TopicDao topicDAO;

	@Transactional
	public void callUpdateTopic() {
		topicDAO.findById(Topic.class, 1);
	}
}
