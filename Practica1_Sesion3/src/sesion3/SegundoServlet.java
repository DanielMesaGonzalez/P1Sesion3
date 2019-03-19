package sesion3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class SegundoServlet
 */
@WebServlet("/SegundoServlet")
public class SegundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SegundoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getSession()==null) {  //Si la sesion no existe o ha terminado
	    	String url="/WebContent/FinSesion.html"; //Enviamos al usuario a fin de sesion
			getServletContext().getRequestDispatcher(url).forward(request, response);	
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion=request.getSession(true);
		String nombre=request.getParameter("username");
		String email=request.getParameter("email");
		String direccion=request.getParameter("home");
		UsuarioDTO user=new UsuarioDTO(nombre, email, direccion);
		request.setAttribute("user", user);
	    sesion.setAttribute("user", user);
		
	    sesion.setMaxInactiveInterval(5); // Indicamos el tiempo que queremos que dure la sesion
	    
	    String url="/WEB-INF/sesion.jsp";  // Enviamos al usuario al jsp sesion
		getServletContext().getRequestDispatcher(url).forward(request, response);
		doGet(request, response);
	}

}
