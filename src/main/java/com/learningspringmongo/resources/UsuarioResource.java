package com.learningspringmongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningspringmongo.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		Usuario maria = new Usuario(56L, "jack", "jack@gmail.com");
		Usuario alex = new Usuario(46L, "ryan", "ryan@gmail.com");

		List<Usuario> list = Arrays.asList(maria, alex);
		return ResponseEntity.ok().body(list);
	}

}
