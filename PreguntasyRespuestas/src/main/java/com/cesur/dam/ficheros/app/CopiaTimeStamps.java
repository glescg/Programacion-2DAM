package com.cesur.dam.ficheros.app;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CopiaTimeStamps {
    public static void main(String[] args) {
        String nombreArchivoFuente = "tema.pdf";
        String directorioDestino = "/PreguntasyRespuestas";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMddHHmmss");
        String marcaDeTiempo = formatoFecha.format(new Date());

        String nombreArchivoDestino = "archivoCopiado_" + marcaDeTiempo + ".pdf"; // Usamos ".pdf" para el archivo destino

        Path rutaArchivoFuente = Paths.get(nombreArchivoFuente);
        Path rutaDirectorioDestino = Paths.get(directorioDestino);
        Path rutaArchivoDestino = rutaDirectorioDestino.resolve(nombreArchivoDestino);

        try {
            if (!Files.exists(rutaDirectorioDestino)) {
                Files.createDirectories(rutaDirectorioDestino);
            }

            Files.copy(rutaArchivoFuente, rutaArchivoDestino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
