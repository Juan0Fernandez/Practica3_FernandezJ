package ec.edu.ups.practica3.idao;

import java.util.Date;

import ec.edu.ups.practica3.modelo.Libro;

public interface IPrestableDao {
	public Libro prestar(int id);//Metodo para prestar
    public Libro devolver(int id);//Metodo para devolver
   
}
