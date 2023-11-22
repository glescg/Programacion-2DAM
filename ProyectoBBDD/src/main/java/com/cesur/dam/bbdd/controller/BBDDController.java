package com.cesur.dam.bbdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesur.dam.bbdd.services.BBDDService;

@Controller
public class BBDDController {
	
	@Autowired
	protected BBDDService conexionService;
	
	@ResponseBody
	@GetMapping("/guardarPreguntas")
	public String guardarPreguntas() {
		
		
		int numPreguntas = conexionService.gestionarFicheroPreguntas();
		
		return "Se han insertado " + numPreguntas;
	 
	}
	
	@ResponseBody
	@GetMapping("/verPreguntas")
	public String verPreguntas() {
		
		
		conexionService.verPreguntas();
		
		return "";
	 
	}
}
