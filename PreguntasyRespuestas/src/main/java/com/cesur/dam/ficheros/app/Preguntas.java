package com.cesur.dam.ficheros.app;

import java.util.ArrayList;
import java.util.List;

public class Preguntas {
    private boolean esMultiple;
    private String enunciado;
    private List<Respuestas> respuestas;

    public Preguntas(boolean esMultiple, String enunciado) {
        this.esMultiple = esMultiple;
        this.enunciado = enunciado;
        this.respuestas = new ArrayList<Respuestas>();
    }

    public boolean isEsMultiple() {
        return esMultiple;
    }

    public void setEsMultiple(boolean esMultiple) {
        this.esMultiple = esMultiple;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<Respuestas> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuestas> respuestas) {
        this.respuestas = respuestas;
    }

    // Agrega respeustas a una lista de respuestas
    public void agregarRespuesta(Respuestas respuesta) {
        respuestas.add(respuesta);
    }
}
