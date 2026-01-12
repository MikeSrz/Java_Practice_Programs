import java.util.ArrayList;
import java.util.Collections;

public class useRational {
	public static void main(String[] args) {
		ArrayList<Rational> numeros = new ArrayList<>();
		for (int i=0; i< 100; i++) {
			numeros.add(new Rational());
		}
		
		Collections.sort(numeros);
		for (Rational numero : numeros) {
			System.out.println(numero);
		}
	}
}
