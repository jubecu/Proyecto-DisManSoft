import java.io.*;

public class Lista {

	private File lista = null;

	public Lista(String nombreFichero) {
		lista = new File(nombreFichero);
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
}
