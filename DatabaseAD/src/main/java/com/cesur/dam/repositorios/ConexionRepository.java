package com.cesur.dam.repositorios;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class ConexionRepository {

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    public String confirmarConexion() {
        try {
            System.out.println("Conectado a la base de datos...");

            // Usa las variables databaseUrl, databaseUsername y databasePassword en tu código

        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }
		return "Conectado";
    }
}
