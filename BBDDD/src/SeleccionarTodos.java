

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeleccionarTodos {
    public static void seleccionarTodosClientes() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            String url = "jdbc:mysql://localhost:3306/prueba";
            connection = DriverManager.getConnection(url, "root", "");
            statement = connection.createStatement();

            String sql = "SELECT * FROM clientes";
            resultSet = statement.executeQuery(sql);

            System.out.println("Todos los clientes:");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("cliente_id") + ", " +
                                   resultSet.getString("nombre") + ", " +
                                   resultSet.getString("direccion"));
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
        seleccionarTodosClientes();
    }
}