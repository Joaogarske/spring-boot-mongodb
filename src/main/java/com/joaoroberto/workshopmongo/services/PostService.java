package com.joaoroberto.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaoroberto.workshopmongo.doman.Post;
import com.joaoroberto.workshopmongo.repository.PostRepository;
import com.joaoroberto.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	
	public Post findById(String id) {
		Post user = repo.findById(id).orElse(null);
		if(user == null) {
			throw new ObjectNotFoundException("objeto nao encontrado");
		}
		return user;
	}
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
	

}
