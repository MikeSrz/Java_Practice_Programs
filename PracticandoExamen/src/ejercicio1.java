import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class ejercicio1 {
	public static int findMax(List<Integer> cantidades) {
		int max = cantidades.get(0);
		for (int n : cantidades) {
			if (n > max)
				max = n;
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException{	
		
		/////////////////////////////
		//MANEJANDO RUTA DE FICHERO
		String fileName = args[0]; 
		System.out.println(fileName);
		Path ruta = Paths.get(".",fileName);
		
		if (!Files.exists(ruta)) {
			throw new FileNotFoundException("No existe el fichero: " + ruta.toAbsolutePath());
		}
		
		////////////////////
		//PROCESANDO TEXTO
		List<String> nombres = new ArrayList<>();
		List<Integer> cantidades = new ArrayList<>();
		List<Float> precios = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(ruta.toString()));
		String line = reader.readLine();
		while (line != null) {
			for (int i = 1; i < line.split(",").length; i++)
				switch (i) {
					case 1 -> nombres.add(line.split(",")[i]);
					case 2 -> cantidades.add(Integer.parseInt(line.split(",")[i]));
					case 3 -> precios.add(Float.parseFloat(line.split(",")[i]));
				}	
				
			line = reader.readLine();
		}
		
		
		int maximo = findMax(cantidades);
		for (int i = 0; i < cantidades.size(); i++) {
			if (cantidades.get(i) == maximo){
				System.out.print("El que más copias tiene es: " + nombres.get(i) + " | " + maximo +  " copias"); 
			}
		}
		
		
		
	}
}
