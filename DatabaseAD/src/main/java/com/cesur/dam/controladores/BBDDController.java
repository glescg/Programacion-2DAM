package com.cesur.dam.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cesur.dam.servicios.ConexionService;
import com.cesur.dam.servicios.FileService;

@Controller
public class BBDDController {
	
    @Autowired
    protected ConexionService conexionService;

    @Autowired
    private final FileService fileService;

    public BBDDController(FileService fileService) {
        this.fileService = fileService;
    }

    @ResponseBody
    @GetMapping("/conexion")
    public String devolvertests() {
        return conexionService.devolverTests();
    }
	@ResponseBody
    @PostMapping("/subirArchivo") //PostMapping indica que el metodo responde a solicitudes HTTP Post
    public String subirArchivo(@RequestParam("archivo") MultipartFile archivo) { //RequestParam parametro para recibir el archivo que se esta subiendo
		//MultipartFile interfaz de Spring que proporciona metodos para interactuar con archivos que se stan subiendo
        fileService.guardarArchivo(archivo);
        return "Archivo subido correctamente";
    }
}
