package Instituto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UsaPersona {
	
	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println(Alumno.getNumPersonas());
//		Alumno fernando=new Alumno("Fernando","Portales",2005,"2ASIR");
//		System.out.println(fernando.getNombre());
//		
//		
//		Alumno paqui=new Alumno("Francisca","Rodriguez",2010,"2ASIR");
//		
//		Alumno johndoe=new Alumno();
//		
//		System.out.println(fernando);
//		System.out.println(paqui);
//		System.out.println(johndoe);
//		Alumno fernandoClon=new Alumno("Fernando","Portales",2005,"2ASIR");
//		System.out.println(fernandoClon);
//		Alumno mariloli;
//		mariloli=fernando;
//		
//		if (fernando.equals("fernando"))
//			System.out.println("Fernando y su clon son iguales");
//		else
//			System.out.println("Fernando y su clon NO son iguales");
//		
		List<Persona> genteIES=new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			if (Math.random()<0.5)
				genteIES.add(new Alumno());
			else
				genteIES.add(new Persona());
			//System.out.println(new Alumno());
		}
		
		
		
		
		for (Persona p : genteIES) {
			System.out.println(p);
		}
		
		Persona masViejo=genteIES.get(0);
		Persona masJoven=genteIES.get(0);
		for (Persona p : genteIES) {
			if (p.getAñoNacimiento()<masViejo.getAñoNacimiento())
				masViejo=p;
			if (p.getAñoNacimiento()>masJoven.getAñoNacimiento())
				masJoven=p;
		}
		
		System.out.printf("Alumno más Viejo: %s%n",masViejo);
		System.out.printf("Alumno más Joven: %s%n",masJoven);
		
		System.out.println("=".repeat(80));
		System.out.println("COLECCIÓN ORDENADA - ORDEN NATURAL");
		System.out.println("=".repeat(80));
		Collections.sort(genteIES);
		for (Persona p : genteIES) {
			System.out.println(p);
		}
		
		
		System.out.println("COLECCION DE ALUMNOS, PROFESORES Y solo personas");
		Set<Alumno> listaAlumno = new TreeSet<>();
		Set<Profesor> listaProfesor= new TreeSet<>();
		Set<Persona> listaPersona = new TreeSet<>();
		for (Persona p : genteIES) {
			if (p instanceof Alumno)
				listaAlumno.add((Alumno)p);
			else if (p instanceof Profesor)
				listaProfesor.add((Profesor)p);
			else 
				listaPersona.add(p);
		}
		
		
//		System.out.println("=".repeat(80));
//		System.out.println("COLECCIÓN ORDENADA - ORDEN GRUPO");
//		System.out.println("=".repeat(80));
//		AlumnoGrupoComparator compGrupo=new AlumnoGrupoComparator();
//		Collections.sort(genteIES,compGrupo);
//		for (Alumno alumno : genteIES) {
//			System.out.println(alumno);
//		}
//		
//		System.out.println("=".repeat(80));
//		System.out.println("COLECCIÓN ORDENADA - ORDEN EDAD, GRUPO, NATURAL");
//		System.out.println("=".repeat(80));
//		AlumnoEdadComparator compEdad=new AlumnoEdadComparator();
//		Collections.sort(genteIES,compEdad);
//		for (Alumno alumno : genteIES) {
//			System.out.println(alumno);
//		}
		System.out.println(Alumno.getNumPersonas());
	}

}
