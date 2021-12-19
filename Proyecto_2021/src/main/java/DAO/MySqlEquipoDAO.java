package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.MysqlConexion;
import Entities.Categoria;
import Entities.Departamento;
import Entities.Distrito;
import Entities.Equipo;
import Entities.Provincia;
import Interfaces.EquipoDAO;

public class MySqlEquipoDAO implements EquipoDAO{

	@Override
	public List<Equipo> getListEquipo() {
		List<Equipo> listEquipo = new ArrayList<Equipo>();
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "select * from equipo";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Equipo eq = new Equipo();
				eq.setIdEquipo(rs.getString("idEquipo"));
				eq.setNombreEquipo(rs.getString("nombreEquipo"));
				eq.setIdDepartamento(rs.getString("idDepartamento"));
				eq.setIdProvincia(rs.getString("idProvincia"));
				eq.setIdDistrito(rs.getString("idDistrito"));
				eq.setIdUsuario(rs.getString("idUsuario"));
				eq.setFechaRegistroEqu(rs.getString("FechaRegistroEqu"));
				
				listEquipo.add(eq);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return listEquipo;
	}

	@Override
	public int createEquipo(Equipo eq) {
		int salida = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "insert into equipo values(null,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, eq.getNombreEquipo());
			pstm.setString(2, eq.getIdDepartamento());
			pstm.setString(3, eq.getIdProvincia());
			pstm.setString(4, eq.getIdDistrito());
			pstm.setString(5, eq.getIdUsuario());
			pstm.setString(6, eq.getFechaRegistroEqu());
			
			salida = pstm.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(pstm!=null) pstm.close();
			if(cn!=null) cn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		return salida;
	}

	@Override
	public Equipo getEquipo(String idEquipo) {
		Equipo equipo = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "select * from equipo where idEquipo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, idEquipo);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				equipo = new Equipo();
				equipo.setIdEquipo(rs.getString("idEquipo"));
				equipo.setNombreEquipo(rs.getString("nombreEquipo"));
				equipo.setIdDepartamento(rs.getString("idDepartamento"));
				equipo.setIdProvincia(rs.getString("idProvincia"));
				equipo.setIdDistrito(rs.getString("idDistrito"));
				equipo.setIdUsuario(rs.getString("idUsuario"));
				equipo.setFechaRegistroEqu(rs.getString("FechaRegistroEqu"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return equipo;
	}

	@Override
	public int editEquipo(Equipo eq) {
		int salida = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "update equipo set nombreEquipo=?, idDepartamento =?, idProvincia=?, idDistrito=?, idUsuario=?, FechaRegistroEqu=? where idEquipo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, eq.getNombreEquipo());
			pstm.setString(2, eq.getIdDepartamento());
			pstm.setString(3, eq.getIdProvincia());
			pstm.setString(4, eq.getIdDistrito());
			pstm.setString(5, eq.getIdUsuario());
			pstm.setString(6, eq.getFechaRegistroEqu());
			pstm.setString(7, eq.getIdEquipo());
			salida = pstm.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(pstm!=null) pstm.close();
			if(cn!=null) cn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		return salida;
	}

	@Override
	public int removeEquipo(String idEquipo) {
		int salida = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MysqlConexion.getConexion();
			String sql = "delete from equipo where idEquipo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, idEquipo);
			
			salida = pstm.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return salida;
	}

	@Override
	public List<Departamento> listDepartamento() {
		
		List<Departamento> listDepartamento = new ArrayList<Departamento>();
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			
			String sql = "SELECT * FROM DEPARTAMENTO";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Departamento dep = new Departamento();
				dep.setIdDepartamento(rs.getInt("idDepartamento"));
				dep.setDepartamento(rs.getString("Departamento"));

				listDepartamento.add(dep);			
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
		
		return listDepartamento;
	}

	@Override
	public List<Provincia> listProvincia(int idDepartamento) {
		
		List<Provincia> listProvincia = new ArrayList<Provincia>();
		idDepartamento = 0;//15;
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			
			String sql = "SELECT * FROM PROVINCIA where idDepartamento=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, idDepartamento);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Provincia pro = new Provincia();
				pro.setIdProvincia(rs.getInt("idProvincia"));
				pro.setProvincia(rs.getString("Provincia"));
				pro.setIdDepartamento(rs.getInt("idDepartamento"));

				listProvincia.add(pro);			
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
		
		return listProvincia;
	}

	@Override
	public List<Distrito> listDistrito(int idProvincia) {
		
		List<Distrito> listDistrito = new ArrayList<Distrito>();
		idProvincia = 0;//127;
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			
			String sql = "SELECT * FROM Distrito where idProvincia=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, idProvincia);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Distrito dis = new Distrito();
				dis.setIdDistrito(rs.getInt("idDistrito"));
				dis.setDistrito(rs.getString("Distrito"));
				dis.setIdProvincia(rs.getInt("idProvincia"));

				listDistrito.add(dis);			
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
		
		return listDistrito;
	}

}
