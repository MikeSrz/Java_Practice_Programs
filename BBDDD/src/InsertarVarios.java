
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarVarios {
    public static void insertarVariosClientes() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String url = "jdbc:mysql://localhost:3306/prueba";
            connection = DriverManager.getConnection(url, "root", "");

            String sql = "INSERT INTO clientes (nombre, direccion) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Insertar varios registros
            String[][] clientes = {
                {"Juan", "Barcelona"},
                {"Maria", "Valencia"},
                {"Pedro", "Sevilla"}
            };

            for (String[] cliente : clientes) {
                preparedStatement.setString(1, cliente[0]);
                preparedStatement.setString(2, cliente[1]);
                preparedStatement.addBatch();
            }

            int[] resultados = preparedStatement.executeBatch();

            //connection.commit();
            System.out.println(resultados.length + " datos insertados");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
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
        insertarVariosClientes();
    }
}