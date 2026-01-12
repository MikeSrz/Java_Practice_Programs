import java.nio.file.*;
import java.io.*;


	
public class ejer1 {
	enum Option {
		Y,
		N
	}
	public static boolean isPrime(int n) {
		boolean result;
		if (n < 4 && n > 1)
			result = true;
		else if (n % 2 == 0 || n == 1)
			result = false;
		else {
			result = true;
			for (int i = 3; i <= Math.sqrt(n); i+=2) {
				if (n%i == 0) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		
		//PARA EL CONTROL DE LA RUTA
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		Option option = null;
		String line = null;
		boolean leave = false;
		
		//PARA LA ESCRITURA EN EL FICHERO
		BufferedWriter writer;
		int counter;
		
		//CONTROL DE LA RUTA
		Path ruta = Paths.get(".", args[0]);
		if (Files.exists(ruta)) 
			while (!leave) {
				System.out.print("El archivo " + ruta.toAbsolutePath() + " ya existe.\nDesea sobreescribirlo? Y/N: ");
				line = keyboard.readLine().trim().toUpperCase();
				try {
					option = Option.valueOf(line);
					leave = true;
				}
				catch(IllegalArgumentException error) {
					System.out.println("Elija una opción correcta.");
				}
			}
			
		if (option == Option.N) {
			System.out.println("La operación fue cancelada, fin de programa");
			return;
		}
		
		//ESCRITURA DEL FICHERO
		writer = new BufferedWriter(new FileWriter(ruta.toString()));
		leave = false;
		try {
			int i = 1;
			counter = 0;
			while (!leave) {
				if (isPrime(i)) {
					System.out.println(i + " es primo.");
					writer.write("Este número que es primo: "+i);
					writer.newLine();
					counter++;
				}

				if (counter == 100) {
					leave = true;
				}
				i++;
			}
		}
		catch (IOException error) {
			System.out.println("Hubo un error en la escritura del fichero.");
		}
		writer.close();
	}

}

