package model;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AlmacenLibro {
	
		public void AlmacenLibro() {
			
		}

		public void guardar_libro(Libro libro, String identificador) {
			
			ObjectOutputStream out = null;
			
			try {
				ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream(identificador));
				out1.writeObject(libro);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				intentarCerrar(out);
			}
			
		}
		public void intentarCerrar(Closeable aCerrar) {
			try {
				if(aCerrar!= null) {
					aCerrar.close();
				}
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace(System.err);
			}
		}
		public Libro recuperar_libro(String identificador) {
			Libro libro= null;
			ObjectInputStream in = null;
			try {
				in = new ObjectInputStream(new FileInputStream(identificador));
				libro = (Libro) in.readObject();
			} catch (ClassNotFoundException ex) {
				System.err.println("Error de fichero");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Error IO");
			}finally{
				intentarCerrar(in);
			}
			return libro;
		}
		
}
