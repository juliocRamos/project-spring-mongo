package com.learningspringmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learningspringmongo.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTituloContainingIgnoreCase(String text);
}
