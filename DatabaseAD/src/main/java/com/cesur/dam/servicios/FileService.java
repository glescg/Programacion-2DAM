package com.cesur.dam.servicios;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public void guardarArchivo(MultipartFile archivo) {
//logica de archivos
// Obtiene la ruta absoluta del directorio de trabajo (la raíz del proyecto)
        String directorioDeTrabajo = "DatabaseAD\\Files";

        // Construye la ruta completa para guardar el archivo en la raíz del proyecto
        Path rutaArchivo = Paths.get(directorioDeTrabajo, archivo.getOriginalFilename());

        // Guarda el archivo en la ruta especificada
        try {
            Files.write(rutaArchivo, archivo.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void borrarArchivo(String nombreArchivo) {
        String directorioDeTrabajo = "DatabaseAD\\Files";
        Path rutaArchivo = Paths.get(directorioDeTrabajo, nombreArchivo);
    
        if (!Files.exists(rutaArchivo)) {
            throw new RuntimeException("El archivo " + nombreArchivo + " no existe.");
        } else {
            try {
                Files.deleteIfExists(rutaArchivo);
            } catch (IOException e) {
                throw new RuntimeException("Error al intentar borrar el archivo " + nombreArchivo, e);
            }
        }
    }
    
 

    // Puedes añadir más métodos según tus necesidades, como borrarArchivo, obtenerArchivo, etc.
}
