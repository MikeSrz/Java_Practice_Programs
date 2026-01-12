package Instituto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UsaAlumno extends Persona{
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno fernando = new Alumno();
		fernando.setNombre("Fernando");
		fernando.setApellido("Ronaldo");
		fernando.setEdadDeNacimiento(2005);
		fernando.setHorario(Horario.TARDE);
		Alumno paqui = new Alumno();
		//Con el método toString se puede hacer que un objeto se escriba a sí mismo.
		System.out.println(fernando);
		System.out.println(paqui);
		Alumno mariloli = new Alumno();
		mariloli.setNombre("Fernando");
		mariloli.setApellido("Fernando");
	
		
		if (fernando.equals(paqui)) {
			System.out.println("Son iguales");
		}
		else {
			System.out.println("No lo son. (iguales)");
		}
		
		ArrayList<Alumno> alumnos = new ArrayList<>();
		for (int i = 0; i <= 10 - 1; i++) {
			alumnos.add(new Alumno());
		}
		
		System.out.println("Alumnos generados");
		
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.toString());
		}
		System.out.println("holaaaaaaaaaaaaaa");
		
		//Quiero comparar alumnos por nombre, apellido, edad y grupo.
		Collections.sort(alumnos, new ComparaAlumnosNombre());
		System.out.println(alumnos);
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.toString());
		}
		
	}

		
}
