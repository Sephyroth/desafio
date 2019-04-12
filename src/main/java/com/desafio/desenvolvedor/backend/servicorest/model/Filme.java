package com.desafio.desenvolvedor.backend.servicorest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.desafio.desenvolvedor.backend.servicorest.helpers.ClassificacaoEnum;
import com.desafio.desenvolvedor.backend.servicorest.helpers.GeneroEnum;

@Entity
@Table(name = "TB_FILME")
@SuppressWarnings("serial")
public class Filme extends ApiRest {

	private long id;
	private String nome;
	private String diretor;
	private String sinopse;
	private Locacao locacao;
	private GeneroEnum genero;
	private boolean estaAlugado;
	private ClassificacaoEnum classificacao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@NotNull
	@NotEmpty
	@NotBlank
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDiretor() {
		return diretor;
	}
	
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
	public String getSinopse() {
		return sinopse;
	}
	
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	@ManyToOne
	@JoinColumn(name="locacao_id")
	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	
	@NotNull
	public GeneroEnum getGenero() {
		return genero;
	}
	
	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}
	
	public boolean isEstaAlugado() {
		return estaAlugado;
	}

	public void setEstaAlugado(boolean estaAlugado) {
		this.estaAlugado = estaAlugado;
	}

	@NotNull
	public ClassificacaoEnum getClassificacao() {
		return classificacao;
	}
	
	public void setClassificacao(ClassificacaoEnum classificacao) {
		this.classificacao = classificacao;
	}
}