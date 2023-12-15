package ec.edu.ups.practica3.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ec.edu.ups.practica3.idao.IPrestamoDao;
import ec.edu.ups.practica3.modelo.Prestamo;

public class PrestamoDao implements IPrestamoDao{
	
	private List<Prestamo> listaPrestamos;
	
	public PrestamoDao() {
		listaPrestamos = new ArrayList<>();
	}
	
	@Override
	public void create(Prestamo prestamo) {
		listaPrestamos.add(prestamo);
	}

	@Override
	public Prestamo read(int id) {

		for (Prestamo prestamo : listaPrestamos) {
            if(prestamo.getId()== id){
                return prestamo;
            }
        }		
		return null;
	}

	@Override
	public boolean update(int id, Prestamo prestamo) {
		for (int i = 0; i < listaPrestamos.size(); i++) {
			Prestamo prestamoEncontrado = listaPrestamos.get(i);
            if(prestamoEncontrado.getId() == id){
            	listaPrestamos.set(i, prestamo);
                return true;
            }
            
        }return false;
        
	}

	@Override
	public boolean delete(int id) {
		Iterator<Prestamo> iterator = listaPrestamos.iterator();
	    while (iterator.hasNext()) {
	        Prestamo prestamo = iterator.next();
	        if (prestamo.getId() == id) {
	            iterator.remove();
	            return true;
	        }
	    }
	    return false;
	}

	@Override
	public List<Prestamo> findAll() {
		// TODO Auto-generated method stub
		return listaPrestamos;
	}

}
