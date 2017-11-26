package Funcionalidad;

import java.io.*;

/**
 * Clase que representa una lista y sus operaciones.
 * 
 * @author Alberto Uriarte Martínez y Juan Francisco Benito Cuesta
 *
 */
public class Lista {
	/**
	 * Archivo de texto donde se guarda la lista
	 */
	private File lista = null;

	/**
	 * Constructor que crea un archivo con un nombre concreto.
	 * 
	 * @param nombreFichero
	 *            Nombre del archivo de texto.
	 */
	public Lista(String nombreFichero) {
		lista = new File(nombreFichero);
	}

	/**
	 * Devuelve el fichero donde está guardada la lista.
	 * 
	 * @return fichero donde está guardada la lista
	 */
	public File obtenerFichero() {
		return lista;
	}

	/**
	 * Lee el fichero, lo recorre y va mostrando por pantalla línea a línea.
	 */
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

	/**
	 * Escribe al final del fichero un producto concreto.
	 * 
	 * @param producto
	 *            Producto que queremos añadir
	 */
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

	/**
	 * Crea un nuevo fichero con todos los mismos productos excepto el que
	 * queremos quitar.
	 * 
	 * @param producto
	 *            Producto que queremos eliminar de la lista
	 */
	public void quitarProducto(String producto) {
		try {

			// Creación de un nuevo archivo que más tarde será renombrado
			// con el nombre del archivo original
			File tempFile = new File(lista.getAbsolutePath() + ".tmp");

			BufferedReader br = new BufferedReader(new FileReader("Lista.txt"));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

			String line = null;

			// Lee el archivo original y escribe en el nuevo
			// sin el producto que queremos quitar
			while ((line = br.readLine()) != null) {

				if (!line.trim().equals(producto)) {

					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();

			// Borra el archivo original
			if (!lista.delete()) {
				System.out.println("No se pudo borrar el archivo");
				return;
			}

			// Cambia el nombre del nuevo archivo por el del archivo original
			if (!tempFile.renameTo(lista)) {
				System.out.println("No se pudo renombrar el archivo");

			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
