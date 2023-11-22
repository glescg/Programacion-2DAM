package com.cesur.dam.bbdd.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.cesur.dam.bbdd.entities.Pregunta;
import com.cesur.dam.bbdd.entities.Respuesta;

@Repository
public class BBDDRepositorio {
	
	public Connection conexion; 
	
	public void abrirConexion() {
		String connectionUrl =
                "jdbc:mariadb://localhost:3306/bbdd";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    connectionUrl, "guilla", "guilla");
            System.out.println("Conectado...");
        } catch (SQLException | ClassNotFoundException ce) {
            ce.printStackTrace();
        }
	}
	
	public void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
			} catch ( SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
	
	public String devolverTests() {
			    
        try {
        	Statement stmt = conexion.createStatement();
            String sql = "SELECT * FROM tests"; 

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	System.out.println(rs.getString("titulo"));
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
        	sqle.printStackTrace();
        } 
        
        return "";
	}
	
	public Long insertarTest() {
		try {
        	Statement stmt = conexion.createStatement();
            String sql = "INSERT INTO tests (titulo) VALUES ('Prueba')"; 

            int i = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
            	return generatedKeys.getLong(1);                    
            }
            stmt.close();
        } catch (SQLException sqle) {
        	sqle.printStackTrace();
        } 
		return null;
		
	}
	
	
	public Long insertarPregunta(Pregunta pregunta) {
		
		try {
        	String sql = "INSERT INTO preguntas (id_test, pregunta, multiple ) VALUES (?, ?, ?)"; 
            
        	/*
        	 sql = "INSERT INTO preguntas (id_test, pregunta, multiple ) VALUES (0, '" +
        	 							pregunta.getTexto() + 
        								"', 0)"; 
            */
        	
        	
        	
            PreparedStatement stmt = conexion.prepareStatement(sql);
            
            stmt.setLong(1, 0);
            stmt.setString(2,  pregunta.getTexto());
            stmt.setInt(3, 0);
            
            
            int i = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
            	return generatedKeys.getLong(1); // Devuelve la clave generada                   
            }
            stmt.close();
        } catch (SQLException sqle) {
        	sqle.printStackTrace();
        } 
		// Si no va bien, salta una excepción y devuelve un null
		return null; 
	}
	
	public Long insertarRespuesta(Respuesta respuesta) {
		
		try {
        	String sql = "INSERT INTO respuestas (id_pregunta, respuesta, correcta) VALUES (?, ?, ?)"; 
            
            PreparedStatement stmt = conexion.prepareStatement(sql);
            
            stmt.setLong(1, 0);
            stmt.setString(2, respuesta.getTexto());
            stmt.setInt(3, 0);
            
            
            int i = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
            	return generatedKeys.getLong(1); // Devuelve la clave generada                   
            }
            stmt.close();
        } catch (SQLException sqle) {
        	sqle.printStackTrace();
        } 
		// Si no va bien, salta una excepción y devuelve un null
		return null; 
	}
}
