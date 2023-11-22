package com.cesur.dam.bbdd.entities;

import java.util.List;

public class Pregunta {
	public String texto; 
	
	public List<Respuesta> respuestas;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	} 
	
	
	
}
