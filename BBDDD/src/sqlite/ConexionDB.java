package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	private static final String URL = "jdbc:sqlite:prueba.db";

	public static Connection conectar() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL);
			System.out.println("Se conectó correctamente a "+URL);
		}
		catch (SQLException e) {
			System.out.println("[ERROR] No se pudo conectar: "+e);
		}
		return connection;
	}

	public static void main (String[] args) {
		conectar();
	}
}