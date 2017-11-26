package Funcionalidad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Clase que realiza las operaciones de la aplicación.
 * 
 * @author Alberto Uriarte Martínez y Juan Francisco Benito Cuesta
 *
 */
public class Aplicacion {
	/**
	 * Lista de la compra
	 */
	private Lista lista;
	/**
	 * Productos que están en la lista
	 */
	private ArrayList<String> productos = new ArrayList<String>();
	/**
	 * Instancia de la clase Aplicacion
	 */
	private static Aplicacion instance = null;

	/**
	 * Constructor privado.
	 */
	private Aplicacion() {

	}

	/**
	 * Crea una instancia de Aplicacion si está vacía y la devuleve.
	 * 
	 * @return Instancia de Aplicacion
	 */
	public static Aplicacion getInstance() {
		if (instance == null)
			instance = new Aplicacion();
		return instance;
	}

	/**
	 * Crea la lista a partir del fichero y almacena los productos que contiene.
	 */
	public void iniciarAplicacion() {
		lista = new Lista("Lista.txt");
		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(lista.obtenerFichero());
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null)
				productos.add(linea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * Crea un nuevo producto.
	 * 
	 * @param nombre
	 *            Nombre del producto
	 * @param cantidad
	 *            Cantidad del producto
	 * @return Nuevo producto
	 */
	public Producto crearProducto(String nombre, int cantidad) {
		Producto producto = new Producto(nombre, cantidad);
		return producto;
	}

	/**
	 * Devuelve la cadena de texto que representa a un producto.
	 * 
	 * @param nombre
	 *            Nombre del producto.
	 * @return Cadena de texto que representa al producto
	 */
	public String devolverProducto(String nombre) {
		Object[] productosArray = productos.toArray();
		String prod = null;
		for (int i = 0; i < productosArray.length; i++) {
			if (productosArray[i].toString().contains(nombre)) {
				prod = productosArray[i].toString();
			}
		}
		return prod;
	}

	/**
	 * Añade un producto a la lista.
	 * 
	 * @param producto
	 *            Producto a añadir
	 */
	public void añadir(Producto producto) {
		lista.añadirProducto(producto.toString());
		productos.add(producto.toString());
	}

	/**
	 * Muestra el contenido de la lista.
	 */
	public void mostrar() {
		lista.mostrarLista();
	}

	/**
	 * Quita un producto de la lista.
	 * 
	 * @param producto
	 *            Nombre del producto a quitar
	 */
	public void quitar(String producto) {
		lista.quitarProducto(producto);
		productos.remove(producto);
	}

	/**
	 * Añade el producto con la cantidad actualizada.
	 * 
	 * @param producto
	 *            Producto a cambiar su cantidad
	 * @param cantidad
	 *            Nueva cantidad
	 */
	public void variarCantidad(Producto producto, int cantidad) {
		quitar(producto.toString());
		producto.cambiarCantidad(cantidad);
		añadir(producto);
	}

	/**
	 * Añade el producto a la lista con la palabra "Comprado".
	 * 
	 * @param producto
	 *            Nombre del producto
	 */
	public void marcarComprado(String producto) {

		String prod = devolverProducto(producto);
		int cantidad = Integer.parseInt(String.valueOf(prod.charAt(prod.length() - 1)));
		quitar(devolverProducto(producto));
		Producto prod2 = crearProducto(producto, cantidad);
		prod2.cambiarComprado();
		añadir(prod2);
	}
}
