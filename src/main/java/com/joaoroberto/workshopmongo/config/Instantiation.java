package com.joaoroberto.workshopmongo.config;



import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.joaoroberto.workshopmongo.doman.Post;
import com.joaoroberto.workshopmongo.doman.User;
import com.joaoroberto.workshopmongo.dto.AuthorDTO;
import com.joaoroberto.workshopmongo.repository.PostRepository;
import com.joaoroberto.workshopmongo.repository.UserRepository;
import com.mongodb.client.model.geojson.Position;


@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GNI"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User joao = new User(null,"Joao Roberto","joao@gmail.com");
		User maria = new User(null,"Maria Fatima","maria@gmail.com");
		
		userRepository.save(joao);
		userRepository.save(maria);
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"), "Partiu Viagem", "Vou VIajar para sao paulo",new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("23/03/2018"), "Bom dia", "Acordei Feliz", new AuthorDTO(maria));

		postRepository.save(post1);
		postRepository.save(post2);
	}
	
	
	
	

}
