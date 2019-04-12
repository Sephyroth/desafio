package com.desafio.desenvolvedor.backend.servicorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.desenvolvedor.backend.servicorest.model.Devolucao;

public interface DevolucaoRepository extends JpaRepository<Devolucao, Long> {

}
