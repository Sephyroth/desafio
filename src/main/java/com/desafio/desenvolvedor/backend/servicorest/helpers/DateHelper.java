package com.desafio.desenvolvedor.backend.servicorest.helpers;

import java.util.Calendar;
import java.util.Date;


public class DateHelper {

	public static int calculaIdade(Date dataNasc) {

	    Calendar dataNascimento = Calendar.getInstance();  
	    dataNascimento.setTime(dataNasc); 
	    
	    Calendar hoje = Calendar.getInstance();  

	    int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR); 

	    if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH))
	      idade--;  
	    else { 
	        if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH))
	            idade--; 
	    }

	    return idade;
	}
	
	public static Date aumentarDiasData(Date date, int dias) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime( date );
		calendar.add( Calendar.DAY_OF_MONTH , dias );
		return calendar.getTime();
	}
}