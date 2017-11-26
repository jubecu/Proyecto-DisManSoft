package Funcionalidad;

public class Producto {

	private String nombre;
	private int cantidad;
	
	public Producto(String nombre){
		this.nombre=nombre;
		cantidad=1;
	}
	
	public String obtenerNombre(){
		return nombre;
	}
	
	public void cambiarCantidad(int cantidad){
		this.cantidad=cantidad;
	}
	
	@Override
	public String toString(){
		return nombre+" x"+cantidad;
	}
}
