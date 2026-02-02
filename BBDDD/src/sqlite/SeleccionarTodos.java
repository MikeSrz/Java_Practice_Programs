package sqlite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeleccionarTodos {
    public static void seleccionarTodosClientes() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConexionSQLite.conectar();
            statement = connection.createStatement();

            String sql = "SELECT * FROM clientes";
            resultSet = statement.executeQuery(sql);

            System.out.println("Todos los clientes:");
            System.out.println("================================");

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("cliente_id") +
                                 " | Nombre: " + resultSet.getString("nombre") +
                                 " | Dirección: " + resultSet.getString("direccion"));
            }

            System.out.println("================================");
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
        seleccionarTodosClientes();
    }
}