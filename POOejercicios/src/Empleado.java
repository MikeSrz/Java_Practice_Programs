
public class Empleado {
	private Nif nif;
	private float sueldoBase;
	private float pagoHoraExtra;
	private int horasExtraMensual;
	private float irpf = 0.2f;
	private boolean casado;
	private int numeroHijos;
	
	//Constructor sin Dni
	Empleado(Nif dni, float sBase, float pagoHoraEx, int cantHorasExMensual, float tipo, boolean desposado, int numHijos){
		this.nif = null;
		this.sueldoBase = sBase;
		this.pagoHoraExtra = pagoHoraEx;
		this.horasExtraMensual = cantHorasExMensual;
		this.irpf = tipo;
		this.casado = desposado;
		this.numeroHijos = numHijos;
	}
	
	//Métodos
	
	public float calcSueldoHorasExtra() {
		return this.horasExtraMensual*pagoHoraExtra;
	}
	
	public float calcSueldoBruto() {
		return this.sueldoBase + this.calcSueldoHorasExtra();
	}
	
	public float calcRetencion() {
		float pcjRetencion = this.irpf;
		if (this.casado) {
			pcjRetencion -= 0.02;
		}
		pcjRetencion -= numeroHijos/100;
		return (1-pcjRetencion)*this.calcSueldoBruto();
	}
	
	public Empleado copia() {
		return new Empleado(this.nif, this.sueldoBase, this.pagoHoraExtra, this.horasExtraMensual, this.irpf, this.casado, this.numeroHijos);
	}
	//getters y setters
	public Nif getNif(){
		return nif;
	}
	public void setNif(Nif dni) {
		this.nif = dni;
	}
	public float getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	public float getPagoHoraExtra() {
		return pagoHoraExtra;
	}
	public void setPagoHoraExtra(float pagoHoraExtra) {
		this.pagoHoraExtra = pagoHoraExtra;
	}
	public float getHorasExtraMensual() {
		return horasExtraMensual;
	}

	public void setHorasExtraMensual(int horasExtraMensual) {
		this.horasExtraMensual = horasExtraMensual;
	}
	public float getIrpf() {
		return irpf;
	}
	public void setIrpf(float irpf) {
		this.irpf = irpf;
	}
	public boolean isCasado() {
		return casado;
	}
	public void setCasado(boolean casado) {
		this.casado = casado;
	}
	public int getNumeroHijos() {
		return numeroHijos;
	}
	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}
	
	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empleado [");
		if (nif != null) {
			builder.append("nif=");
			builder.append(nif);
			builder.append(", ");
		}
		builder.append("sueldoBase=");
		builder.append(sueldoBase);
		builder.append(", pagoHoraExtra=");
		builder.append(pagoHoraExtra);
		builder.append(", horasExtraMensual=");
		builder.append(horasExtraMensual);
		builder.append(", irpf=");
		builder.append(irpf);
		builder.append(", casado=");
		builder.append(casado);
		builder.append(", numeroHijos=");
		builder.append(numeroHijos);
		builder.append("]");
		return builder.toString();
	}
	
}
