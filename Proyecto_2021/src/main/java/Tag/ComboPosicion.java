package Tag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import DAO.DAOFactory;
import Entities.Posicion;
import Interfaces.JugadorDAO;

public class ComboPosicion extends TagSupport {
	
	private String name;
	
	@Override
	public int doStartTag() throws JspException {	
	
		JspWriter out = pageContext.getOut();

		DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		JugadorDAO dao = daoFactory.getJugadorDAO();
		
	try {
		
		out.print("<select class='form-control' name='"+name+"'>");
		out.print("<option value='-1'>[Seleccione una Posicion]</option>");
		
		List<Posicion> listado = dao.listPosicion();
		
		for(Posicion pos: listado) {
		
			out.print("<option value='"+pos.getIdPosicion()+"'>");
			out.print(pos.getPosicion());            
			out.print("</option>");			
		}
			out.print("<select/>");		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return super.doStartTag();
	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
