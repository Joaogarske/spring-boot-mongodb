package com.joaoroberto.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joaoroberto.workshopmongo.doman.User;

@RestController
@RequestMapping(value="/Users")
public class UserResource {
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User joao = new User("1","Joao Roberto" , "joao@gmail.com");
		User maria = new User("2","Maria Fatima" , "maria@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(joao,maria));
		return ResponseEntity.ok().body(list);
	}

}
