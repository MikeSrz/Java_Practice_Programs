import java.util.HashMap;
import java.util.Map;

public class Nif {
	private long numero;
	private char letra;
	static String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	Nif() {
		this.letra = ' ';
		this.numero = 0;
	}
	
	Nif(long num) {
		if (8 >= countDigits(num)) {
			this.letra = obtenerLetra(num);
			this.numero = num;
		} else {
			throw new IllegalArgumentException("El dni no cumple la longitud");
		}
	}
	
	Nif(long num, char letra){
		if (8 < countDigits(num)) {
			throw new IllegalArgumentException("El dni no cumple la longitud");
		}
		if (esNif(num, letra)){
			throw new IllegalArgumentException("El dni no es valido");
		} else {
			this.letra = obtenerLetra(num);
			this.numero = num;
		}
		
	}
	Nif (String dni) {
		int numero = Integer.parseInt(dni.substring(0,8));
		char letra = dni.charAt(8);
		if (8 < countDigits(numero)) {
			throw new IllegalArgumentException("El dni no cumple la longitud");
		}
		if (esNif(numero, letra)){
			throw new IllegalArgumentException("El dni no es valido");
		} else {
			this.letra = obtenerLetra(numero);
			this.numero = numero;
		}
	}
	
	private static boolean esNif(long num, char let) {
		if (let == obtenerLetra(num))
			return true;
		else 
			return false;
	}
	
	private static char obtenerLetra(long n) {
		return Nif.letras.charAt((int)n%23);
	}
	
	public static int countDigits(long num) {
		if (num < 10)
			return (int) num;
		return (int) (num%10+countDigits(num/10));
	}
	
	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	public String leer() {
		return String.format("%08d-%s", numero, letra);
	}
	
}
