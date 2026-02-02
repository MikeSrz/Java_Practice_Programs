
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Actualizar {
    public static void actualizarCliente() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String url = "jdbc:mysql://localhost:7777/prueba";
            connection = DriverManager.getConnection(url, "root", "");

            String sql = "UPDATE clientes SET nombre = ? WHERE nombre = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "Luisa");
            preparedStatement.setString(2, "Luis");

            int filasAfectadas = preparedStatement.executeUpdate();

            //connection.commit();
            System.out.println(filasAfectadas + " dato actualizado");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
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
        actualizarCliente();
    }
}