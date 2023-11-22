package com.cesur.dam.bbdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cesur.dam.bbdd.repositories.entities.Pregunta;

@Repository
public interface PreguntasRepository extends JpaRepository<Pregunta, Long> {


}
