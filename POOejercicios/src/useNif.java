
public class useNif {
	
	public static void main(String[] args) {
		Nif vacio = new Nif();
		System.out.println(vacio.leer());
		
		Nif miNif = new Nif(66677788);
		System.out.println(miNif.leer());
		
	}
}
