import Funcionalidad.Aplicacion;
import java.util.Scanner;

/**
 * @author Alberto Uriarte Martínez y Juan Francisco Benito Cuesta
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
			System.out.println("1. Añadir producto");
			System.out.println("2. Quitar producto");
			System.out.println("3. Mostrar lista");
			System.out.println("4. Salir de la aplicación");
			System.out.println();
			System.out.print("Elige una opción escribiendo su número: ");
			String opcion = sc.nextLine();
			
			switch(opcion){
			case "1":
				System.out.print("Introduce el nombre del producto: ");
				String nombreAnadir = sc.nextLine();
				app.añadir(app.crearProducto(nombreAnadir));
				break;
			case "2":
				System.out.print("Introduce el nombre del producto: ");
				String nombreQuitar = sc.nextLine();
				app.quitar(app.crearProducto(nombreQuitar));
				break;
			case "3":
				app.mostrar();
				System.out.println();
				break;
			case "4":
				seguir=false;
				break;
			}
		}
	}

}
