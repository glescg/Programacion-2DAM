package com.cesur.dam.ficheros.app;

public class Respuestas {
private String texto;
private boolean correcto;
public Respuestas(String texto, boolean correcto) {
	this.texto = texto;
	this.correcto = correcto;
}
public Respuestas() {
}
public String getTexto() {
	return texto;
}
public void setTexto(String texto) {
	this.texto = texto;
}
public boolean isCorrecto() {
	return correcto;
}
public void setCorrecto(boolean correcto) {
	this.correcto = correcto;
}

}
