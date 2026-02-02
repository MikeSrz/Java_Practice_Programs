import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ejercicio4 {

	public static void main(String[] args) throws IOException {
		///////////////////////////////
		///PARA RECORRER FICHERO Y ESCRIBIR
		List<String> listaCortas;
		String line;
		String specialChars = ".,-'¡1234567890º+ç*#@|~$&/()=?¿^[]{};:_";

		/////////////////////////////
		///MANEJO DE RUTAS
		Path src = Paths.get("Palabras_cortas.txt");
		Path dst = Paths.get("Palabras_largas.txt");
		
		if (!Files.exists(src)) {
			System.out.println("El archivo "+src.toAbsolutePath()+"no existe.");
			return;
		}
		
		if (Files.exists(dst)) {
			System.out.println("El archivo " + dst.toAbsolutePath()+" ya existe, se sobreescribirá.");
		}
		
		///////////////////////////
		///RECORRIENDO FICHERO Y ESCRIBIENDO.
		listaCortas = new ArrayList<>();
		BufferedReader br =  new BufferedReader(new FileReader(src.toString()));
		BufferedWriter wr = new BufferedWriter(new FileWriter(dst.toString()));
		Map<String, Integer> estadistica = new HashMap<>();
		estadistica.put("Contador Palabras Largas", 0);
		line = br.readLine();
		while (line != null) {
			for (char c : specialChars.toCharArray()) {
				line = line.replace(String.valueOf(c), "");
			}
			for(String word : line.split(" ")) {
				if (word.length() > 5) {
					wr.write(word);
					wr.newLine();
					estadistica.put("Contador Palabras Largas",estadistica.get("Contador Palabras Largas")+1);
				}
				else {
					listaCortas.add(word);
				}
			}
			line = br.readLine();
		}
		
		estadistica.put("Contador Palabras Cortas", listaCortas.size());
		wr.close();
		wr = new BufferedWriter(new FileWriter(src.toString()));
		for (String word : listaCortas) {
			wr.write(word);
			wr.newLine();
		}
		wr.close();
		br.close();
		
		
	}

}
