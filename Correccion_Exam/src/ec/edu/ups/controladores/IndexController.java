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
import ec.edu.ups.modelos.Autor;
import ec.edu.ups.modelos.Capitulo;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		CapituloDAO capitulod = DAOFactory.getFactory().getCapituloDAO();
		AutorDAO autord = DAOFactory.getFactory().getAutorDAO();
		if (Integer.parseInt(request.getParameter("id")) == 1) {
			request.setAttribute("capitulos", capitulod.findAll());
			getServletContext().getRequestDispatcher("/Paginas/listarLibros.jsp").forward(request, response);

		} 
		
		if (Integer.parseInt(request.getParameter("id")) == 2) {
			//Buscar Por autor
			
			Autor au = new Autor();
			au= autord.buscar("nombre", request.getParameter("autor"));
			System.out.println("autor "+au.getNombre());
			List<Capitulo> cap = new ArrayList<Capitulo>();
			System.out.println("Capitulo encontrado: "+ capitulod.find("autor_id", String.valueOf(au.getCodigoAutor())).get(0).getTitulo());
			System.out.println("Capitulos: "+cap.get(0).getTitulo());
			
			request.setAttribute("capitulos",  cap);
			getServletContext().getRequestDispatcher("/Paginas/listarLibros.jsp").forward(request, response);

		} 
		
		if (Integer.parseInt(request.getParameter("id")) == 3) {
			//Buscar por titulo
			
			request.setAttribute("capitulos", capitulod.find("titulo",  request.getParameter("titulo")));
			getServletContext().getRequestDispatcher("/Paginas/listarLibros.jsp").forward(request, response);

		} 
		
		if (Integer.parseInt(request.getParameter("id")) == 4) {
			request.setAttribute("autor", autord.findAll());
			getServletContext().getRequestDispatcher("/Paginas/RegistrarLibro.jsp").forward(request, response);

		} 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
