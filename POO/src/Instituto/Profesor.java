package Instituto;

import java.util.Random;

public class Profesor extends Persona{
	String id;
	String departamento;
	
	Profesor(){
		super();
		Random random = new Random();
		this.departamento = Datos.departamento[random.nextInt(0, Datos.departamento.length)];
		this.id = hash();
	}
	Profesor(String nombre, String apellidos, int añoNac, String departamento) throws Exception{
		super(nombre, apellidos, añoNac);
		this.departamento = departamento;
		this.id = hash();
	}
	
	private static String hash() {
		//Preguntar cómo se hacía esta función, de momento pongo eso:
		return String.valueOf(0);
	}
	
}
