package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.DAOFactory;
import Entities.Jugador;
import Interfaces.JugadorDAO;


/**
 * Servlet implementation class JugadorServlet
 */
@WebServlet("/JugadorServlet")
public class JugadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JugadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String type = request.getParameter("type");
    	if (type.equals("list")) {
    		 listJugador(request, response);
    	} else if (type.equals("register")) {
    		
    		String idJugador = request.getParameter("idJugador");
    		if(idJugador.isEmpty()){
    			register(request, response);
    		} else {
    			edit(request, response);
    		}
    		
    	} else if (type.equals("info")) {
    		getJugador(request, response);
    	} else if (type.equals("delete")) {
    		remove(request, response);
    	}
    }
    
    protected void listJugador(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
		
    	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    	JugadorDAO jugDao = daoFactory.getJugadorDAO();
    
    	List<Jugador> data = jugDao.getListJugador();
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Jugador.jsp").forward(request, response);
    	
	}
    
    protected void register(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	
    	String equi = util.Constante.ID;
    	String usu = request.getParameter("txtEquipo");
    	String nom = request.getParameter("txtNombres");
    	String ape = request.getParameter("txtApellidos");
    	String dni = request.getParameter("txtDni");
    	String fecNac = request.getParameter("txtFecNac");
    	String tel = request.getParameter("txtTelefono");
    	String tall = request.getParameter("txtTalla");
    	String pes = request.getParameter("txtPeso");
    	String pos = request.getParameter("txtPosicion");
    	String cat = request.getParameter("txtCategoria");
    	String fecR = util.Fecha.fechaActual();
    	
    	
    	Jugador jug = new Jugador();
    	jug.setIdEquipo(equi);
    	jug.setIdUsuario(usu);
    	jug.setNombres(nom);
    	jug.setApellidos(ape);
    	jug.setDni(dni);
    	jug.setFecNac(fecNac);
    	jug.setTelefono(tel);
    	jug.setTalla(tall);
    	jug.setPeso(pes);
    	jug.setIdPosicionB(pos);
    	jug.setIdCategoriaB(cat);
    	jug.setFecRegJugador(fecR);
    	    	
    	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    	JugadorDAO jugDao = daoFactory.getJugadorDAO();
    	
    	int resultado = jugDao.createJugador(jug);
    	
    	if (resultado == 1) {
    		listJugador(request, response);
    	} else {
    		request.setAttribute("msj", "Ocurrió un problema");
    		request.getRequestDispatcher("Jugador.jsp").forward(request, response);
    	}
    	
    	
    }
    
    protected void getJugador(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	String idJugador = request.getParameter("idJugador");
    	
    	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    	JugadorDAO jugDao = daoFactory.getJugadorDAO();
    	
    	Jugador jug = jugDao.getJugador(idJugador);
    	List<Jugador> listJugador = jugDao.getListJugador();
    	
    	request.setAttribute("JugadorData", jug);
    	request.setAttribute("data", listJugador);
    	request.getRequestDispatcher("Jugador.jsp").forward(request, response);
    }

    
    protected void edit(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	
    	String idJugador = request.getParameter("idJugador");
    	
    	String equi = util.Constante.ID;
    	String usu = request.getParameter("txtEquipo");
    	String nom = request.getParameter("txtNombres");
    	String ape = request.getParameter("txtApellidos");
    	String dni = request.getParameter("txtDni");
    	String fecNac = request.getParameter("txtFecNac");
    	String tel = request.getParameter("txtTelefono");
    	String tall = request.getParameter("txtTalla");
    	String pes = request.getParameter("txtPeso");
    	String pos = request.getParameter("txtPosicion");
    	String cat = request.getParameter("txtCategoria");
    	
    	
    	
    	Jugador jug = new Jugador();
    	jug.setIdEquipo(equi);
    	jug.setIdUsuario(usu);
    	jug.setNombres(nom);
    	jug.setApellidos(ape);
    	jug.setDni(dni);
    	jug.setFecNac(fecNac);
    	jug.setTelefono(tel);
    	jug.setTalla(tall);
    	jug.setPeso(pes);
    	jug.setIdPosicionB(pos);
    	jug.setIdCategoriaB(cat);
    	
    	
    	
    	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    	JugadorDAO jugDao = daoFactory.getJugadorDAO();
    	
    	int flagResponse = jugDao.editJugador(jug);
    	
    	if (flagResponse == 1) {
    		listJugador(request, response);
    	} else {
    		request.setAttribute("msj", "Ocurrió un problema");
    		request.getRequestDispatcher("Jugador.jsp").forward(request, response);
    	}
    	
    }
    
    
    protected void remove(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	
    	String idJugador = request.getParameter("idJugador");
    	
    	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    	JugadorDAO jugDao = daoFactory.getJugadorDAO();
    	
    	int flagReponse = jugDao.removeJugador(idJugador);
    	
    	if (flagReponse == 1) {
    		listJugador(request, response);
    	} else {
    		request.setAttribute("msj", "Ocurrió un problema");
    		request.getRequestDispatcher("Jugador.jsp").forward(request, response);
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
