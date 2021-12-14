package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Interfaces.AuthDAO;
import DB.MysqlConexion;
import Entities.Login;

public class MySqlAuthDAO implements AuthDAO{

	@Override
	public Login verifyAuthModel(String email, String password) {
	
		Login login = null;
		
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			
			String sql = "select * from usuario where correo=? and password=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, password);
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {

				login = new Login(rs.getString("idUsuario"), rs.getString("Nombres"), rs.getString("Apellidos"), rs.getString("Correo"), rs.getString("fecRegUsuario"), rs.getString("idCargo"), rs.getString("idDisciplina"));				
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
		
		return login;
	}

}








