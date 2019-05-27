package com.virtualmind.dao.dto;

import java.util.List;

import com.virtualmind.model.Post;

public class TopicDTO {

	Integer id;
	String name;
	List<Post> posts;

	public TopicDTO() {

	}

	public TopicDTO(Integer id, String name, List<Post> posts) {
		this.id = id;
		this.name = name;
		this.posts = posts;
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
