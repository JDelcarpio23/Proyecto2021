package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOFactory;
import Entities.Equipo;
import Interfaces.EquipoDAO;
import util.Constante;
import util.Fecha;

/**
 * Servlet implementation class EquipoServlet
 */
@WebServlet("/EquipoServlet")
public class EquipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String type = request.getParameter("type");
    	if (type.equals("list")) {
    		listEquipo(request, response);
    	} else if (type.equals("register")) {
    		
    		String idEquipo = request.getParameter("idEquipo");
    		if(idEquipo.isEmpty()){
    			register(request, response);
    		} else {
    			edit(request, response);
    		}
    		
    	} else if (type.equals("info")) {
    		getEquipo(request, response);
    	} else if (type.equals("delete")) {
    		remove(request, response);
    		
    	}
    	
    	
    }
    protected void listEquipo(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	
    	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    	EquipoDAO eqDao = daoFactory.getEquipoDAO();
    
    	List<Equipo> data = eqDao.getListEquipo();
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Equipo.jsp").forward(request, response);
    	
	}
    
    protected void register(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	
    	String nombre = request.getParameter("txtNombre");
    	String departamento = request.getParameter("txtIdDepartamento");
    	String provincia = request.getParameter("txtIdProvincia");
    	String distrito = request.getParameter("txtIdDistrito");
    	String usuario = Constante.ID;
    	String fechaReg = Fecha.fechaActual();
    	
    	Equipo equipo = new Equipo();
    	equipo.setNombreEquipo(nombre);
    	equipo.setIdDepartamento(departamento);
    	equipo.setIdProvincia(provincia);
    	equipo.setIdDistrito(distrito);
    	equipo.setIdUsuario(usuario);
    	equipo.setFechaRegistroEqu(fechaReg);
    	    	
    	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    	EquipoDAO eqDao = daoFactory.getEquipoDAO();
    	
    
    	
    	int resultado = eqDao.createEquipo(equipo);
    	
    	if (resultado == 1) {
    		listEquipo(request, response);
    	} else {
    		request.setAttribute("msj", "Ocurrió un problema");
    		request.getRequestDispatcher("Equipo.jsp").forward(request, response);
    	}
    }
    
    protected void getEquipo(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	String idEquipo = request.getParameter("idEquipo");
    	
    	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    	EquipoDAO eqDao = daoFactory.getEquipoDAO();
    	
    	Equipo equipo = eqDao.getEquipo(idEquipo); 
    	List<Equipo> listEquipo = eqDao.getListEquipo(); 
    	
    	request.setAttribute("EquipoData", equipo);
    	request.setAttribute("data", listEquipo);
    	request.getRequestDispatcher("Equipo.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	
    	String idEquipo = request.getParameter("idEquipo");
    	String nombre = request.getParameter("txtNombre");
    	String departamento = request.getParameter("txtIdDepartamento");
    	String provincia = request.getParameter("txtIdProvincia");
    	String distrito = request.getParameter("txtIdDistrito");
    	String usuario = request.getParameter("txtIdUsuario");
    	String fechaReg = request.getParameter("txtFechaReg");
    	
    	Equipo equipo = new Equipo();
    	equipo.setIdEquipo(idEquipo);
    	equipo.setNombreEquipo(nombre);
    	equipo.setIdDepartamento(departamento);
    	equipo.setIdProvincia(provincia);
    	equipo.setIdDistrito(distrito);
    	equipo.setIdUsuario(usuario);
    	equipo.setFechaRegistroEqu(fechaReg);
    	
    	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    	EquipoDAO eqDao = daoFactory.getEquipoDAO();
    	
    	int flagResponse = eqDao.editEquipo(equipo); 
    	
    	if (flagResponse == 1) {
    		listEquipo(request, response);
    	} else {
    		request.setAttribute("msj", "Ocurrió un problema");
    		request.getRequestDispatcher("Equipo.jsp").forward(request, response);
    	}
    	
    }
    
    protected void remove(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	
    	String idEquipo = request.getParameter("idEquipo");
    	
    	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    	EquipoDAO eqDao = daoFactory.getEquipoDAO();
    	
    	int flagReponse = eqDao.removeEquipo(idEquipo); 
    	
    	if (flagReponse == 1) {
    		listEquipo(request, response);
    	} else {
    		request.setAttribute("msj", "Ocurrió un problema");
    		request.getRequestDispatcher("Equipo.jsp").forward(request, response);
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
