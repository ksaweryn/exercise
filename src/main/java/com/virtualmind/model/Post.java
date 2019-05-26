	package com.virtualmind.model;
	
	import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
	
	@Entity
	@Table(name = "POST")
	public class Post implements Serializable {
	
		private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue
		@Column(length = 11)
		private Integer id;
	
		@Column
		private String title;
	
		@Column
		private String text;
	
		@ManyToOne(fetch = FetchType.EAGER)
		private Topic topic;
	
		public Post() {
		}
	
		public Post(String title, String text, Topic topic) {
			this.title = title;
			this.text = text;
			this.topic = topic;
		}
	
		// Getters & setters section
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
