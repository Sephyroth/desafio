package com.desafio.desenvolvedor.backend.servicorest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.desenvolvedor.backend.servicorest.helpers.DateHelper;
import com.desafio.desenvolvedor.backend.servicorest.helpers.SituacaoEnum;
import com.desafio.desenvolvedor.backend.servicorest.model.Filme;
import com.desafio.desenvolvedor.backend.servicorest.model.HistoricoLocacao;
import com.desafio.desenvolvedor.backend.servicorest.model.Locacao;
import com.desafio.desenvolvedor.backend.servicorest.repository.FilmeRepository;
import com.desafio.desenvolvedor.backend.servicorest.repository.HistoricoLocacaoRepository;
import com.desafio.desenvolvedor.backend.servicorest.repository.LocacaoRepository;
import com.desafio.desenvolvedor.backend.servicorest.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "alugar")
public class LocacaoController {

	@Autowired
	LocacaoRepository locacaoRepository;
	
	@Autowired
	FilmeRepository filmeRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	HistoricoLocacaoRepository historicoLocacaoRepository;
	
	String mensagemErroPadrao = "Ocorreu um erro ao salvar o filme causa do erro = ";
	
	@PostMapping("/alugarFimes")
	public Locacao alugarFilmes(@RequestBody Locacao locacao) {
		
		try {
			List<Filme> listaAux = new ArrayList<>();
			if (locacao.getFilmes().size() < 6) {
				for (Filme item : locacao.getFilmes()) {
					item = filmeRepository.findById(item.getId()).get();
					
					if (item.isEstaAlugado()) {
						locacao.setMensagemRetorno("Erro! filme = " + item.getNome() + " indisponível para locação.");
						return locacao;
					}
					listaAux.add(item);
				}
				
				locacao.setUsuario(usuarioRepository.findById(locacao.getUsuario().getId()).get());
				
				if (locacao.getUsuario().getSituacao().equals(SituacaoEnum.BLOQUEADO)) {
					locacao.setMensagemRetorno("Erro! usuario esta bloqueado.");
					return locacao;
				}
				
				locacao.setDataLocacao(new Date());
				locacao.setRenovarLocacao(2);
				locacaoRepository.save(locacao);
				
				for (Filme filme : listaAux) {
					filme.setLocacao(locacao);
					filme.setEstaAlugado(true);
					filmeRepository.save(filme);
				}
				
				HistoricoLocacao historicoLocacao = new HistoricoLocacao();
				BeanUtils.copyProperties(locacao, historicoLocacao);
				historicoLocacao.setId(0);
				historicoLocacao.setDataMovimentacao(new Date());
//				historicoLocacaoRepository.save(historicoLocacao);
			} else
				locacao.setMensagemRetorno("Erro! usuario não pode locar mais de 5 filmes.");
		} catch (Exception e) {
			e.printStackTrace();
			locacao.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
		}
		return locacao;
	}
	
	@GetMapping("/locacoes")
	public List<Locacao> listarLocacoes() {

		List<Locacao> listaRetorno = new ArrayList<>();
		try {
			listaRetorno.addAll(locacaoRepository.findAll());
		} catch (Exception e) {
			Locacao locacao = new Locacao();
			locacao.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
			listaRetorno.add(locacao);
		}
		return listaRetorno;
	}
	
	@GetMapping("/locacao/{id}")
	public Locacao renovarLocacao(@PathVariable(value = "id") long id) {

		Locacao locacao = new Locacao();
		try {
			locacao = locacaoRepository.findById(id).get();
			locacao.setDataPrevistaDevolucao(DateHelper.aumentarDiasData(locacao.getDataPrevistaDevolucao(), 5));
			locacaoRepository.save(locacao);
		} catch (Exception e) {
			locacao.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
		}
		return locacao;
	}
}