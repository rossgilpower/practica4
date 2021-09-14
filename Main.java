package practica4;

import java.util.Scanner;

public class Main {

	public static void main(String [] args) {
		
		Cuenta cuentasExistentes [] = new Cuenta [3];
		
		boolean salir = false;
		int i = 0;
		do {
			System.out.println();
			System.out.println("---- | Bienvenido al banco, elija una de las siguientes opciones | ----");
			System.out.println("1. Crear una cuenta");
			System.out.println("2. Acceder a su cuenta");
			System.out.println("3. Salir");
			int opc = Integer.parseInt(Capture.capturarString(">> Su elección"));
			switch(opc) {
				case 1:
					Banco.crearCuenta(i,cuentasExistentes);
					i++;
					break;
				case 2:
					int ID = Capture.capturarEntero(">> Ingrese su ID");
					int pin = Integer.parseInt(Capture.capturarString(">> Ingrese su pin"));
					Banco.accederCuenta(ID,pin,cuentasExistentes);
					break;
				case 3: 
					System.out.println("Programa finalizado.");
					System.exit(1);
					break;
				default:
					System.out.println("Opción inválida. Pruebe de nuevo.");
					break;
			}
		}while(salir != true);
		
	}
	
	
	
}// Fin del main



class Capture{
	//Aquí para capturar enteros
    public static int capturarEntero(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextInt());
    }
    //Aquí para capturar flotantes
    public static float capturarFlotante(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextFloat());
    }
    //Aquí para capturar dobles
    public static double capturarDoble(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextDouble());
    }
    //Y finalmente aquí para capturar cadenas
    public static String capturarString(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextLine());
    }

}
