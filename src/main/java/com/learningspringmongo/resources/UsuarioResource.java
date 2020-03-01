package com.learningspringmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@GetMapping(path = "/{id}")
	public ResponseEntity<UsuarioDTO> findDTOByID(@PathVariable String id) {
		Usuario usuario = service.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO dto){
		Usuario entity = service.fromDTO(dto);
		entity = service.insert(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).build();	
	}
}
