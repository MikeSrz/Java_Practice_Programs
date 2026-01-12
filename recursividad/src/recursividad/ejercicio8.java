package recursividad;

public class ejercicio8 {

	public static int maxCommonDiv(int a, int b) {
		if (a%b == 0) 
			//CASO BASE
			return b;
		return maxCommonDiv(b,a%b);
	}
	
	public static int maxCommonDivI(int a, int b) {
		int temp = a;
		while (temp%b != 0) {
			temp = a;
			a = b;
			b = temp%b;
			
		}
		return b;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((maxCommonDiv(18,4)));
		System.out.println((maxCommonDivI(150,39)));
	}

}
