import java.nio.file.*;
import java.io.*;
public class ejer2 {
	enum Option {
		Y,
		N
	}
	
	public static Path askExistingFile(BufferedReader br, String msg) throws IOException{
		while (true) {
				System.out.print(msg);
				Path p = Paths.get(br.readLine());
				if (!Files.exists(p)) return p;
		}
	}
	
	public static Path askDestinationPath(BufferedReader br) throws IOException{
		Option option = null;
		while (true) {
			System.out.print("Ingrese el nombre del fichero destino: ");
			Path p = Paths.get(br.readLine());
			if (!Files.exists(p)) return p;
			else {
				if (askYesNo("¿Desea Sobreescribirlo?", br) == Option.Y);
					return p;
			}
		}
	}
	
	public static Option askYesNo(String msg, BufferedReader br) throws IOException {
		while(true) {
			System.out.print(msg+ " (Y/N):");
			try {
				return Option.valueOf(br.readLine().trim().toUpperCase());
			} 
			catch (IllegalArgumentException error) {
					System.out.println("El valor introducido no es válido.");
				}
			}
	}
	public static void main(String[] args) throws IOException {
		///////////////////////////
		//PARA EL CONTROL DE RUTAS
		
		boolean leave;
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		Option input = null;
		
		//Rutas:
		Path ruta = Paths.get(".",args[0]);
		Path dest = Paths.get("", args[1]);
		
		/////////////////////
		//CONTROL DE RUTAS
		
		//RUTA
		leave = false;
		if (!Files.exists(ruta)) { 
			System.out.println("La ruta: "+ ruta.toAbsolutePath()+ " no existe.");
			while (!leave) {
				try {
					System.out.print("Desea introducir el nombre de un fichero? Y/N: ");
					line = keyboard.readLine();
					input = Option.valueOf(line.trim().toUpperCase());
					leave = true;
				}
				catch (IllegalArgumentException e) {
					System.out.println("El valor introducido no es válido.");
				}
			}
			
		}
		if (input == Option.N) {
			System.out.print("Adiós");
			return;
		}
		
		leave = false;
		if (input == Option.Y) {
			while (!leave) {
				System.out.println("Ingrese el nombre del fichero de entrada:");
				line = keyboard.readLine();	
				dest = Paths.get(line);
				if (!Files.exists(dest)) {
					System.out.println("El fichero no existe.");
				} else { 
					leave = true;
				}
			}
		}
		
		
		//DEST
		leave = false;
		input = null;
		if (Files.exists(dest)) {
			System.out.println("La ruta: " + dest.toAbsolutePath() + " ya existe.");
			while (!leave) {
				try {
					System.out.println("Desea sobreescribir el fichero? Y/N");
					line = keyboard.readLine();
					input = Option.valueOf(line.trim().toUpperCase());
					leave = true;
				}
				catch (IllegalArgumentException e) {
					System.out.println("La opción introducida no existe.");
				}
			}	
		}
		
		if (input == Option.N) {
			leave = false;
			while (!leave) {
				System.out.println("Ingrese el nombre del fichero de entrada:");
				line = keyboard.readLine();	
				dest = Paths.get(line);
				if (Files.exists(dest)) {
					System.out.println("El fichero: " + dest.toAbsolutePath() + " ya existe.");
					try {
						System.out.print("Desea sobreescribirlo? Y/N: ");
						line = keyboard.readLine();
						input = Option.valueOf(line.trim().toUpperCase());
						leave = (Option.Y == input) ? true : false;
					}
					catch(IllegalArgumentException error) {
						System.out.println("Opción introducida no es válida.");					}
				}
				else { 
					leave = true;
				}
			}
		}
		
		System.out.println("Fin del control");
	}
		
}