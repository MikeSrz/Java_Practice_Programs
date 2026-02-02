package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLite {
    private static final String URL = "jdbc:sqlite:prueba.db";

    public static Connection conectar() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa a la BBDD SQLite: prueba.db");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la BBDD: " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        conectar();
    }
}