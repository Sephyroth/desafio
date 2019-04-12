package com.desafio.desenvolvedor.backend.servicorest.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ApiRest implements Serializable {

	private String mensagemRetorno;

	public String getMensagemRetorno() {
		return mensagemRetorno;
	}

	public void setMensagemRetorno(String mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}
}
