package DAO;

import Interfaces.AuthDAO;

import Interfaces.EquipoDAO;

import Interfaces.JugadorDAO;

import Interfaces.UsuarioDAO;

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	public static final int AZURECOSMOS = 2;
	public static final int SQLSERVER = 3;
	 
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract AuthDAO getAuth();

	public abstract EquipoDAO getEquipoDAO();

	public abstract JugadorDAO getJugadorDAO();

	
	public static DAOFactory getDAOFactory(int tipo) {
		
		switch (tipo) {
			case MYSQL:
				return new MySqlDAOFactory();
			case AZURECOSMOS:
				return null;
			case SQLSERVER:
				return null;
		}
		
		return null;
		
	}
	
}
