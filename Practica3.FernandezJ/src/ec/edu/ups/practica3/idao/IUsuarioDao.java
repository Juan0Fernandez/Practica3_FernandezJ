package ec.edu.ups.practica3.idao;

import java.util.List;

import ec.edu.ups.practica3.modelo.Usuario;

public interface IUsuarioDao {

  //Métodos CRUD
    public void create(Usuario usuario);
    public Usuario read(String id);
    public boolean update(String id,Usuario usuario);
    public boolean delete(String id);   
    public List<Usuario> findAll();
}
