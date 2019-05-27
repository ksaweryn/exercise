package com.virtualmind.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import com.virtualmind.dao.PostDao;
import com.virtualmind.dao.TopicDao;
import com.virtualmind.dao.dto.PostDTO;
import com.virtualmind.model.Topic;

@Stateless
public class TestService implements Serializable {

	private static final long serialVersionUID = -1174620968201129581L;
	@Inject
	private TopicDao topicDAO;
	@Inject
	private PostDao postDAO;

	@Transactional
	public void callUpdateTopic() {
		Topic topic = topicDAO.findById(Topic.class, 9);
		if (topic != null) {
			topic.setName("New asignment");
		} else {
			throw new EntityNotFoundException("10102");
		}
	}

	public List<PostDTO> listPostTitlesAndTopics(int pageNumber) {
		return postDAO.listPostTitleAndTopics(pageNumber);
	}
}
