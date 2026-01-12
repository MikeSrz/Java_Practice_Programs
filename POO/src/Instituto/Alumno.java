package Instituto;

import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
enum Horario {MAÑANA, TARDE};

//DE MOMENTO NO TIENE ORDEN NATURAL
public class Alumno extends Persona{
	 private String grupo;
	 private Horario horario=Horario.MAÑANA;
	 
	Alumno(){
		super();
		Random nr = new Random();
		this.grupo= Datos.grupo[nr.nextInt(0, Datos.grupo.length)];
    	super.setAñoNacimiento(nr.nextInt(1982, 2010));
    	
	}
	
	public Alumno(String nombre, String apellidos, int añoNacimiento, String grupo) throws Exception {
		super(nombre, apellidos, añoNacimiento);
		this.grupo = grupo;
	}

	public Alumno(String nombre, String apellidos, int añoNacimiento, String grupo, Horario horario) throws Exception {
		super(nombre, apellidos, añoNacimiento);
		this.grupo = grupo;
		this.horario = horario;
	}

	public String getGrupo() {
		return grupo;
	}
	
	

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public Horario getHorario() {
		return horario;
	}


	public void setHorario(Horario horario) {
		this.horario = horario;
	}


	@Override
	public String toString() {
		return String.format(
				"Alumno [%s, %s, %d, %s, %s]",
				getNombre(), getApellidos(), getAñoNacimiento(), grupo, horario);
	}

}