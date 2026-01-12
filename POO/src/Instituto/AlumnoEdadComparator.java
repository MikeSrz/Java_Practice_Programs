package Instituto;

import java.util.Comparator;


//VAriabilidad de probabilidad
public class AlumnoEdadComparator implements Comparator<Alumno>{

	private static final AlumnoGrupoComparator GRUPO_COMPARATOR=new AlumnoGrupoComparator();
	
	//ORDENA POR EDAD Y LUEGO POR GRUPO
	@Override
	public int compare(Alumno a1, Alumno a2) {
		// TODO Auto-generated method stub
		int edad=a1.getAñoNacimiento() - a2.getAñoNacimiento();
		if (edad!=0)  return edad;
		
//		int grupo=a1.getGrupo().compareToIgnoreCase(a2.getGrupo());
//		if (grupo!=0) return grupo;
		
		int grupo= GRUPO_COMPARATOR.compare(a1,a2);
		if (grupo!=0) return grupo;
		
		return a1.compareTo(a2);
		
	}
	
}

//MOdifiquemos comparador de edad de alumnos -> Personas
//Saco una nueva lista con respecto a la lista de personas pero de alumnos
//ordenar los alumnos por grupo XD
//Crear la clase PROFESOR -> Coon los atributos (String)(id, departamento)
//Modificamos el usa persona para guardar la lista de gentes para una de profesores (String id, String departamento)


//Direccion, nombre del instituto


//En el toString de instituo me mueste el numero total de alumnos de instituto, el numero total de personas, y de profesores.