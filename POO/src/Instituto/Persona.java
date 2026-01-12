package Instituto;

import java.util.Objects;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private String apellidos;
	private int añoNacimiento=2000;
	private static int numPersonas=0;
	
	Persona(){
		this.nombre=Datos.nombre[(int) (Math.random()*Datos.nombre.length)];
		this.apellidos=Datos.apellido[(int) (Math.random()*Datos.apellido.length)];
		this.añoNacimiento=(int) (Math.random()* 61 + 1950);	
		numPersonas++;
	}
	
	Persona(String nombre, String apellidos) throws Exception {
		if (nombre==null || nombre.trim().equals("") || apellidos==null || apellidos.trim().equals("")) {
			throw new Exception("Nombre incorrecto");
		}
		this.nombre=capitalizeFrase(nombre);
		this.apellidos=capitalizeFrase(apellidos);
		numPersonas++;
	}
	
	Persona(String nombre, String apellidos, int añoDeNacimiento) throws Exception {
		this(nombre,apellidos);
		if (añoDeNacimiento<1900)
			throw new Exception("Año de nacimiento incorrecto");
		this.añoNacimiento=añoDeNacimiento;
		numPersonas++;
	}
	
	public static int getNumPersonas() {
		return numPersonas;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getAñoNacimiento() {
		return añoNacimiento;
	}

	public void setAñoNacimiento(int añoNacimiento) {
		this.añoNacimiento = añoNacimiento;
	}

	
	public String toString() {
		return "Persona["+this.nombre+", "+this.apellidos+", "+this.añoNacimiento+"]";
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, añoNacimiento, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && añoNacimiento == other.añoNacimiento
				&& Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public int compareTo(Persona otra) {
		int comp=this.apellidos.compareTo(otra.apellidos);
		if (comp!=0)
				return comp;
		else {
			return this.nombre.compareTo(otra.nombre);
		}
	}

	private String capitalize(String cad) {
		return cad.trim().substring(0, 1).toUpperCase()+cad.trim().substring(1).toLowerCase();
	}
	
	private String capitalizeFrase(String cad) {
		String[] palabras=cad.split("\\s+");
		String res="";
		for (String palabra:palabras) {
			res+=capitalize(palabra)+" ";
		}
		return res.trim();
	}
	
}