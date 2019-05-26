package com.virtualmind.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityNotFoundException;

import com.virtualmind.dao.dto.TopicDTO;
import com.virtualmind.model.Topic;

@Stateless
public class TopicDao extends GenericDao<Topic, Integer> {

	// add queries as needed
	public void updateTopic(Integer topicId, TopicDTO updated) {
		Topic topic = findById(Topic.class, topicId);
		if (topic != null) {
			topic.setName(updated.getName());
		} else {
			throw new EntityNotFoundException(String.valueOf(topicId));
		}
	}

}
