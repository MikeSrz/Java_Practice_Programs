import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:7777/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la BBDD");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la BBDD: " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        conectar();

    }
}