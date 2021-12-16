package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.MysqlConexion;
import Entities.Categoria;
import Entities.Jugador;
import Entities.Posicion;
import Interfaces.JugadorDAO;

public class MySqlJugadorDAO implements JugadorDAO{

	@Override
	public List<Jugador> getListJugador() {
		
		List<Jugador> listJugador = new ArrayList<Jugador>();
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		
		try {
			
			cn = MysqlConexion.getConexion();
			
			String sql = "select * from jugador";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Jugador jug = new Jugador();
				
				jug.setIdJugador(rs.getString("idJugador"));
				jug.setIdJugador(rs.getString("idEquipo"));
				jug.setIdJugador(rs.getString("idUsuario"));
				jug.setIdJugador(rs.getString("nombres"));
				jug.setIdJugador(rs.getString("apellidos"));
				jug.setIdJugador(rs.getString("dni"));
				jug.setIdJugador(rs.getString("FecNac"));
				jug.setIdJugador(rs.getString("telefono"));
				jug.setIdJugador(rs.getString("talla"));
				jug.setIdJugador(rs.getString("peso"));
				jug.setIdJugador(rs.getString("idPosicionB"));
				jug.setIdJugador(rs.getString("idcategoriaB"));
				jug.setIdJugador(rs.getString("FechaRegistroJug"));
				
				listJugador.add(jug);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		finally {
			try {
				
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listJugador;
	}

	@Override
	public int createJugador(Jugador jug) {
		int salida = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		
		try {
			
			cn = MysqlConexion.getConexion();
			
			String sql = "INSERT INTO JUGADOR values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, jug.getIdEquipo());
			pstm.setString(2, jug.getIdUsuario());
			pstm.setString(3, jug.getNombres());
			pstm.setString(4, jug.getApellidos());
			pstm.setString(5, jug.getDni());
			pstm.setString(6, jug.getFecNac());
			pstm.setString(7, jug.getTelefono());
			pstm.setString(8, jug.getTalla());
			pstm.setString(9, jug.getPeso());
			pstm.setString(10, jug.getIdPosicionB());
			pstm.setString(11, jug.getIdCategoriaB());
			pstm.setString(12, jug.getFecRegJugador());
			
			salida = pstm.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		finally {
			try {
				
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public Jugador getJugador(String id) {
		Jugador jug = null;
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			
			String sql = "SELECT * FROM JUGADOR WHERE idJugador=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, id);
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				jug = new Jugador();
				
				jug.setIdJugador(rs.getString("idJugador"));
				jug.setIdJugador(rs.getString("idEquipo"));
				jug.setIdJugador(rs.getString("idUsuario"));
				jug.setIdJugador(rs.getString("nombres"));
				jug.setIdJugador(rs.getString("apellidos"));
				jug.setIdJugador(rs.getString("dni"));
				jug.setIdJugador(rs.getString("FecNac"));
				jug.setIdJugador(rs.getString("telefono"));
				jug.setIdJugador(rs.getString("talla"));
				jug.setIdJugador(rs.getString("peso"));
				jug.setIdJugador(rs.getString("idPosicionB"));
				jug.setIdJugador(rs.getString("idcategoriaB"));
				jug.setIdJugador(rs.getString("FechaRegistroJug"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return jug;
	}

	@Override
	public int editJugador(Jugador jug) {
		int salida = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			
			String sql = "update Jugador set idEquipo=?, idUsuario=?, Nombres=?, Apellidos=?, dni=?, fecNac=?, Telefono=?, Talla=?, Peso=?, idPosicionB=?, idCategoriaB=?, FechaRegistroJug=? where idJugador=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, jug.getIdEquipo());
			pstm.setString(2, jug.getIdUsuario());
			pstm.setString(3, jug.getNombres());
			pstm.setString(4, jug.getApellidos());
			pstm.setString(5, jug.getDni());
			pstm.setString(6, jug.getFecNac());
			pstm.setString(7, jug.getTelefono());
			pstm.setString(8, jug.getTalla());
			pstm.setString(9, jug.getPeso());
			pstm.setString(10, jug.getIdPosicionB());
			pstm.setString(11, jug.getIdCategoriaB());
			pstm.setString(12, jug.getFecRegJugador());
			pstm.setString(13, jug.getIdJugador());
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return salida;
	}

	@Override
	public int removeJugador(String id) {
		int salida = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			
			String sql = "DELETE FROM Jugador WHERE idJugador=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, id);
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return salida;
	}
	
	//LISTADO DE POSICION
	@Override
	public List<Posicion> listPosicion() {
		
		List<Posicion> listPosicion = new ArrayList<Posicion>();
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {			
			cn = MysqlConexion.getConexion();
			
			String sql = "SELECT * FROM POSICIONB";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Posicion pos = new Posicion();
				pos.setIdPosicion(rs.getInt("idPosicionB"));
				pos.setPosicion(rs.getString("PosicionB"));

				listPosicion.add(pos);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listPosicion;		
	}

	//LISTADO DE CATEGORIA
	@Override
	public List<Categoria> listCategoria() {
		
	List<Categoria> listCategoria = new ArrayList<Categoria>();
	
	Connection cn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	try {
		
		cn = MysqlConexion.getConexion();
		
		String sql = "SELECT * FROM CATEGORIAB";
		pstm = cn.prepareStatement(sql);
		rs = pstm.executeQuery();
		
		while (rs.next()) {
			
			Categoria cat = new Categoria();
			cat.setIdCategoria(rs.getInt("idCategoriaB"));
			cat.setCategoria(rs.getString("CategoriaB"));

			listCategoria.add(cat);			
		}		
		
	} catch (Exception e) {
		e.printStackTrace();
	}	
	
	finally {
		try {
			if(rs!=null) rs.close();
			if(pstm!=null) pstm.close();
			if(cn!=null) cn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	return listCategoria;
	}

}
