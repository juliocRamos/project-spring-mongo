package com.learningspringmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningspringmongo.dto.UsuarioDTO;
import com.learningspringmongo.entities.Usuario;
import com.learningspringmongo.repository.UsuarioRepository;
import com.learningspringmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findById(String id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto com id: " + id + " não encontrado"));
	}
	
	public Usuario insert(Usuario entity) {
		return repository.insert(entity);
	}
	
	public Usuario fromDTO(UsuarioDTO dto) {
		if (dto != null) {
			return new Usuario(dto.getId(), dto.getNome(), dto.getEmail());
		}
		return null;
	}
}
