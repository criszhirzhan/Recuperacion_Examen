package ec.edu.ups.test;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.LibroDAO;
import ec.edu.ups.modelos.Libro;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LibroDAO librodao = DAOFactory.getFactory().getLibroDAO();
		
		Libro lib = new Libro();
		
		lib= librodao.read(251);
		
		System.out.println(lib.getCapitulos().get(2).getTitulo());
		System.out.println(lib.getCapitulos().get(2).getAutor().getNombre());
		

	}

}
