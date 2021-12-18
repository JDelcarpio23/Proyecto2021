package Interfaces;

import java.util.List;

import Entities.Categoria;
import Entities.Jugador;
import Entities.Posicion;

public interface JugadorDAO {
	
	public List<Jugador> getListJugador();
	public int createJugador(Jugador jug);
	public Jugador getJugador(String id);
	public int editJugador(Jugador jug);
	public int removeJugador(String id);
	
	public List<Posicion> listPosicion();
	public List<Categoria> listCategoria();
		

}
