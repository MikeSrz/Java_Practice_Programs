//Funciones creadas por MikeSrz
package toolbox;

import java.math.BigInteger;

public class Maths {
	public static void printMultTables(int n) {
		final int END_OF_MULTIPLICATION = 10;
		for (int i = 0; i <= n; i++) {
			System.out.printf("    TABLA DEL %d%n", i);
			for (int j = 1;j <= END_OF_MULTIPLICATION ;j++) {
				System.out.printf("%3d x %3d = %3d%n", i, j, i * j);
			}
			System.out.println("-".repeat(25));
		}
	}
	
	public static boolean isPrime(int n) {
		boolean result;
		if (n < 4 && n > 1)
			result = true;
		else if (n % 2 == 0 || n == 1)
			result = false;
		else {
			result = true;
			for (int i = 3; i <= Math.sqrt(n); i+=2) {
				if (n%i == 0) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	public static long calcFactorial(int n) {
		if (n == 0)
			return 1;
		return n*calcFactorial(n-1);
	}

	
	public static BigInteger calcFactorial(BigInteger n) {
		if (n.equals(BigInteger.ZERO))
			return BigInteger.ONE;
			
		return n.multiply(calcFactorial(n.subtract(BigInteger.ONE)));
		}
	
	public static long calcFibonacciRecursive(long n) {
		if (n <= 1)
			return n;
		return calcFibonacci(n-1)+calcFibonacci(n-2);
	}
	
	public static long calcFibonacci(long n) {
		long fibonacci = n;
		int number1 = 0;
		int number2 = 0;
		if (n <= 1)
			return fibonacci;
		//Comienzo de fibonacci
		fibonacci = 1;
		int lastNum = 1;
		int penultimate = 0;
		int result;
		//Iteración tantas veces como n.
		for (int i = 2; i < n; i++) {
			if (n == n-1)
				number1 = result;
			if (n == n-2)
				number2 = result;
			
		}
		return lastNum;
	}
	
	public static int maxCommonDiv(int a, int b) {
		if (a%b == 0) 
			//CASO BASE
			return b;
		return maxCommonDiv(b,a%b);
	}
	
	public static double avgResults(int[] freq,int [] values, long n) {
		long sumResults = 0;
		for (int i = 0; i < freq.length; i++) { 
				sumResults+=(freq[i]*values[i]);
		}
		
		return sumResults/n;
	}
	
	public static long calcBinomial(int n, int k) { 
		if (k >= n) 
			//CASO BASE
			return 1;
		return (n*calcBinomial(n-1, k))/
				((n-k));
	}
	
	public static void showMultTables(int end) {
		final int END_OF_MULTIPLICATION = 10;
		for (int i = 0; i <= end; i++) {
			System.out.printf("Tabla del %d%n", i);
			for (int j = 1;j <= END_OF_MULTIPLICATION ;j++) {
				System.out.printf("%3d x %3d = %6d%n", i, j, i * j);
			}
			System.out.println("-".repeat(15));
		}
	}
}
