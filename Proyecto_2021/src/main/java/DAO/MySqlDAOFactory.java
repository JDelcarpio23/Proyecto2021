package DAO;

import Interfaces.AuthDAO;
import Interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new MySqlUsuarioDAO();
	}

	@Override
	public AuthDAO getAuth() {
		return new MySqlAuthDAO();
	}

}
