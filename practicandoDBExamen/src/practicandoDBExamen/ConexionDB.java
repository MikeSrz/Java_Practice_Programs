package practicandoDBExamen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	private static final String URL = "jdbc:mysql://localhost:7777/world";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static Connection conectar() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Se conectó correctamente a la base de datos " + URL.split(":")[3].substring(5));
		} catch (SQLException e) {
			System.out.println("No se pudo conectar: " + e);
		}
		return connection;
	}
	public static void main(String[] args) {
		Connection conexion;
		conexion = conectar();
	}
}
