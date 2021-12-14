package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOFactory;
import Entities.Login;	
import Interfaces.AuthDAO;
import util.Constante;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String type = request.getParameter("type");
    	if(type.equals("login")) {
    		String email = request.getParameter("txtCorreo");
        	String password = request.getParameter("txtClave");
        
        	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        	AuthDAO dao = daoFactory.getAuth();
        	
        	Login login = dao.verifyAuthModel(email, password);
        	if (login != null) {
        		
        		HttpSession sesion = request.getSession();
        		
        		sesion.setAttribute(Constante.ID, login.getIdUsuario());
        		sesion.setAttribute(Constante.NOMBRE, login.getNombre());
        		sesion.setAttribute(Constante.APELLIDOS, login.getApellido());
        		sesion.setAttribute(Constante.EMAIL, login.getEmail());
        		sesion.setAttribute(Constante.FECHA, login.getFecReg());
        		
        		response.sendRedirect("Home.jsp");
        		
        	} else {
        		request.setAttribute("msj", "Verifique sus credenciales");
        		request.getRequestDispatcher("Login.jsp").forward(request, response);
        	}
        	
    	} else if(type.equals("logout")){
    		request.getSession().invalidate();
    		response.sendRedirect("Login.jsp");
    	}
    	    	
    	
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
	}

}
