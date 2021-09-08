package com.postit.notes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postit.notes.exception.PostNotFundException;
import com.postit.notes.model.PostItNoteEntity;
import com.postit.notes.repository.PostItNoteRepository;

@Service
public class PostItNoteService {

	@Autowired
	private PostItNoteRepository postItNoteRepository;

	public List<PostItNoteEntity> findAllPostItNotes() {
		List<PostItNoteEntity> postITList = new ArrayList<>();
		 postItNoteRepository.findAll().forEach(postit -> postITList.add(postit));
		 return postITList;
	}

	public PostItNoteEntity findAllPostItNote(Long postId) {
		return postItNoteRepository.findById(postId).orElseThrow( () -> new PostNotFundException("PostIT note was not found")  );
	}

	public PostItNoteEntity addPostItNote(PostItNoteEntity postItNoteEntity) {
		return postItNoteRepository.save(postItNoteEntity);
	}

	public PostItNoteEntity updatePostItNote(PostItNoteEntity postItNoteEntity) {
		return postItNoteRepository.save(postItNoteEntity);
	}

	public void deletePostItNote(Long id) {
		postItNoteRepository.deleteById(id);
	}
	

}
