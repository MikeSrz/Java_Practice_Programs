import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mysqlTexto {
    public static void main(String[] args) {
        // Parámetros de conexión a la base de datos
        String url = "jdbc:mysql://localhost/world?useUnicode=yes&characterEncoding=latin1&collation=utf-8";
        String username = "root";
        String password = "";

        try {
            // Conectar a la base de datos
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosa a la base de datos");

            // Crear un statement
            Statement statement = connection.createStatement();

            // Ejecutar una consulta SQL para obtener los registros de la tabla `city`
            ResultSet resultSet = statement.executeQuery("SELECT * FROM city where countrycode='ESP' order by name");

            // Iterar sobre los resultados y mostrarlos
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String countryCode = resultSet.getString("CountryCode");
                String district = resultSet.getString("District");
                int population = resultSet.getInt("Population");

                System.out.println("ID: " + id + ", Nombre: " + name + ", Código de País: " + countryCode + ", Distrito: " + district + ", Población: " + population);
            }

            // Cerrar la conexión
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
