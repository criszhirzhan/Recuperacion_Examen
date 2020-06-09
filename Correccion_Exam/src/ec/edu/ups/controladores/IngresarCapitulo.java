package ec.edu.ups.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.AutorDAO;
import ec.edu.ups.dao.CapituloDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.LibroDAO;
import ec.edu.ups.modelos.Autor;
import ec.edu.ups.modelos.Capitulo;
import ec.edu.ups.modelos.Libro;

/**
 * Servlet implementation class IngresarCapitulo
 */
@WebServlet("/IngresarCapitulo")
public class IngresarCapitulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Libro libro;
	private List<Capitulo> capitulos;
	private  AutorDAO autord;
	private LibroDAO librodao;
	private CapituloDAO capitulod;
	private Libro l ;
	private int cont=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarCapitulo() {
        super();
        libro = new Libro();
        capitulos = new ArrayList<Capitulo>();
        autord = DAOFactory.getFactory().getAutorDAO();
		librodao = DAOFactory.getFactory().getLibroDAO();
		capitulod = DAOFactory.getFactory().getCapituloDAO();
		l = new Libro();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String numCapitulo="";
		String titulo="";
		Autor autor = new Autor();
		Capitulo capitulo= new Capitulo();
		String autorN= "";
		
		
		
		/////
		String nombre="";
		String isbn="";
		String numPaginas="";
		
		
		String accion = request.getParameter("registrarLibro");
		if (accion.equals("Agregar")) {
			System.out.println("Agregando Capitulo");
			//DATOS ARTICULO
			numCapitulo = request.getParameter("numCap");
			titulo = request.getParameter("titulo");
			autorN = request.getParameter("tip");
			autor= autord.buscar("nombre", autorN);
			
			
			//capitulo = new Capitulo( Integer.parseInt(numCapitulo) , titulo, autor);
			
			//DATOS LIBRO
			nombre=request.getParameter("nombre");
			isbn=request.getParameter("ISBN");
			numPaginas=request.getParameter("numPaginas");
			
			libro = new Libro(nombre, isbn, Integer.parseInt(numPaginas));
			
			
			if (cont==0) {
				librodao.create(libro);
				cont=1;
			}
			
			
			
			if (cont==1) {
				l=librodao.buscar("nombre", nombre);
				capitulo = new Capitulo(Integer.parseInt(numCapitulo), titulo, autor, l);
				capitulod.create(capitulo);
				capitulos.add(capitulo);
			}
			
			try {
				
				request.setAttribute("libro", libro);
				request.setAttribute("autor", autord.findAll());
				getServletContext().getRequestDispatcher("/Paginas/RegistrarLibro.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		if (accion.equals("Registrar")) {
			System.out.println("Registrando Libro");
			
			l.setCapitulos(capitulos);
			
			librodao.update(l);
			libro = new Libro();
	        capitulos = new ArrayList<Capitulo>();
	        autord = DAOFactory.getFactory().getAutorDAO();
			librodao = DAOFactory.getFactory().getLibroDAO();
			capitulod = DAOFactory.getFactory().getCapituloDAO();
			l = new Libro();
		
			//capitulo = new Capitulo( Integer.parseInt(numCapitulo) , titulo, autor);
			try {
				getServletContext().getRequestDispatcher("/Paginas/RegistrarLibro.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			


		}
		

		
		
		
	}

}
