package com.postit.notes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PostItNoteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long postId;
	private String postText;
	private String postContent;
	private String postTitle;
	 

	public PostItNoteEntity() {
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	@Override
	public String toString() {
		return "PostItNoteEntity [postId=" + postId + ", postText=" + postText + "]";
	}

}
