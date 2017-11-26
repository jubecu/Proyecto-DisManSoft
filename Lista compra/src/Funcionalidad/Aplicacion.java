package Funcionalidad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Aplicacion {

	private Lista lista;
	private ArrayList<String> productos=new ArrayList<String>();
	private static Aplicacion instance = null;

	private Aplicacion() {

	}

	public static Aplicacion getInstance() {
		if (instance == null)
			instance = new Aplicacion();
		return instance;
	}

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

	public Producto crearProducto(String nombre) {
		Producto producto = new Producto(nombre);
		return producto;
	}
	
	public String devolverProducto(String nombre){
		Object[] productosArray=productos.toArray();
		String prod = null;
		for(int i=0;i<productosArray.length;i++){
			if(productosArray[i].toString().contains(nombre)){
				prod=productosArray[i].toString();
			}
		}
		return prod;
	}

	public void añadir(Producto producto) {
		lista.añadirProducto(producto.toString());
		productos.add(producto.toString());
	}

	public void mostrar() {
		lista.mostrarLista();
	}

	public void quitar(String producto) {
		lista.quitarProducto(producto);
		productos.remove(producto);
	}

	public void variarCantidad(Producto producto, int cantidad) {
		quitar(producto.toString());
		producto.cambiarCantidad(cantidad);
		añadir(producto);
	}
}
