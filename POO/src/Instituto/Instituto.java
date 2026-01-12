package Instituto;

import java.util.Set;
import java.util.TreeSet;

public class Instituto {
	private String nombre;
	private String direccion;
	static Set<Alumno> alumnos = new TreeSet<>();
	static Set<Profesor> profesores = new TreeSet<>();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	private static int cantAlumnos() {
		return 0;
	}
	
	private static int cantProfesores() {
		return 0;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Instituto [");
		if (nombre != null) {
			builder.append("nombre=");
			builder.append(nombre);
			builder.append(", ");
		}
		if (direccion != null) {
			builder.append("direccion=");
			builder.append(direccion);
			builder.append(", ");
		}
		builder.append("Cantidad de Alumnos");
		builder.append(alumnos.size());
		builder.append(", ");
		builder.append("Cantidad de Profesores");
		builder.append(profesores.size());
		builder.append("]");
		return builder.toString();
	}
	
	
}
