package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrearBD {
    public static void crearBaseDatos() {
        Connection connection = null;

        try {
            // En SQLite, la base de datos se crea automáticamente al conectar
            connection = DriverManager.getConnection("jdbc:sqlite:prueba.db");

            if (connection != null) {
                System.out.println("BBDD 'prueba' creada con éxito en prueba.db");

                // Verificar que la base de datos existe realmente
                java.io.File dbFile = new java.io.File("prueba.db");
                if (dbFile.exists()) {
                    System.out.println("Archivo de base de datos verificado: " + dbFile.getAbsolutePath());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al crear la BBDD: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
					connection.close();
				}
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        crearBaseDatos();
    }
}