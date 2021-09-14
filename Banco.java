package practica4;

import java.util.Random;

public class Banco {

	public static Cuenta[] crearCuenta(int i, Cuenta cuentasExistentes[]) {
		
		System.out.println();
		if(i<cuentasExistentes.length) {
			System.out.println();
			String usuario = Capture.capturarString(">> Ingrese su nombre");
			int pin = Integer.parseInt(Capture.capturarString(">> Ingrese su PIN"));
			double saldo = Double.parseDouble(Capture.capturarString(">> Ingrese su saldo"));
			Random aleatorio = new Random(System.currentTimeMillis());
			int ID = aleatorio.nextInt(10000);
			aleatorio.setSeed(System.currentTimeMillis());
			Cuenta cuenta = new Cuenta(usuario, saldo, pin,ID);
			cuentasExistentes[i] = cuenta;
			System.out.println("\n\t>> SU ID CREADO ES: "+cuenta.getID());

			System.out.println("\t>>¡Cuenta creada con éxito!");
		}
		else {System.out.println("\n\t>> No existen espacios para cuentas nuevas. Pruebe más tarde.");}
		
		return cuentasExistentes;
	}
	
	public static String accederCuenta(int ID, int pin, Cuenta cuentasExistentes[]) {
		for(int i=0; i<cuentasExistentes.length;) {
			if(cuentasExistentes[i].getID() == ID && cuentasExistentes[i].getPin()==pin){
				sesionIniciada(cuentasExistentes,cuentasExistentes[i].getNombre(),pin,cuentasExistentes[i].getSaldo(),cuentasExistentes[i].getID());
				break;
			}
			else {
				System.out.println("\n\t>> Cuenta inexistente o credenciales inválidas. Pruebe de nuevo.");
				break;
			}
		}
		return null;
	}
	
	
	public static String sesionIniciada(Cuenta cuentasExistentes[], String nom, int pin, double saldo,int ID) {
		Cuenta cuenta = new Cuenta(nom,saldo,pin,ID);
		System.out.println();
		System.out.println("----| Menú |----");
		System.out.println("1. Retiro de efectivo");
		System.out.println("2. Depósito de efectivo");
		System.out.println("3. Cerrar sesión");
		
		int opc = Capture.capturarEntero(">> Su elección");
		switch(opc) {
			case 1:
				double dineroRetirado = Capture.capturarDoble("\t>> Ingrese el dinero a retirar");
				if(dineroRetirado>cuenta.getSaldo()) {
					System.out.println("Saldo insuficiente. Pruebe de nuevo.");
				}
				else {
					double saldoFinal = cuenta.getSaldo()-dineroRetirado;
					cuenta.setSaldo(saldoFinal);
					System.out.println("\t>> Retiro exitoso. Saldo restante: "+saldoFinal);
				}
				break;
			case 2:
				double dineroDepositado = Capture.capturarDoble("\t>> Ingrese el dinero a depositar");
				double saldoFinal = cuenta.getSaldo()+dineroDepositado;
				cuenta.setSaldo(saldoFinal);
				System.out.println("\t>> Depósito existoso. Saldo actual: "+saldoFinal);
				break;
			case 3:
				System.out.println("\t>> ¡Hasta luego "+cuenta.getNombre()+"!");
				break;
			default:
				System.out.println("Opción inválida.");
				break;
		}
		return null;
	}
}
