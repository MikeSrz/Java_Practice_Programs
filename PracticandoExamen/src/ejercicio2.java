import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio2 {
	public static void main(String[] args) throws IOException {
		//////////////////////////
		///PARA LA LECTURA Y ESCRITURA DEL FICHERO:
		BufferedReader br;
		BufferedWriter wr;
		char ch;
		int c;
		String vocals = "aeiou";
		//////////////////////////
		//PARA EL CONTROL DE RUTAS
		Path src = Paths.get("generos.txt");
		Path dst = Paths.get("texto_modificado.txt");
		
		if (!Files.exists(src)) {
			System.out.print("El fichero "+ src.toAbsolutePath()+" no existe.");
			return;
		}
		
		if (Files.exists(dst)) System.out.print("El fichero ya existe, se sobreescribirá...");
		
		//////////////////////
		///LECTURA Y ESCRITURA DEL FICHERO:
		br = new BufferedReader(new FileReader(src.toString()));
		wr = new BufferedWriter (new FileWriter(dst.toString()));
		c = (char)br.read();
		
		System.out.print("Leyendo y Escribiendo en el fichero...");
		c = br.read();
		while (c != -1) {
			ch = (char)c;
			if (vocals.indexOf(ch) >= 0) ch = Character.toUpperCase(ch);
			wr.write(ch);
			c = br.read();
		}
		br.close();
		wr.close();
	}
}
