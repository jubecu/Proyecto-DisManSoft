package Funcionalidad;

public class Producto {

	private String nombre;
	private int cantidad;
	private boolean comprado;

	public Producto(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		comprado = false;
	}

	public String obtenerNombre() {
		return nombre;
	}

	public void cambiarCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void cambiarComprado() {
		if (comprado == false)
			comprado = true;
		else
			comprado = false;
	}

	public String devolverComprado() {
		if (comprado == false)
			return "";
		else
			return " (Comprado)";
	}

	@Override
	public String toString() {
		return nombre + " x" + cantidad + devolverComprado();
	}
}
