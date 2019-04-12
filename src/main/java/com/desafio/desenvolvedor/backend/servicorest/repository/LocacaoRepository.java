package com.desafio.desenvolvedor.backend.servicorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desenvolvedor.backend.servicorest.model.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
