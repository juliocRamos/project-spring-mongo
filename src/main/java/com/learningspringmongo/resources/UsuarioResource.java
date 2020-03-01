package com.learningspringmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningspringmongo.dto.UsuarioDTO;
import com.learningspringmongo.entities.Usuario;
import com.learningspringmongo.services.UsuarioServices;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	// Definição da minha classe de serviços.
	@Autowired
	private UsuarioServices service;

	@GetMapping(path = "/entities")
	public ResponseEntity<List<Usuario>> findAllEntities() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(path = "/dtos")
	public ResponseEntity<List<UsuarioDTO>> findAllDTOs() {
		List<Usuario> entityList = service.findAll();
		List<UsuarioDTO> dtoList = entityList.stream().map(e -> new UsuarioDTO(e)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtoList);
	}
}
