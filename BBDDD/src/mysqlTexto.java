import java.sql.Connection;
import java.sql.DriverManager;

public class mysqlTexto {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/world";
		String username = "root";
		String password = "";
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("Hubo un error");
		}
	}
}
