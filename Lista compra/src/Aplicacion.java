import java.util.Scanner;

public class Aplicacion {

	private static Lista lista;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		lista=new Lista("Lista.txt");
		lista.mostrarLista();
		System.out.println("Introduce un producto:");
		String nombre = sc.nextLine();
		Producto producto=new Producto(nombre);
		lista.añadirProducto(producto.obtenerNombre());
		lista.mostrarLista();
		sc.close();
	}

}
