package ec.edu.ups.modelos;

import java.io.Serializable;
import java.util.List;


import javax.persistence.*;



/**
 * Entity implementation class for Entity: Libro
 *
 */
@Entity
@Table(name = "libro")
public class Libro implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int codigo;
	private String nombre;
	private String ISBN;
	private int numPaginas;
	
	
	@OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Capitulo> capitulos;
 
	
	public Libro() {
		super();
	}
	
	


	public Libro(String nombre, String iSBN, int numPaginas, List<Capitulo> capitulos) {
		super();
		this.nombre = nombre;
		this.ISBN = iSBN;
		this.numPaginas = numPaginas;
		this.capitulos = capitulos;
	}
	
	public Libro( String nombre, String iSBN, int numPaginas) {
		super();
		this.nombre = nombre;
		this.ISBN = iSBN;
		this.numPaginas = numPaginas;
	}





	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public int getNumPaginas() {
		return numPaginas;
	}


	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}


	public List<Capitulo> getCapitulos() {
		return capitulos;
	}


	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	
	
	
	

	
	
   
}
