package ec.edu.ups.practica3.idao;

import java.util.List;

import ec.edu.ups.practica3.modelo.Prestamo;

public interface IPrestamoDao {
	 	public void create(Prestamo prestamo);
	    public Prestamo read(int id);
	    public boolean update(int id,Prestamo prestamo);
	    public boolean delete(int id);   
	    public List<Prestamo> findAll();
}
