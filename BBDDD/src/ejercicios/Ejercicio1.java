package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



public class Ejercicio1 {

	public static void gameLoop(Map<String, ArrayList> capitalesPoblacion) throws IOException {
		//////////////////////////////////////////////////77
		///JUEGO DE LAS CAPITALES

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String input;
		final String TITLE =  "EL JUEGO DE LAS CAPITALES";
		System.out.println(TITLE);
		System.out.println("-".repeat(TITLE.length()));
		List<String> paises = new ArrayList<>(capitalesPoblacion.keySet());
		Random rand =  new Random();
		String paisRandom;
		String capital;
		int poblacion;
		while (true) {

			paisRandom = paises.get(rand.nextInt(paises.size()));
			capital = (String) capitalesPoblacion.get(paisRandom).get(0);
			poblacion = (int) capitalesPoblacion.get(paisRandom).get(1);
			System.out.printf("A qué pais pertenece %s  (Pulsa 'Q' para salir):", capital);
			input = keyboard.readLine().toUpperCase();

			if (input.equals("Q")) {
				System.out.println("Adiós");
				break;
			}
			else if(input.equals(paisRandom.toUpperCase())) {
				System.out.println("¡Hacertaste!");
				System.out.printf("%s tiene una población de %d personas.\n", paisRandom, poblacion );
			}
			else {
				System.out.printf("Has fallado... Era %s. \n", paisRandom);
			}

		}
	}
	public static void main(String[] args) throws SQLException, IOException {
		/////////////////////////////////////////////////////
		//Estableciendo una conexión con la BD
		Connection connection = ConexionDB.conectar();
		Statement statement = connection.createStatement();
		ResultSet resultado;

		//Ejercicio 1.a
		String sql = "SELECT C.Name, CI.Name, C.Population "
				+ "FROM COUNTRY AS C "
				+ "JOIN CITY AS CI "
				+ "ON C.Capital = CI.ID";

		resultado = statement.executeQuery(sql);

		String pais;
		String ciudad;
		int poblacion;
		while (resultado.next()) {
			pais = resultado.getString("C.Name");
			ciudad = resultado.getString("CI.Name");
			poblacion = resultado.getInt("Population");
			System.out.println(pais + "-" + ciudad + "-" + poblacion);
		}
		resultado.close();

		/*Ejercicio 1.b*/
		Map<String, ArrayList> capitalesPoblacion = new HashMap<>();
		resultado = statement.executeQuery(sql);
		while(resultado.next()) {
			ArrayList<Object> lista = new ArrayList<>();
			pais = resultado.getString("C.Name");
			lista.add(resultado.getString("CI.Name"));
			lista.add(resultado.getInt("Population"));
			capitalesPoblacion.put(pais, lista);
		}
		resultado.close();
		System.out.println(capitalesPoblacion);

		gameLoop(capitalesPoblacion);
	}

}
