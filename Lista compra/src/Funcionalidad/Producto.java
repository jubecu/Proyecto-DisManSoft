package Funcionalidad;

/**
 * Clase que representa un producto de la lista.
 * 
 * @author Alberto Uriarte Martínez y Juan Francisco Benito Cuesta
 *
 */
public class Producto {
	/**
	 * Nombre del producto
	 */
	private String nombre;
	/**
	 * Cantidad que se quiere comprar
	 */
	private int cantidad;
	/**
	 * Si el producto está comprado (true) o no (false)
	 */
	private boolean comprado;

	/**
	 * Constructor de producto que lo crea con un nombre, una cantidad y que aún
	 * no está comprado.
	 * 
	 * @param nombre
	 *            Nombre del producto
	 * @param cantidad
	 *            Cantidad que se quiere comprar de dicho producto
	 */
	public Producto(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		comprado = false;
	}

	/**
	 * Obtiene el nombre del producto.
	 * 
	 * @return Nombre del producto
	 */
	public String obtenerNombre() {
		return nombre;
	}

	/**
	 * Cambia la cantidad del producto.
	 * 
	 * @param cantidad
	 *            Nueva cantidad que queremos comprar
	 */
	public void cambiarCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Cambia si está comprado o no un producto.
	 */
	public void cambiarComprado() {
		if (comprado == false)
			comprado = true;
		else
			comprado = false;
	}

	/**
	 * Devuelve una cadena con la palabra "Comprado" o no en función de si lo
	 * está o no.
	 * 
	 * @return Cadena vacía o con la palabra "Comprado"
	 */
	public String devolverComprado() {
		if (comprado == false)
			return "";
		else
			return " (Comprado)";
	}

	/**
	 * Devuelve una cadena con las características de un producto.
	 */
	@Override
	public String toString() {
		return nombre + " x" + cantidad + devolverComprado();
	}
}
