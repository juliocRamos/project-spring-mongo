package com.learningspringmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningspringmongo.entities.Usuario;
import com.learningspringmongo.services.UsuarioServices;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	// Definição da minha classe de serviços.
	@Autowired
	private UsuarioServices service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
}
