package sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Eliminar {
    public static void eliminarCliente() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConexionSQLite.conectar();

            String sql = "DELETE FROM clientes WHERE cliente_id = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 1);  // ID del cliente a eliminar

            int filasAfectadas = preparedStatement.executeUpdate();

            System.out.println(filasAfectadas + " dato borrado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
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
        eliminarCliente();
    }
}