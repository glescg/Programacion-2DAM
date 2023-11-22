package com.cesur.dam.bbdd.repositories.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "respuestas")
public class Respuesta {
	@Id
	@Column(name="id_respuesta")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	protected Long idRespuesta;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_pregunta")
	@JsonIgnore
	private Pregunta pregunta;

	public Long getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(Long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
	
}
