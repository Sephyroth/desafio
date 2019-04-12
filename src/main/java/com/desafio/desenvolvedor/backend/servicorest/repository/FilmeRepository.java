package com.desafio.desenvolvedor.backend.servicorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desenvolvedor.backend.servicorest.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
