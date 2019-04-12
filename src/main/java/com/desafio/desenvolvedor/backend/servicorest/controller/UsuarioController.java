package com.desafio.desenvolvedor.backend.servicorest.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.desafio.desenvolvedor.backend.servicorest.helpers.DateHelper;
import com.desafio.desenvolvedor.backend.servicorest.helpers.SituacaoEnum;
import com.desafio.desenvolvedor.backend.servicorest.model.Usuario;
import com.desafio.desenvolvedor.backend.servicorest.repository.DevolucaoRepository;
import com.desafio.desenvolvedor.backend.servicorest.repository.FilmeRepository;
import com.desafio.desenvolvedor.backend.servicorest.repository.HistoricoLocacaoRepository;
import com.desafio.desenvolvedor.backend.servicorest.repository.LocacaoRepository;
import com.desafio.desenvolvedor.backend.servicorest.repository.UsuarioRepository;

import br.com.caelum.stella.validation.CPFValidator;

@RestController
@RequestMapping(value = "user")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	LocacaoRepository locacaoRepository;
	
	@Autowired
	DevolucaoRepository devolucaoRepository;
	
	@Autowired
	FilmeRepository filmeRepository;
	
	@Autowired
	HistoricoLocacaoRepository historicoLocacaoRepository;
	
	String mensagemErroPadrao = "Ocorreu um erro ao salvar o usuario causa do erro = ";
	
	@PostMapping("/usuario")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		
		try {
			int idadeUsuario = DateHelper.calculaIdade(usuario.getDataNascimento());
			if (idadeUsuario > 17) {
				new CPFValidator().assertValid(usuario.getCpf());
				usuario.setDataCadastro(new Date());
				usuario.setSituacao(SituacaoEnum.ATIVO);
				usuarioRepository.save(usuario);
			} else
				usuario.setMensagemRetorno("Erro! idade insuficiente para cadastrar.");
		} catch (Exception e) {
			e.printStackTrace();
			usuario.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
		}
		return usuario;
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario buscarUsuario(@PathVariable(value = "id") long id) {
		
		Usuario usuario = new Usuario();
		try {
			usuario = usuarioRepository.getOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			usuario.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
		}
		return usuario;
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {
//		Usuario usuario = new Usuario();
//		usuario = usuarioRepository.findById(2L).get();
//		
//		Filme filme = new Filme();
//		filme.setNome("filme1");
//		filme.setGenero(GeneroEnum.ACAO);
//		filme.setClassificacao(ClassificacaoEnum.L);
////		filmeRepository.save(filme);
//		
//		Filme filme2 = new Filme();
//		filme2.setNome("filme2");
//		filme2.setGenero(GeneroEnum.ACAO);
//		filme2.setClassificacao(ClassificacaoEnum.L);
////		filmeRepository.save(filme2);
//		
//		List<Filme> listaFilme = new ArrayList<>();
//		listaFilme.add(filme);
//		listaFilme.add(filme2);
//		
//		Devolucao devolucao = new Devolucao();
//		devolucao.setDataRetirada(new Date());
//		devolucaoRepository.save(devolucao);
//		
//		BigDecimal valorLocacao = new BigDecimal(10);
//		
//		
//		Locacao locacao = new Locacao();
//		locacao.setUsuario(usuario);
//		locacao.setDataLocacao(new Date());
//		locacao.setFilmes(listaFilme);
//		locacao.setDevolucao(devolucao);
//		locacao.setValorLocacao(valorLocacao);
//		
//		locacaoRepository.save(locacao);
//		filme.setLocacao(locacao);
//		filme2.setLocacao(locacao);
//		filmeRepository.save(filme);
//		filmeRepository.save(filme2);
		
		List<Usuario> listaRetorno = new ArrayList<>();
		try {
			listaRetorno.addAll(usuarioRepository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			Usuario usuario = new Usuario();
			usuario.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
			listaRetorno.add(usuario);
		}
		return listaRetorno;
	}
	
	@DeleteMapping("/usuario")
	public Usuario excluirUsuario(@RequestBody Usuario usuario) {
		
		try {
			usuarioRepository.delete(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			usuario.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
		}
		return usuario;
	}
	
	@PutMapping("/usuario")
	public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
		try {
			int idadeUsuario = DateHelper.calculaIdade(usuario.getDataNascimento());
			if (idadeUsuario > 17) {
				new CPFValidator().assertValid(usuario.getCpf());
				usuarioRepository.save(usuario);
			} else
				usuario.setMensagemRetorno("Erro! idade insuficiente para cadastrar.");
		} catch (Exception e) {
			e.printStackTrace();
			usuario.setMensagemRetorno(mensagemErroPadrao + e.getMessage());
		}
		return usuario;
	}
}