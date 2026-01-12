package Instituto;

import java.util.Comparator;

public class PersonaEdadComparator implements Comparator <Persona>{
	@Override
	public int compare(Persona p1, Persona p2) {
		// TODO Auto-generated method stub
		int edad=p1.getAñoNacimiento() - p2.getAñoNacimiento();
		if (edad!=0)  return edad;
		
		return edad;
	}
}
