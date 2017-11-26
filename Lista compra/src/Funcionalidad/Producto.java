package Funcionalidad;

/**
 * Clase que representa un producto de la lista.
 * 
 * @author Alberto Uriarte Mart�nez y Juan Francisco Benito Cuesta
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
	 * Si el producto est� comprado (true) o no (false)
	 */
	private boolean comprado;

	/**
	 * Constructor de producto que lo crea con un nombre, una cantidad y que a�n
	 * no est� comprado.
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
	 * Cambia si est� comprado o no un producto.
	 */
	public void cambiarComprado() {
		if (comprado == false)
			comprado = true;
		else
			comprado = false;
	}

	/**
	 * Devuelve una cadena con la palabra "Comprado" o no en funci�n de si lo
	 * est� o no.
	 * 
	 * @return Cadena vac�a o con la palabra "Comprado"
	 */
	public String devolverComprado() {
		if (comprado == false)
			return "";
		else
			return " (Comprado)";
	}

	/**
	 * Devuelve una cadena con las caracter�sticas de un producto.
	 */
	@Override
	public String toString() {
		return nombre + " x" + cantidad + devolverComprado();
	}
}
