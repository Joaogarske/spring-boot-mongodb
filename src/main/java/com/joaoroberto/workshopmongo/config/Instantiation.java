package com.joaoroberto.workshopmongo.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.joaoroberto.workshopmongo.doman.User;
import com.joaoroberto.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User joao = new User(null,"Joao Roberto","joao@gmail.com");
		User maria = new User(null,"Maria Fatima","maria@gmail.com");
		
		userRepository.save(joao);
		userRepository.save(maria);
	}
	
	
	
	

}
