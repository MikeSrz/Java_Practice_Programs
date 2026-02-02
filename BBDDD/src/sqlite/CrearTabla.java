package sqlite;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
    public static void crearTablaClientes() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConexionSQLite.conectar();
            statement = connection.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS clientes (" +
                         "cliente_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "nombre TEXT NOT NULL," +
                         "direccion TEXT" +
                         ")";

            statement.executeUpdate(sql);
            System.out.println("Tabla 'clientes' creada correctamente en prueba.db");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
					statement.close();
				}
                if (connection != null) {
					connection.close();
				}
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        crearTablaClientes();
    }
}