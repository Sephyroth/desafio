package com.desafio.desenvolvedor.backend.servicorest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table(name = "TB_DEVOLUCAO")
public class Devolucao extends ApiRest {

	private long id;
	private String defeito;
	private Date dataRetirada;
	private Date dataDevolucao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDefeito() {
		return defeito;
	}
	
	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}
	
	public Date getDataRetirada() {
		return dataRetirada;
	}
	
	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
}