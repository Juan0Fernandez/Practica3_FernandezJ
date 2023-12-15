package ec.edu.ups.practica3.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.practica3.idao.IBibliotecaDao;
import ec.edu.ups.practica3.modelo.Biblioteca;

public class BibliotecaDao implements IBibliotecaDao {

	 private static Biblioteca biblioteca;
	
	
	public BibliotecaDao() {
		this.biblioteca = new Biblioteca(); // o cualquier otra lógica de inicialización
	    
	}

	@Override
	public void crearBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
		
	}

	@Override
	public boolean actualizarBiblioteca(int id, Biblioteca biblioteca) {
		// Implementación para actualizar si es necesario
        if (this.biblioteca != null && this.biblioteca.getId() == id) {
            this.biblioteca = biblioteca;
            return true;
        }
        return false;
	}

	@Override
	public boolean eliminarBiblioteca(int id) {
		// Implementación para eliminar si es necesario
        if (this.biblioteca != null && this.biblioteca.getId() == id) {
            this.biblioteca = null;
            return true;
        }
        return false;
	}

	@Override
	public Biblioteca obtenerBiblioteca(int id) {
		return this.biblioteca;
	}
}
