/*
 CLASE QUE IMPLEMENTA EL TIPO DE DATO RACIONAL, UNA FRACCION CON NUMERADOR Y DENOMINADOR
 QUE SE GUARDA SIEMPRE DE FORMA CANÓNICA, SE IMPLEMENTAN LAS OPEARCIONES SUMA, RESTA, MULTIPLICACION Y DIVISION.
 SE PROPORCIONAN OPCIONES DE FORMATEO DE SALIDA PARA EL NUEVO TIPO.
 
 POR IMPLEMENTAR:
 	COMPARETO 
 	EQUALS => TODOUBLE Y COMPARAMOS COMO DOS DOUBLES
 	Constructor de numeros aleatorios; num entre 99, -99
 									    den entre 99, 0
 									  DADME VUESTRAS TARJETAS DE CREDITO
 
 */

import java.util.Random;

public class Rational implements Comparable <Rational>{
	private int numerator;
	private int denominator;
	
	Rational() {
		Random rand = new Random();
		this.numerator = rand.nextInt(-99,100);
		this.denominator = rand.nextInt(1,100);
		
		if (this.denominator < 0) {
			this.numerator*=-1;
			this.denominator*=-1;
		}
	}
	
	Rational(int numerator, int denominator) {
		//MCD
		if (denominator == 0) {
			throw new IllegalArgumentException("El denominador no puede ser 0");
		}
		int mcd;
		mcd = maxCommonDiv(numerator,denominator);
		this.numerator = numerator/mcd;
		this.denominator = denominator/mcd;
	}
	
	private static int maxCommonDiv(int n, int d) {
		if (n%d == 0) 
			//CASO BASE
			return d;
		return maxCommonDiv(n,n%d);
	}
	
	public Rational add(Rational r1) {
		int denominator = this.denominator*r1.denominator;
		int numerator = (denominator*r1.numerator+denominator*this.numerator);
		Rational sum = new Rational(numerator, denominator);
		return sum;
	}
	
	public Rational subs(Rational r1) {
		int denominator = this.denominator*r1.denominator;
		int numerator = (denominator*r1.numerator-denominator*this.denominator);
		Rational sub = new Rational(numerator, denominator);
		return sub;
	}
	
	public Rational divide(Rational r1) {
		int denominator = this.denominator*r1.numerator;
		int numerator = r1.denominator * this.numerator;
		Rational total = new Rational(numerator, denominator);
		return total;
	}
	
	public Rational multiply(Rational r1) {
		int denominator = this.denominator*r1.denominator;
		int numerator = r1.numerator* this.numerator;
		Rational total = new Rational(numerator, denominator);
		return total;
	}
	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	@Override
	public String toString() {
		return String.format("Rational [%s/%s]", numerator, denominator);
	}
	
	public double toDouble() {
		return (double) this.numerator / this.denominator;
	}
	
	@Override
	public int compareTo(Rational r1) {
		return Double.compare(this.toDouble(), r1.toDouble());
	}
}
