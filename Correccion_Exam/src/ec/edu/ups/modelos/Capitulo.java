package ec.edu.ups.modelos;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Capitulo
 *
 */
@Entity
@Table(name = "capitulo")
public class Capitulo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int codigoCapitulo;
	private int numero;
	private String titulo;

	@JoinColumn(name = "autor_id")
	@OneToOne(fetch = FetchType.LAZY)
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "libro_id")
	private Libro libro;

	
	
	
	public Capitulo() {
		super();
	}

	public Capitulo(int numero, String titulo, Autor autor, Libro libro) {
		super();
		this.numero = numero;
		this.titulo = titulo;
		this.autor = autor;
		this.libro = libro;
	}

	public int getCodigoCapitulo() {
		return codigoCapitulo;
	}

	public void setCodigoCapitulo(int codigoCapitulo) {
		this.codigoCapitulo = codigoCapitulo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
}
