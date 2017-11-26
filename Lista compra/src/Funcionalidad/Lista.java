package Funcionalidad;
import java.io.*;

public class Lista {

	private File lista = null;

	public Lista(String nombreFichero) {
		lista = new File(nombreFichero);
	}
	
	public File obtenerFichero(){
		return lista;
	}

	public void mostrarLista() {
		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(lista);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
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

	public void añadirProducto(String producto) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(lista, true);
			pw = new PrintWriter(fichero);
			pw.println(producto);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void quitarProducto(String producto){
		try {
	 
			//Creación de un nuevo archivo que más tarde será renombrado
			//con el nombre del archivo original
	        File tempFile = new File(lista.getAbsolutePath() + ".tmp");
	 
	        BufferedReader br = new BufferedReader(new FileReader("Lista.txt"));
	        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	 
	        String line = null;
	 
	        //Lee el archivo original y escribe en el nuevo
	        //sin el producto que queremos quitar
	        while ((line = br.readLine()) != null) {
	 
	            if (!line.trim().equals(producto)) {
	 
	                pw.println(line);
	                pw.flush();
	            }
	        }
	        pw.close();
	        br.close();
	 
	        //Borra el archivo original
	        if (!lista.delete()) {
	            System.out.println("No se pudo borrar el archivo");
	            return;
	        }
	 
	        //Cambia el nombre del nuevo archivo por el del archivo original
	        if (!tempFile.renameTo(lista)){
	            System.out.println("No se pudo renombrar el archivo");
	 
	        }
	    } catch (FileNotFoundException ex) {
	        ex.printStackTrace();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
}
