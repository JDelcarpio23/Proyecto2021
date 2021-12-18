package Interfaces;

import java.util.List;

import Entities.Equipo;

public interface EquipoDAO {

	public List<Equipo> getListEquipo();
	public int createEquipo(Equipo eq);
	public Equipo getEquipo(String idEquipo);
	public int editEquipo(Equipo eq);
	public int removeEquipo(String idEquipo);
}
