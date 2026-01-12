package toolbox;

import java.util.Random;

public class Algorith {
	public static int reverseNumber(int number) {
		int invertedNumber = 0;
		while (number != 0) {
		invertedNumber = (invertedNumber*10) + (number % 10);
		number = number/10;
	}
	return invertedNumber;
	}
	public static boolean arrayContains(int vct[], int number) {
		for (int n : vct) {
			if (number == n)
				return true;
		}
		return false;
	}
	
	public static int[] reverseArray(int[] mtrx) {
		int reversedAr[] = new int[mtrx.length];
		int len = mtrx.length;
		int limit = len/2;
		for (int i = 0; i <= limit;i++) {
			reversedAr[i] = mtrx[len-i-1];
			reversedAr[len-i-1] = mtrx[i];
		}
		return reversedAr;
	}
	
	public static void randomizeArray(int vct[], int limit) {
		//Recordemos que se pasa por referencia, 
		//así que con poner void nos basta para editar el array original.
		Random rand = new Random();
		int ranNumber;
		for (int i = 0; i < vct.length; i++) {
			do {
				ranNumber = rand.nextInt(1,limit);
			}while(arrayContains(vct, ranNumber));

			vct[i] = ranNumber;
		}
	}
	
	public static int  countDigits(int number) {
		if (number < 10)
			return number;
		return number%10+countDigits(number/10);
	}
	public static int throwDices(int times) {
		Random ran = new Random();
		int ac = 0;
		int dice;
		for (int i = 0; i < times; i++) {
			dice = ran.nextInt(1,7);
			ac = ac + dice;
		}
		return ac;		
	}
	
	public static boolean arrayBinarySearch(int vct[], int number) {
		int low = 0;
		int high = vct.length -1;
		int mid;
		int estimated;
		while (low <= high) {
			mid = (int)((low+high)/2);
			estimated = vct[mid];
			if (estimated == number) {
				return true;
			}
			else if (estimated > number)
				high = mid - 1;
			else {
				low = mid + 1;
			}
		}
		return false;
	}
	
	public static int findMax(int[]vct) {
		int max = vct[0];
		for (int n : vct) {
			if (n > max)
				max = n;
		}
		return max;
	}
	
}
