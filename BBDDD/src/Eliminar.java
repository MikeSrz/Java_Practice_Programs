
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Eliminar {
    public static void eliminarCliente() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String url = "jdbc:mysql://localhost:3306/prueba";
            connection = DriverManager.getConnection(url, "root", "");

            String sql = "DELETE FROM clientes WHERE cliente_id = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 1);

            int filasAfectadas = preparedStatement.executeUpdate();

            connection.commit();
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