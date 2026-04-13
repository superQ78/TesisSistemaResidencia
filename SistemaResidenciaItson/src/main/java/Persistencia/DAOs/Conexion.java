/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cesar
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/SistemaResidenciasItson";
    private static final String USER = "root"; 
    private static final String PASSWORD = "Chicharo78"; 

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}