package Funcionalidad;

public class Aplicacion {

	private Lista lista;
	private static Aplicacion instance=null;
	
	private Aplicacion(){
		
	}
	
	public static Aplicacion getInstance(){
		if(instance==null)
			instance=new Aplicacion();
		return instance;
	}
	
	public void iniciarAplicacion(){
		lista=new Lista("Lista.txt");
	}
	
	public Producto crearProducto(String nombre){
		Producto producto=new Producto(nombre);
		return producto;
	}
	
	public void a�adir(Producto producto){
		lista.a�adirProducto(producto.obtenerNombre());
	}
	
	public void mostrar(){
		lista.mostrarLista();
	}
	
	public void quitar(Producto producto){
		lista.quitarProducto(producto.obtenerNombre());
	}
}
