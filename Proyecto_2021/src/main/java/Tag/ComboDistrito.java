package Tag;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import DAO.DAOFactory;
import Entities.Distrito;
import Interfaces.EquipoDAO;

public class ComboDistrito extends TagSupport{
	
	private String name;
	
	@Override
	public int doStartTag() throws JspException {	
	
		JspWriter out = pageContext.getOut();

		DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		EquipoDAO dao = daoFactory.getEquipoDAO();
		
	try {
		
		out.print("<select class='form-control' name='"+name+"'>");
		out.print("<option value='-1'>[Seleccione una Categoria]</option>");
		
		List<Distrito> listado = dao.listDistrito(1);
		
		for(Distrito dis: listado) {
		
			out.print("<option value='"+dis.getIdDistrito()+"'>");			
			out.print(dis.getDistrito());            
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
