package com.postit.notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postit.notes.model.PostItNoteEntity;
import com.postit.notes.service.PostItNoteService;

@RestController
@RequestMapping("/postit")
public class PostItNoteController {

	@Autowired
	private PostItNoteService postItNoteService;

	@GetMapping("/geddada")
	public String HeyMaddy() {
		return "Hello Geddada";
	}

	@GetMapping("/all")
	public ResponseEntity<List<PostItNoteEntity>> getAllPostItNotes() {
		List<PostItNoteEntity> postitnotes = postItNoteService.findAllPostItNotes();
		return new ResponseEntity<>(postitnotes, HttpStatus.OK);
	}

	@GetMapping("/find/{postId}")
	public ResponseEntity<PostItNoteEntity> getAllPostItNote(@PathVariable("postId") Long id) {
		PostItNoteEntity postItNoteEntity = postItNoteService.findAllPostItNote(id);
		return new ResponseEntity<>(postItNoteEntity, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<PostItNoteEntity> addPostItNote(@RequestBody PostItNoteEntity postItNoteEntity) {
		PostItNoteEntity newPostItNote = postItNoteService.addPostItNote(postItNoteEntity);
		return new ResponseEntity<>(newPostItNote, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<PostItNoteEntity> updatePostItNote(@RequestBody PostItNoteEntity postItNoteEntity) {
		PostItNoteEntity updatedPostItNote = postItNoteService.updatePostItNote(postItNoteEntity);
		return new ResponseEntity<>(updatedPostItNote, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{postId}")
	public ResponseEntity<?> deletePostItNote(@PathVariable("postId") Long id) {
		postItNoteService.deletePostItNote(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
