package ec.edu.ups.practica3.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ec.edu.ups.practica3.idao.ILibroDao;
import ec.edu.ups.practica3.idao.IPrestableDao;
import ec.edu.ups.practica3.modelo.Libro;

public class LibroDao implements ILibroDao,IPrestableDao {

	private List<Libro> listaLibros;
	
	public LibroDao() {
        listaLibros = new ArrayList<>();
    }
	
	@Override
	public void create(Libro libro) {
		listaLibros.add(libro);
		}

	@Override
	public Libro read(int id) {
		for (Libro libro : listaLibros) {
            if(libro.getId()== id){
                return libro;
            }
        }		
		return null;
	}

	@Override
	public boolean update(int id, Libro libro) {
		
		for (int i = 0; i < listaLibros.size(); i++) {
			Libro libroEncontrado = listaLibros.get(i);
            if(libroEncontrado.getId() == id){
            	listaLibros.set(i, libro);
                return true;
            }
            
        }return false;
	}

	@Override
	public boolean delete(int id) {
		
		for (int i = 0; i < listaLibros.size(); i++) {
            Libro libro = listaLibros.get(i);
            if(libro.getId() == id){
            	listaLibros.remove(i);
                return true;
            }
            
        }
        return false;
	}

	@Override
	public List<Libro> findAll() {
		return listaLibros;
	}

	@Override
	public Libro prestar(int id) {
		for (int i = 0; i < listaLibros.size(); i++) {
	        Libro libro = listaLibros.get(i);
	        if (libro.getId() == id && libro.isDisponible()) {
	            // Cambiar la disponibilidad del libro
	            libro.setDisponible(false);
	            return libro; // Devuelve el libro prestado
	        }
	    }
	    return null;
	}

	@Override
	public Libro devolver(int id) {
	    for (Libro libro : listaLibros) {
	        if (libro.getId() == id && !libro.isDisponible()) {
	            // Cambiar la disponibilidad del libro
	            libro.setDisponible(true);
	            return libro; // Devuelve el libro devuelto
	        }
	    }
	    return null; // Devuelve null si no se puede devolver el libro
	}

	public List<Libro> findPrestados() {
	    List<Libro> librosPrestados = new ArrayList<>();
	    for (Libro libro : listaLibros) {
	        if (!libro.isDisponible()) {
	            librosPrestados.add(libro);
	        }
	    }
	    return librosPrestados;
	}
}
