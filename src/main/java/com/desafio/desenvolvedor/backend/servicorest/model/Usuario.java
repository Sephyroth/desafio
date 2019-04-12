package com.desafio.desenvolvedor.backend.servicorest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.desafio.desenvolvedor.backend.servicorest.helpers.SexoEnum;
import com.desafio.desenvolvedor.backend.servicorest.helpers.SituacaoEnum;

@Entity
@SuppressWarnings("serial")
@Table(name = "TB_USUARIO")
public class Usuario extends ApiRest {

	private long id;
	private String cpf;
	private String nome;
	private SexoEnum sexo;
	private Locacao locacao;
	private Date dataCadastro;
	private Date dataNascimento;
	private SituacaoEnum situacao;
	
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
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	public SexoEnum getSexo() {
		return sexo;
	}
	
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}
	
	public Locacao getLocacao() {
		return locacao;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public SituacaoEnum getSituacao() {
		return situacao;
	}
	
	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}	
}