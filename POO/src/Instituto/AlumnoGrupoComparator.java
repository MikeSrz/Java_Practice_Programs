package Instituto;

import java.util.Comparator;

public class AlumnoGrupoComparator implements Comparator<Alumno> {

	@Override
	public int compare(Alumno a1, Alumno a2) {
		// TODO Auto-generated method stub
		int gr=a1.getGrupo().compareToIgnoreCase(a2.getGrupo());
		if (gr==0)
			return a1.compareTo(a2);
		else
			return gr;
	}

}
