package com.sena.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = System.getenv().getOrDefault("MEDELED_DB_URL", "jdbc:mysql://localhost:3306/medeled_cmr");
    private static final String USUARIO = System.getenv().getOrDefault("MEDELED_DB_USER", "root");
    private static final String CONTRASENA = System.getenv().getOrDefault("MEDELED_DB_PASSWORD", "");

    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión exitosa a MySQL");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
        conectar();
    }
}
