import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ejercicio3 {
	public static void main(String[] args) throws IOException{
		//////////////////////////////////////
		///PARA LECTURA Y RECOPILACIÓN DE DATOS
		Map<String , Integer> estadistica = new HashMap<>();
		Map<String, Integer> frecuencias = new HashMap<>();
		int acLongPalabras;
		int c;
		char ch;

		///////////////////////////
		///PARA EL CONTROL DE RUTAS
		Path src = Paths.get("peliculas.txt");
		Path dst = Paths.get("Estadística.txt");
		if (!Files.exists(src)) {
			System.out.print("El fichero " + src.toAbsolutePath() + " no existe.");
			return;
		}
		if (Files.exists(dst)) System.out.println("El fichero" + dst.toAbsolutePath() + " ya existe así que se sobreescribirá.");
		
		///////////////////////////////////////////////
		/// L
		BufferedReader br = new BufferedReader(new FileReader(src.toString()));
		estadistica.put("Contador Caracteres", 0);
		estadistica.put("Contador de Palabras", 0);
		estadistica.put("Contador Lineas", 0);
		acLongPalabras = 0;
		c = br.read();
		while (c != -1) {
			ch = (char)c;
			estadistica.put("Contador Caracteres", estadistica.get("Contador Caracteres")+1);
			
			if (ch == '\n') {
				estadistica.put("Contador Lineas", estadistica.get("Contador Lineas")+1);
				estadistica.put("Contador de Palabras", estadistica.get("Contador de Palabras")+1);
			}
			else if (ch == ' ') 
				estadistica.put("Contador de Palabras", estadistica.get("Contador de Palabras")+1);
			c = br.read();	
		}
		
		int promedio = (estadistica.get("Contador Caracteres") - estadistica.get("Contador de Palabras"))/estadistica.get("Contador de Palabras");
		
		estadistica.put("Promedio Longitud Palabra",promedio);
		
		br.close();
		
		
		//Para ordenar
		
		Map<String, Integer> ordenado = new TreeMap<>(estadistica);
		
		

		System.out.print(ordenado);
	}
}
