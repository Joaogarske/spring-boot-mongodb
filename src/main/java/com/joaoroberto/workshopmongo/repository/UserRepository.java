package com.joaoroberto.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joaoroberto.workshopmongo.doman.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	

}
