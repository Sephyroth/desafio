package com.desafio.desenvolvedor.backend.servicorest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desenvolvedor.backend.servicorest.model.Filme;
import com.desafio.desenvolvedor.backend.servicorest.repository.FilmeRepository;

@RestController
@RequestMapping(value = "filme")
public class FilmeController {

	@Autowired
	FilmeRepository filmeRepository;
	
	String mensagemErroPadrao = "Ocorreu um erro ao salvar o filme causa do erro = ";
	
	@PostMapping("/filme")
	public Filme salvarFilme(@RequestBody Filme filme) {
		
		try {
			filmeRepository.save(filme);
		} catch (Exception e) {
			e.printStackTrace();
			filme.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
		}
		return filme;
	}
	
	@GetMapping("/filme/{id}")
	public Filme buscarFilme(@PathVariable(value = "id") long id) {
		
		Filme filme = new Filme();
		try {
			filme = filmeRepository.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			filme.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
		}
		return filme;
	}
	
	@GetMapping("/filmes")
	public List<Filme> listarFilmes() {

		List<Filme> listaRetorno = new ArrayList<>();
		try {
			listaRetorno.addAll(filmeRepository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			Filme filme = new Filme();
			filme.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
			listaRetorno.add(filme);
		}
		return listaRetorno;
	}
	
	@DeleteMapping("/filme")
	public Filme excluirFilme(@RequestBody Filme filme) {
		
		try {
			filmeRepository.delete(filme);
		} catch (Exception e) {
			e.printStackTrace();
			filme.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
		}
		return filme;
	}
	
	@PutMapping("/filme")
	public Filme atualizarFilme(@RequestBody Filme filme) {
		try {
			filmeRepository.save(filme);
		} catch (Exception e) {
			e.printStackTrace();
			filme.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
		}
		return filme;
	}
}