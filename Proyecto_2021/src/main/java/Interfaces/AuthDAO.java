package Interfaces;

import Entities.Login;

public interface AuthDAO {
	
	public Login verifyAuthModel(String email, String password);
	
}
