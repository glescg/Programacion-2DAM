package com.cesur.dam.ficheros.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Lectura {
    private static final char PREGUNTA_NORMAL = '+';
    private static final char PREGUNTA_MULTIPLE = '*';
    private static final char RESPUESTA_INCORRECTA = '-';

    public static void main(String[] args) {
        File archivo = new File("Preguntas.txt");
        List<Preguntas> preguntasArray = new ArrayList<>();

        Preguntas pregunta = null; // Variable para rastrear la pregunta actual
        List<Preguntas> preguntasM = new ArrayList<>(); // Lista para preguntas múltiples

        try {
            leerArchivo(archivo, preguntasArray, pregunta, preguntasM);
            imprimirPreguntas(preguntasArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerArchivo(File archivo, List<Preguntas> preguntasArray, Preguntas pregunta, List<Preguntas> preguntasM) throws IOException {
        try (FileReader fr = new FileReader(archivo); BufferedReader br = new BufferedReader(fr)) {
            String linea;

            while ((linea = br.readLine()) != null) {
                char tipo = linea.charAt(0);

                switch (tipo) {
                    case PREGUNTA_NORMAL:
                        if (pregunta != null) {
                            preguntasArray.add(pregunta);
                        }
                        linea = linea.substring(1);
                        pregunta = new Preguntas(false, linea);
                        break;
                    case PREGUNTA_MULTIPLE:
                        if (pregunta != null) {
                            preguntasArray.add(pregunta);
                        }
                        linea = linea.substring(1);
                        pregunta = new Preguntas(true, linea);
                        preguntasM.add(pregunta); // Agregar pregunta múltiple a la lista
                        break;
                    case RESPUESTA_INCORRECTA:
                        linea = linea.substring(1);
                        if (pregunta != null) {
                            pregunta.agregarRespuesta(new Respuestas(linea, true));
                        }
                        break;
                    default:
                        if (pregunta != null) {
                            pregunta.agregarRespuesta(new Respuestas(linea, false));
                        }
                        break;
                }
            }

            if (pregunta != null) {
                preguntasArray.add(pregunta);
            }
        }

        if (!preguntasM.isEmpty()) {
            try (FileWriter fichero = new FileWriter("preguntasM.txt");
                 PrintWriter pw = new PrintWriter(fichero)) {
                for (Preguntas preguntaM : preguntasM) {
                    pw.println("*" + preguntaM.getEnunciado()); // Guardar pregunta múltiple
                    for (Respuestas respuesta : preguntaM.getRespuestas()) {
                        
                            pw.println(respuesta.getTexto()); // Guardar respuestas correctas
                        }
                    }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void imprimirPreguntas(List<Preguntas> preguntasArray) {
        for (Preguntas pregunta : preguntasArray) {
            System.out.println("Pregunta: " + pregunta.getEnunciado());
            System.out.println("Respuestas:");
            for (Respuestas respuesta : pregunta.getRespuestas()) {
                System.out.println(respuesta.getTexto());
            }
        }
    }
}
