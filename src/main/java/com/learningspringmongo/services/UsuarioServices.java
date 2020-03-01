package com.learningspringmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningspringmongo.entities.Usuario;
import com.learningspringmongo.repository.UsuarioRepository;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}
}
