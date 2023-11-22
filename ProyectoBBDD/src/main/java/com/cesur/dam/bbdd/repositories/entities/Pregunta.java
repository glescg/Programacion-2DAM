package com.cesur.dam.bbdd.repositories.entities;

import java.util.ArrayList;
import java.util.List;

import com.cesur.dam.bbdd.repositories.entities.Respuesta;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "preguntas")
public class Pregunta {
	@Id
	@Column(name="id_pregunta")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	protected Long idPregunta;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="pregunta", fetch = FetchType.EAGER)
	protected List<Respuesta> respuestas = new ArrayList<>();

	public Long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	
}
