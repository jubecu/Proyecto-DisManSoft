import java.util.Scanner;
public class Aplicacion {
	
	enum MenuOpcion {
	    A�ADIR_OBJETO("A�adir objeto a la lista."),
	    QUITAR_OBJETO("Quitar objeto de la lista."),
	    MOSTRAR_OBJETOS("Mostrar la lista y el numero de objetos."),
	    SALIR("Salir.");

	    private final String mensaje;

	    private MenuOpcion(String mensaje){
	        this.mensaje = mensaje;
	    }

	    public String getMensaje(){
	        return mensaje;
	    }
	}

	public static void main( String [] args) { 
		Lista miLista = new Lista();
		Scanner scanner = new Scanner(System.in);
		MenuOpcion opcionSeleccionada = null;
		
		while(opcionSeleccionada != MenuOpcion.SALIR){

		    opcionSeleccionada = pedirOpcion(scanner);

		    switch(opcionSeleccionada){
		        case A�ADIR_OBJETO:                
		            Cliente.a�adirObjeto();
		            break;
		        case QUITAR_OBJETO:                
		            Cliente.quitarObjeto();
		            break;
		        case MOSTRAR_OBJETOS:
		            miLista.mostrarObjeto();
		            break;
			default:
				break;
		    }
		}
	}
	
	private static MenuOpcion pedirOpcion(Scanner scanner){
	    System.out.println("");
	    System.out.println("----- Lista de la compra ------");
	    for(int i=0; i<MenuOpcion.values().length; i++){
	        MenuOpcion opcion = MenuOpcion.values()[i];
	        System.out.println("(" + i + ") " + opcion.getMensaje());
	    }

	    int num = scanner.nextInt();
	    // TODO check for invalid inputs
	    return MenuOpcion.values()[num]; 
	}
}