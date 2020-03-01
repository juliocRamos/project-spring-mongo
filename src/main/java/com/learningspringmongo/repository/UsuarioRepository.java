package com.learningspringmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learningspringmongo.entities.Usuario;

// Repository que irá controlar a comunicação com o mongodb para a entidade Usuário
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
}
