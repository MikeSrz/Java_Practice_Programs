package sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarVarios {
    public static void insertarVariosClientes() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConexionSQLite.conectar();

            String sql = "INSERT INTO clientes (nombre, direccion) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Insertar varios clientes
            String[][] clientes = {
                {"Juan", "Barcelona"},
                {"Maria", "Valencia"},
                {"Pedro", "Sevilla"},
                {"Ana", "Bilbao"},
                {"Luis", "Málaga"}
            };

            for (String[] cliente : clientes) {
                preparedStatement.setString(1, cliente[0]);
                preparedStatement.setString(2, cliente[1]);
                preparedStatement.addBatch();
            }

            int[] resultados = preparedStatement.executeBatch();

            System.out.println(resultados.length + " datos insertados");
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
        insertarVariosClientes();
    }
}