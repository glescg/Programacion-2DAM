package com.cesur.dam.bbdd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesur.dam.bbdd.entities.Pregunta;
import com.cesur.dam.bbdd.entities.Respuesta;
import com.cesur.dam.bbdd.repositories.BBDDRepositorio;
import com.cesur.dam.bbdd.repositories.PreguntasRepository;
import com.cesur.dam.bbdd.repositories.RespuestasRepository;

@Service
public class BBDDService {

	@Autowired
	protected BBDDRepositorio bbddRepositorio;
	
	@Autowired
	protected PreguntasRepository preguntasRepository;
	
	@Autowired
	protected RespuestasRepository respuestasRepository;
	
	/*public String devolverTests() {
		
		conexionBBDD.abrirConexion(); 
		
		Long id = conexionBBDD.insertarTest();
		System.out.println(id); 
		String test = conexionBBDD.devolverTests();
		
		conexionBBDD.cerrarConexion();
		
		return test; 
	}*/
	
	
	/**
	 * Este método lee un archivo de texto y genera una lista de Preguntas
	 * @return
	 */
	protected List<Pregunta> leerFicheroPreguntas() {
		
		
		// TODO 
		List<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
		
		return  listaPreguntas;
		
	}
	
	
	public void insertarRespuesta(Respuesta respuesta, Long idPregunta) {
		respuesta.setIdPregunta(idPregunta);
		bbddRepositorio.insertarRespuesta(respuesta);	
	} 
	
	public void insertarPregunta(Pregunta pregunta) {
		Long idPregunta = bbddRepositorio.insertarPregunta(pregunta);
		
		//insertarRespuestas(pregunta.getRespuestas(), idPregunta);
		
		for (Respuesta respuesta : pregunta.getRespuestas()) {
			insertarRespuesta(respuesta, idPregunta);
		}
		
	} 
	
	
	
	/* 
	 * Este método inserta en BBDD una lista de preguntas
	 */
	public int insertarPreguntas(List<Pregunta> listaPreguntas) {
		
		bbddRepositorio.abrirConexion();
		
		/*
		for (int i = 0; i < listaPreguntas.size(); i++) {
			Pregunta pregunta = listaPreguntas.get(i);
		}
		*/
		
		int contador = 0; 
		for (Pregunta pregunta: listaPreguntas) {
			insertarPregunta(pregunta);
			
			contador++; 
		}
		
		bbddRepositorio.cerrarConexion();
		
		return contador; 
		
	}
	
	
	public int gestionarFicheroPreguntas() {
		
		
		// Primero cargo el fichero de preguntas en una lista
		List<Pregunta> listaPreguntas = leerFicheroPreguntas(); 
		
		// Inserto la lista de preguntas
		
		int numeroPreguntas = insertarPreguntas(listaPreguntas);
		
		
		
		
		return numeroPreguntas;
		
	}
	
	public List<com.cesur.dam.bbdd.repositories.entities.Pregunta> buscarTodasPreguntas() {
	
		return preguntasRepository.findAll();
	}
	
	
	public void verPreguntas() {
		
		
		List<com.cesur.dam.bbdd.repositories.entities.Pregunta> listaPreguntas = buscarTodasPreguntas(); 
		
		for (com.cesur.dam.bbdd.repositories.entities.Pregunta pregunta : listaPreguntas) {
			System.out.println(pregunta.getIdPregunta());
		}
		
	}
}
