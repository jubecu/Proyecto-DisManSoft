import Funcionalidad.Aplicacion;
import java.util.Scanner;

/**
 * Clase con el main desde donde se interactúa con la aplicación.
 * 
 * @author Alberto Uriarte Martínez y Juan Francisco Benito Cuesta
 *
 */
public class Cliente {
	/**
	 * Aplicación
	 */
	private static Aplicacion app;
	/**
	 * Scanner para introducir valores por teclado
	 */
	private static Scanner sc;

	/**
	 * Main donde se crea una instancia de la aplicación, la iniciamos e
	 * interactuamos con ella a través de un menú.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		app = Aplicacion.getInstance();
		sc = new Scanner(System.in);
		boolean seguir = true;

		app.iniciarAplicacion();

		while (seguir) {
			System.out.println("APP - LISTA DE LA COMPRA");
			System.out.println("1. Añadir producto");
			System.out.println("2. Quitar producto");
			System.out.println("3. Mostrar lista");
			System.out.println("4. Cambiar la cantidad de un producto");
			System.out.println("5. Marcar producto como comprado");
			System.out.println("6. Salir de la aplicación");
			System.out.println();
			System.out.print("Elige una opción escribiendo su número: ");
			String opcion = sc.nextLine();

			switch (opcion) {
			case "1":
				System.out.print("Introduce el nombre del producto a añadir: ");
				String nombreAnadir = sc.nextLine();
				app.añadir(app.crearProducto(nombreAnadir, 1));
				break;
			case "2":
				System.out.print("Introduce el nombre del producto a quitar: ");
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
				int cantidad = Integer.parseInt(cant);
				app.variarCantidad(app.crearProducto(nombreCantidad, 1), cantidad);
				break;
			case "5":
				System.out.print("Introduce un nombre de un producto que no esté comprado: ");
				String nombreComprado = sc.nextLine();
				app.marcarComprado(nombreComprado);
				break;
			case "6":
				seguir = false;
				break;
			}
		}
	}

}
