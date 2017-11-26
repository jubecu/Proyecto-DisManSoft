import Funcionalidad.Aplicacion;
import java.util.Scanner;

/**
 * @author Alberto Uriarte Mart�nez y Juan Francisco Benito Cuesta
 *
 */
public class Cliente {
	
	private static Aplicacion app;
	private static Scanner sc;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		app=Aplicacion.getInstance();
		sc = new Scanner(System.in);
		boolean seguir=true;
		
		app.iniciarAplicacion();
		
		while(seguir){
			System.out.println("APP - LISTA DE LA COMPRA");
			System.out.println("1. A�adir producto");
			System.out.println("2. Quitar producto");
			System.out.println("3. Mostrar lista");
			System.out.println("4. Cambiar la cantidad de un producto");
			System.out.println("5. Salir de la aplicaci�n");
			System.out.println();
			System.out.print("Elige una opci�n escribiendo su n�mero: ");
			String opcion = sc.nextLine();
			
			switch(opcion){
			case "1":
				System.out.print("Introduce el nombre del producto: ");
				String nombreAnadir = sc.nextLine();
				app.a�adir(app.crearProducto(nombreAnadir));
				break;
			case "2":
				System.out.print("Introduce el nombre del producto: ");
				String nombreQuitar = sc.nextLine();
				app.quitar(app.devolverProducto(nombreQuitar));
				break;
			case "3":
				app.mostrar();
				System.out.println();
				break;
			case "4":
				System.out.print("Introduce el nombre del producto: ");
				String nombreCantidad = sc.nextLine();
				System.out.print("Introduce la nueva cantidad: ");
				String cant = sc.nextLine();
				int cantidad=Integer.parseInt(cant);
				app.variarCantidad(app.crearProducto(nombreCantidad), cantidad);
				break;
			case "5":
				seguir=false;
				break;
			}
		}
	}

}
