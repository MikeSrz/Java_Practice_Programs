package sqlite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeleccionarUno {
    public static void seleccionarCliente() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConexionSQLite.conectar();
            statement = connection.createStatement();

            String sql = "SELECT * FROM clientes LIMIT 1";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println("Primer cliente:");
                System.out.println("ID: " + resultSet.getInt("cliente_id"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Dirección: " + resultSet.getString("direccion"));
            } else {
                System.out.println("No se encontraron clientes en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
					resultSet.close();
				}
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
        seleccionarCliente();
    }
}