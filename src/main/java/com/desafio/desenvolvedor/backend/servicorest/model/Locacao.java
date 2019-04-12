package com.desafio.desenvolvedor.backend.servicorest.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@SuppressWarnings("serial")
@Table(name = "TB_LOCACAO")
public class Locacao extends ApiRest {

	private long id;
	private Usuario usuario;
	private Date dataLocacao;
	private List<Filme> filmes;
	private int renovarLocacao;
	private Devolucao devolucao;
	private BigDecimal valorLocacao;
	private Date dataPrevistaDevolucao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@NotNull
	@OneToOne
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@NotNull
	public Date getDataLocacao() {
		return dataLocacao;
	}
	
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	
	@NotNull
	@OneToMany(mappedBy = "locacao", targetEntity = Filme.class, fetch = FetchType.LAZY)
	public List<Filme> getFilmes() {
		return filmes;
	}
	
	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
	
	@NotNull
	public int getRenovarLocacao() {
		return renovarLocacao;
	}

	public void setRenovarLocacao(int renovarLocacao) {
		this.renovarLocacao = renovarLocacao;
	}

	@OneToOne
	public Devolucao getDevolucao() {
		return devolucao;
	}
	
	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}
	
	public BigDecimal getValorLocacao() {
		return valorLocacao;
	}
	
	public void setValorLocacao(BigDecimal valorLocacao) {
		this.valorLocacao = valorLocacao;
	}
	
	@NotNull
	public Date getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}
}