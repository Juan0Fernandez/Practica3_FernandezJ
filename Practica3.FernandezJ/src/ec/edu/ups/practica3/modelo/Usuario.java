package ec.edu.ups.practica3.modelo;

import java.util.ArrayList;


public class Usuario extends Persona{
	String correo;				//Atributos de la clase Usuario
    ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
    
    public Usuario(String nombre, String identificacion,String correo) {
    	// Constructor que utiliza atributos de la clase abstracta Persona y el atributo específico de Usuario (correo)
		super(nombre, identificacion);
		this.correo = correo; // Asignación del correo proporcionado al atributo de la clase Usuario
		   
	}
    
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public ArrayList<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}
	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}
	@Override
	public void mostrarInformacion() {
		System.out.println("Información del Usuario:");
	    System.out.println("Nombre: " + nombre);
	    System.out.println("Identificación: " + identificacion);
	    System.out.println("Correo: " + correo);
	    System.out.println("Lista de préstamos:");
	    for (Prestamo prestamo : listaPrestamos) {
	        System.out.println(prestamo);
	    }
	}
}
