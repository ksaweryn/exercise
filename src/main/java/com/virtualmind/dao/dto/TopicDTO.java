package com.virtualmind.dao.dto;

import com.virtualmind.model.Post;

public class TopicDTO {

	Integer id;
	String name;
	Post post;

	public TopicDTO() {

	}

	public TopicDTO(Integer id, String name, Post post) {
		this.id = id;
		this.name = name;
		this.post = post;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
