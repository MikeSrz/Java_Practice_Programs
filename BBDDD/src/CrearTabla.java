
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
    public static void crearTablaClientes() {
        Connection connection = null;
        Statement statement = null;

        try {
            // Conectar a la base de datos específica
            String url = "jdbc:mysql://localhost:7777/prueba";
            connection = DriverManager.getConnection(url, "root", "");
            statement = connection.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS clientes (" +
                         "cliente_id INT AUTO_INCREMENT PRIMARY KEY," +
                         "nombre VARCHAR(255)," +
                         "direccion VARCHAR(255)" +
                         ")";

            statement.executeUpdate(sql);
            System.out.println("Tabla clientes creada correctamente");
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