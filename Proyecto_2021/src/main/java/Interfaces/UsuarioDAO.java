package Interfaces;

import java.util.List;

import Entities.Usuario;

public interface UsuarioDAO {
	
	public List<Usuario> getListUsuario();
	public Usuario getUsuario(String id);
	
}
