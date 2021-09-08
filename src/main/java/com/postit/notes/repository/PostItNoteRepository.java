package com.postit.notes.repository;

import org.springframework.data.repository.CrudRepository;

import com.postit.notes.model.PostItNoteEntity;

public interface PostItNoteRepository extends CrudRepository<PostItNoteEntity, Long> {

	
}
