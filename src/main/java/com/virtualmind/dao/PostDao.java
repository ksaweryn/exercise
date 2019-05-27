package com.virtualmind.dao;

import java.util.ArrayList;
import java.util.List;

import com.virtualmind.dao.dto.PostDTO;
import com.virtualmind.model.Post;

public class PostDao extends GenericDao<Post, Integer> {

	private int pageSize = 25;

	public List<PostDTO> listPostTitleAndTopics(int pageNumber) {
		@SuppressWarnings("unchecked")
		List<Post> posts = em.createQuery("SELECT p FROM Post p").setFirstResult((-1) * pageSize)
				.setMaxResults(pageSize).getResultList();
		List<PostDTO> result = new ArrayList<>(posts.size());

		for (Post post : posts) {
			PostDTO postDto = new PostDTO();
			postDto.setId(post.getId());
			postDto.setTitle(post.getTitle());
			postDto.setTopic(post.getTopic());
			result.add(postDto);
		}

		return result;
	}

}
