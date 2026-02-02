package sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarUno {
    public static void insertarCliente() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConexionSQLite.conectar();

            String sql = "INSERT INTO clientes (nombre, direccion) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "Pepe");
            preparedStatement.setString(2, "Madrid");

            int filasAfectadas = preparedStatement.executeUpdate();

            System.out.println(filasAfectadas + " dato insertado");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
					preparedStatement.close();
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
        insertarCliente();
    }
}