package com.desafio.desenvolvedor.backend.servicorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desenvolvedor.backend.servicorest.model.HistoricoLocacao;

public interface HistoricoLocacaoRepository extends JpaRepository<HistoricoLocacao, Long> {

}
