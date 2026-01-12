package Instituto2;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Persona {
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [");
		if (dni != null) {
			builder.append("dni=");
			builder.append(dni);
			builder.append(", ");
		}
		if (nombre != null) {
			builder.append("nombre=");
			builder.append(nombre);
			builder.append(", ");
		}
		if (fechaNacimiento != null) {
			builder.append("fechaNacimiento=");
			builder.append(fechaNacimiento);
		}
		builder.append("]");
		return builder.toString();
	}

	Persona(){
		try {
			Path ruta = Path.of(".","Datos_CSV_exportables","E1_Persona.csv");
			String dniAleatorio;
			String nombreAleatorio;
			LocalDate fechaAleatoria;
			
			Random rand = new Random();
			Set<String> dnis = new HashSet<>();
			Set<String> nombres = new HashSet<>();
			BufferedReader fileReader = new BufferedReader(new FileReader(ruta.toFile()));
			String line = fileReader.readLine();
			while(line != null) {
				dnis.add(line.split(",")[0]);
				nombres.add(line.split(",")[1]);
			}
			this.dni = (String) dnis.toArray()[rand.nextInt(dnis.size())];
			this.nombre = (String) nombres.toArray()[rand.nextInt(nombres.size())];
			
			//La función de fecha Random recibe el rango de fechas.
			this.fechaNacimiento = buildRandomDate(LocalDate.of(1956, 1,1), LocalDate.of(2013, 1,1)); 
		} catch (IOException error) {
			System.out.println("Hubo un problema leyendo el fichero.");
		}
	}
	
	Persona(String dni, String nombre, LocalDate fechaNacimiento){
		if (fechaNacimiento == null) 
			throw new IllegalArgumentException("La fecha de nacimiento no puede ser Null");
		
		if (dni.length() != 9 ) 
			throw new IllegalArgumentException("El dni " + dni + "no tiene una longitud válida.");
		try {
			this.dni = dni;
			this.nombre = nombre;
			this.fechaNacimiento = fechaNacimiento;
		} catch (Exception error) {
			System.out.println("El tipado de alguno de los argumentos no es válido");
		}
	}
	
	private static LocalDate buildRandomDate(LocalDate min, LocalDate max) {
		if (min == null || max == null) {
			System.out.println("[ERROR] Las fechas no pueden ser null.");
		    return null;
		 }

		if (min.isAfter(max)) {
			System.out.println("[ERROR] La fecha mínima no puede ser mayor que la máxima.");
			return null;
		}
		    
		Random rnd = new Random();

		// a días
		long minDay = min.toEpochDay();
		long maxDay = max.toEpochDay();

		long randomDay = minDay + rnd.nextInt((int)(maxDay - minDay + 1)); //Le sumo tanto(aleatorio) al día minimo

		return LocalDate.ofEpochDay(randomDay);
	}
}
	


