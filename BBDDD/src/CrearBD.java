
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBD {
    public static void crearBaseDatos() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConexionBD.conectar();
            statement = connection.createStatement();

            String sql = "CREATE DATABASE IF NOT EXISTS PRUEBA";
            statement.executeUpdate(sql);

            System.out.println("BBDD PRUEBA creada con éxito");
        } catch (SQLException e) {
            System.out.println("Error al crear la BBDD: " + e.getMessage());
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
        crearBaseDatos();
    }
}