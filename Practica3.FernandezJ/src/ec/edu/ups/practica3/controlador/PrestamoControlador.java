package ec.edu.ups.practica3.controlador;
import java.util.List;

import ec.edu.ups.practica3.idao.IPrestamoDao;
import ec.edu.ups.practica3.modelo.Prestamo;
import ec.edu.ups.practica3.vista.VistaPrestamo;

public class PrestamoControlador {
	private IPrestamoDao prestamoDao;
    private VistaPrestamo prestamoVista;
    private Prestamo prestamo;
    public PrestamoControlador(IPrestamoDao prestamoDao, VistaPrestamo prestamoVista) {
        this.prestamoDao = prestamoDao;
        this.prestamoVista = prestamoVista;        
    }
    public void crearPrestamo(){
    	prestamo = prestamoVista.ingresarDatosPrestamo();
    	prestamoDao.create(prestamo);
    }
    public void actualizarPrestamo(){
    	prestamo = prestamoVista.actualizarDatosPrestamo();
        if(prestamoDao.update(prestamo.getId(), prestamo) == true){
        	prestamoVista.mostrarAlertas("Prestamo actualizado correctamente!");                    
        }else{prestamoVista.mostrarAlertas("Ha ocurrido un error!");                    
        }            
    }
    public void eliminarPrestamo(){
        int id = prestamoVista.eliminarDatosPrestamo();
        if(prestamoDao.delete(id) == true){
        	prestamoVista.mostrarAlertas("Prestamo eliminado correctamente!");                    
        }else{prestamoVista.mostrarAlertas("Ha ocurrido un error!");
        }
    }
    public void buscarPrestamoPorId(){
        int id = prestamoVista.buscarDatosCliente();
        prestamo = prestamoDao.read(id);
        if(prestamo == null){
        	prestamoVista.mostrarAlertas("Prestamo no encontrado");
        }else{prestamoVista.mostrarInformacionPrestamo(prestamo.getId(),prestamo.getLibro(),prestamo.getUsuario(),prestamo.getFechaPrestamo(),prestamo.getFechaDeVolucion());
        }
    }
    public void listarPrestamo(){
        List<Prestamo> listaPrestamos = prestamoDao.findAll();
        for (Prestamo prestamo : listaPrestamos) {
        	prestamoVista.mostrarInformacionPrestamo(prestamo.getId(), prestamo.getLibro(),prestamo.getUsuario(),prestamo.getFechaPrestamo(),prestamo.getFechaDeVolucion());
        }
    }
}
