
public class useEmpleado {
	public static void main(String[] args) {
		
		Empleado e1 = new Empleado(	new Nif(26267103, 'E'),
									2222.19f,	// Sueldo Base
									12.2f,		// Pago por horaextra
									10,			// cantHoraExtra mensual
									0.2f,		// pcjIRPF
									true,		// Casado o no
									2);			// num Hijos

		System.out.println(e1.calcRetencion());
	}
}
