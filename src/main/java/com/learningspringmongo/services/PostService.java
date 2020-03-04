package com.learningspringmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningspringmongo.entities.Post;
import com.learningspringmongo.repository.PostRepository;
import com.learningspringmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto com id: " + id + " não encontrado"));
	}
	
	
	public List<Post> findByTitle(String text){
		return repository.findByTituloContainingIgnoreCase(text);
	}
}
