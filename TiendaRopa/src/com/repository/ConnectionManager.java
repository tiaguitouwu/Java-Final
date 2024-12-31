package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL = "jdbc:mysql://database.tiagomartinez.xyz:3306/tiendaropa";

    private static final String USER = "app_connect";
    private static final String PASSWORD = "app_connect";
    
    

    public static Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
        
        System.out.println("Conectado!!");
        
        return conn;
    }
}

