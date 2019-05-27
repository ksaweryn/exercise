package com.virtualmind.dao.dto;

import com.virtualmind.model.Topic;

public class PostDTO {

	Integer id;
	String title;
	String text;
	Topic topic;

	public PostDTO() {

	}

	public PostDTO(Integer id, String title, String text, Topic topic) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.topic = topic;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
