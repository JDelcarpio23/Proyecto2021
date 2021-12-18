package Interfaces;

import java.util.List;

import Entities.Departamento;
import Entities.Distrito;
import Entities.Equipo;
import Entities.Provincia;

public interface EquipoDAO {

	public List<Equipo> getListEquipo();
	public int createEquipo(Equipo eq);
	public Equipo getEquipo(String idEquipo);
	public int editEquipo(Equipo eq);
	public int removeEquipo(String idEquipo);
	
	public List<Departamento> listDepartamento();
	public List<Provincia> listProvincia(int idDepartamento);
	public List<Distrito> listDistrito(int idProvincia);
}
