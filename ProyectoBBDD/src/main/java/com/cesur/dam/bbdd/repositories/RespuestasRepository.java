package com.cesur.dam.bbdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cesur.dam.bbdd.repositories.entities.Pregunta;

@Repository
public interface RespuestasRepository extends JpaRepository<Pregunta, Long> {

	/*@Query("SELECT r FROM Respuesta r"
			+ " WHERE r.idPregunta = ?1")
	public List<Respuesta> obtenerRespuestasPorPregunta(Long idPregunta);*/

}
