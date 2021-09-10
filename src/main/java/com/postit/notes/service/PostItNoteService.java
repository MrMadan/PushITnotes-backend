package com.postit.notes.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postit.notes.exception.PostNotFundException;
import com.postit.notes.model.PostItNoteEntity;
import com.postit.notes.repository.PostItNoteRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class PostItNoteService {

	@Autowired
	private PostItNoteRepository postItNoteRepository;

	private final static Logger LOGGER = LoggerFactory.getLogger(PostItNoteService.class);

	public List<PostItNoteEntity> findAllPostItNotes() {
		LOGGER.info("findAllPostItNotes  was called");
		List<PostItNoteEntity> postITList = new ArrayList<>();
		postItNoteRepository.findAll().forEach(postit -> postITList.add(postit));
		return postITList;
	}

	public PostItNoteEntity findAllPostItNote(Long postId) {
		LOGGER.info("findAllPostItNote  was called");
		return postItNoteRepository.findById(postId).orElseThrow(() -> {
			PostNotFundException postNotFundException = new PostNotFundException(
					"PushIT Note with id " + postId + " not found");
			LOGGER.error("error in getting post {}", postId, postNotFundException);
			return postNotFundException;
		});
	}

	public PostItNoteEntity addPostItNote(PostItNoteEntity postItNoteEntity) {
		LOGGER.info("addPostItNote  was called");
		return postItNoteRepository.save(postItNoteEntity);
	}

	public PostItNoteEntity updatePostItNote(PostItNoteEntity postItNoteEntity) {
		LOGGER.info("updatePostItNote  was called");
		return postItNoteRepository.save(postItNoteEntity);
	}

	public void deletePostItNote(Long id) {
		LOGGER.info("deletePostItNote  was called");
		postItNoteRepository.deleteById(id);
	}

}
