package com.postit.notes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.postit.notes.model.PostItNoteEntity;
import com.postit.notes.repository.PostItNoteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostitnotesApplicationTests {

	private static PostItNoteEntity createDummyPostItNoteEntityForInsertion() {
		PostItNoteEntity entity = new PostItNoteEntity();
		entity.setPostId(1L);
		entity.setPostText("sometext");
		return entity;
	}

	@Autowired
	private PostItNoteRepository postItNoteRepository;

	@Test
	public void testDependancyInjection() {
		assertNotNull(postItNoteRepository);
	}

	@Test
	public void addPostItNoteTest() {
		PostItNoteEntity entity = createDummyPostItNoteEntityForInsertion();
		postItNoteRepository.save(entity);
		PostItNoteEntity savedNoteEntity = postItNoteRepository.findById(1L).get();

		assertNotNull(savedNoteEntity);
	}

	@Test
	public void updatePostItNoteTest() {
		PostItNoteEntity entity = createDummyPostItNoteEntityForInsertion();
		postItNoteRepository.save(entity);
		PostItNoteEntity savedNoteEntity = postItNoteRepository.findById(1L).get();
		savedNoteEntity.setPostText("the text was updated");
		postItNoteRepository.save(savedNoteEntity);
		PostItNoteEntity updatedNoteEntity = postItNoteRepository.findById(1L).get();

		assertEquals("the text was updated", updatedNoteEntity.getPostText());
	}

	@Test
	public void deletePostItNoteTest() {
		PostItNoteEntity entity = createDummyPostItNoteEntityForInsertion();
		postItNoteRepository.save(entity);
		postItNoteRepository.deleteById(1L);

		assertTrue(true);
	}

	@Test
	public void getAllPostItNotesTest() {
		PostItNoteEntity entityOne = new PostItNoteEntity();
		entityOne.setPostId(11L);
		entityOne.setPostText("entityOne sometext");
		postItNoteRepository.save(entityOne);

		PostItNoteEntity entityTwo = new PostItNoteEntity();
		entityTwo.setPostId(12L);
		entityTwo.setPostText("entityTwo sometext");
		postItNoteRepository.save(entityTwo);

		PostItNoteEntity entityThree = new PostItNoteEntity();
		entityThree.setPostId(13L);
		entityThree.setPostText("entityThree sometext");
		postItNoteRepository.save(entityThree);

		long count = postItNoteRepository.count();

		assertEquals(3, count);

	}

}
