package com.desafio.desenvolvedor.backend.servicorest.helpers;

public enum ClassificacaoEnum {
	
	L(01), A(10), B(12), C(14), D(16), E(18);
	 
	public int classificacao;
    
    ClassificacaoEnum(int classificacao) {
    	this.classificacao = classificacao;
    }
}
