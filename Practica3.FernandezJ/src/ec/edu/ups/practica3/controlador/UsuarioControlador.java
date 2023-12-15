package ec.edu.ups.practica3.controlador;

import java.util.List;

import ec.edu.ups.practica3.dao.UsuarioDao;
import ec.edu.ups.practica3.idao.IUsuarioDao;
import ec.edu.ups.practica3.modelo.Usuario;
import ec.edu.ups.practica3.vista.VistaUsuario;

public class UsuarioControlador {

	private IUsuarioDao usuarioDao;
	private VistaUsuario vistaUsuario;
	private Usuario usuario;
	public UsuarioControlador(IUsuarioDao usuarioDao, VistaUsuario vistaUsuario) {
        this.usuarioDao = usuarioDao;
        this.vistaUsuario = vistaUsuario;        
    }    
    public void crearCliente(){
        usuario = vistaUsuario.registroDeUsuario();
        usuarioDao.create(usuario);
    }    
    public void actualizarCliente(){
    	usuario = vistaUsuario.actualizarDatosUsuario();
        if(usuarioDao.update(usuario.getIdentificacion() , usuario) == true){
        	vistaUsuario.mostrarAlertas("Cliente actualizado correctamente!");                    
        }else{
        	vistaUsuario.mostrarAlertas("Ha ocurrido un error!");                    
        }            
    }    
    public void eliminarCliente(){
        String id = vistaUsuario.eliminarDatosUsuario();
        if(usuarioDao.delete(id) == true){
        	vistaUsuario.mostrarAlertas("Cliente eliminado correctamente!");                    
        }else{
        	vistaUsuario.mostrarAlertas("Ha ocurrido un error!");
        }
    }    
    public void buscarClientePorId(){
        String id = vistaUsuario.buscarDatosUsuario();
        usuario = usuarioDao.read(id);
        if(usuario == null){
        	vistaUsuario.mostrarAlertas("Cliente no encontrado");
        }else{
        	vistaUsuario.mostrarInformacionUsuario(usuario.getNombre(),usuario.getIdentificacion(),usuario.getCorreo());
        }
    }
    
    public void listarClientes(){
        List<Usuario> listaUsuarios = usuarioDao.findAll();
        for (Usuario usuario : listaUsuarios) {
        	vistaUsuario.mostrarInformacionUsuario(usuario.getNombre(),usuario.getIdentificacion(),usuario.getCorreo());
        }
    }
}
