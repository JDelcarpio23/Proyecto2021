package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DB.MysqlConexion;
import Entities.Usuario;
import Interfaces.UsuarioDAO;

public class MySqlUsuarioDAO implements UsuarioDAO{

	@Override
	public List<Usuario> getListUsuario() {
		List<Usuario> listUsuario = new ArrayList<Usuario>();
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			
			String sql = "select idusuario, Nombres, Apellidos, Correo, fecRegUsuario from usuario";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Usuario usu = new Usuario();
				usu.setIdusuario(rs.getString("idUsuario"));
				usu.setNombres(rs.getString("Nombres"));
				usu.setApellidos(rs.getString("Apellidos"));
				usu.setFecReg(rs.getString("fecRegUsuario"));
				usu.setCorreo(rs.getString("Correo"));
				
				listUsuario.add(usu);
				
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
		
		return listUsuario;
	}

	@Override
	public Usuario getUsuario(String id) {
		Usuario usuario = null;
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			
			String sql = "SELECT * FROM USUARIO WHERE idUsuario=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, id);
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setIdusuario(rs.getString("idUsuario"));
				usuario.setNombres(rs.getString("Nombres"));
				usuario.setApellidos(rs.getString("Apellidos"));
				usuario.setFecReg(rs.getString("fecRegUsuario"));
				usuario.setCorreo(rs.getString("Correo"));
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
		
		
		return usuario;
	}

}
