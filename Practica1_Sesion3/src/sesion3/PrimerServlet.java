package sesion3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class PrimerServlet
 */
@WebServlet("/PrimerServlet")
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PrimerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();  //Creo un ArrayList llamado usuarios
		UsuarioDTO user1= new UsuarioDTO("Daniel","Mesa","dmg@red.ujaen.es"); //Introduzco varios usuarios
		UsuarioDTO user2= new UsuarioDTO("Antonio","Costarosa","acc@red.ujaen.es"); //...............
		UsuarioDTO user3= new UsuarioDTO("Javier","Sanchez","jss@red.ujaen.es"); //.......
		usuarios.add(user1);  //Añado los diferentes objetos user1,2 y 3 al arrayList llamado usuarios
		usuarios.add(user2);  //...........
		usuarios.add(user3);  //...........
		request.setAttribute("usuarios", usuarios);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario=request.getParameter("usuario"); //Recojo el usuario 
		String passwd=request.getParameter("clave");    //y la contraseña del formulario (index)
		String url="";
		UsuarioDTO db= new UsuarioDTO();  //Creamos un objeto UsuarioDTO para poder usar el metodo de chequeo 
		if(db.checkAdmin(usuario,passwd)) {  //Si el nombre y la clave coinciden con un admin
			doGet(request, response);
			url="/WEB-INF/admin.jsp"; //Guiamos al usuario a la parte del administrador
		
		}else url="/WEB-INF/registro.jsp"; //Si no lo enviamos a que se registre
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
