package com.desafio.desenvolvedor.backend.servicorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desenvolvedor.backend.servicorest.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
