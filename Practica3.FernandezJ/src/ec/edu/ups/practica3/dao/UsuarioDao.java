package ec.edu.ups.practica3.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.practica3.idao.IUsuarioDao;
import ec.edu.ups.practica3.modelo.Usuario;

public class UsuarioDao implements IUsuarioDao {
	
	private List<Usuario> listaUsuarios;
	
	public UsuarioDao() {
        listaUsuarios = new ArrayList<>();
	}
	
	@Override
	public void create(Usuario usuario) {
		listaUsuarios.add(usuario);
	}
	@Override
	public Usuario read(String id) {
		for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdentificacion().equals(id)) {
                return usuario;
            }
        }
        return null;
	} 
	@Override
	public boolean update(String id,Usuario usuario) {
		for (int i = 0; i < listaUsuarios.size(); i++) {
	        Usuario usuarioEncontrado = listaUsuarios.get(i);
	        if (usuarioEncontrado.getIdentificacion().equals(id)) {
	            listaUsuarios.set(i, usuario);
	            return true;
	        }
	    }
	    return false;
		
	}

	@Override
	public boolean delete(String id) {
		for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuario = listaUsuarios.get(i);
            if(usuario.getIdentificacion().equals(id)){
                listaUsuarios.remove(i);
                return true;
            }
            
        }
        return false;
		
	}

	@Override
	public List<Usuario> findAll() {
		return listaUsuarios;
	}

}
