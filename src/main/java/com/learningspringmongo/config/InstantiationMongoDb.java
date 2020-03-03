package com.learningspringmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.learningspringmongo.dto.AutorDTO;
import com.learningspringmongo.entities.Post;
import com.learningspringmongo.entities.Usuario;
import com.learningspringmongo.repository.PostRepository;
import com.learningspringmongo.repository.UsuarioRepository;

// Configuração básica para popular o meu documento com os dados aqui mockados
@Configuration
public class InstantiationMongoDb implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		usuarioRepository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepository.saveAll(Arrays.asList(maria, bob, alex));
		
		Post post1 = new Post(null, sdf.parse("21/08/2018"), "Partiu viagem", "Vou viajar para SP. Abraços!", new AutorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2019"), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		usuarioRepository.saveAll(Arrays.asList(maria, bob, alex));
	}

}
