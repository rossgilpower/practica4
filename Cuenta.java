package practica4;

public class Cuenta{
	
	private int ID;
	private String nombre;
	private double saldo;
	private int pin;
	
	
	public Cuenta(String nombre, double saldo, int pin, int ID) {
		setNombre(nombre);
		setSaldo(saldo);
		setPin(pin);
		setID(ID);
	}
	
	

	//Setters y getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}



	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}

}
