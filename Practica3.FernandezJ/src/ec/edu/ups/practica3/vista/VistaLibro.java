package ec.edu.ups.practica3.vista;

import java.util.List;
import java.util.Scanner;

import ec.edu.ups.practica3.dao.LibroDao;
import ec.edu.ups.practica3.modelo.Libro;
import ec.edu.ups.practica3.modelo.Prestamo;
import ec.edu.ups.practica3.modelo.Usuario;

public class VistaLibro {

    private Scanner entrada;
    private VistaUsuario vistaUsuario;

    public VistaLibro(VistaUsuario vistaUsuario) {
        this.vistaUsuario = vistaUsuario;
        // ... Otros inicializadores
    }
    public VistaLibro() {
        entrada = new Scanner(System.in);
    }
    
    public Libro ingresarDatosLibro(){
    	// Agregar Libros al sistema
        System.out.println("¿Cuántos libros quiere agregar?");
        int cantidadLibros = entrada.nextInt();
        entrada.nextLine(); // Consumir la nueva línea
        Libro libro  = new Libro();
        for (int i = 0; i < cantidadLibros; i++) {
        	System.out.println("Ingrese el id del libro "+ (i + 1) + ": ");
            int id = entrada.nextInt();
            entrada.nextLine(); // Consumir la nueva línea
        	//Ingreso de Titulo,autor y Año de publicacion
            System.out.println("Ingrese título del libro " + (i + 1) + ": ");
            String titulo = entrada.nextLine();
            entrada.nextLine(); // Consumir la nueva línea
            System.out.println("Ingrese autor del libro " + (i + 1) + ": ");
            String autor = entrada.nextLine();
            
            System.out.println("Ingrese año de publicación del libro " + (i + 1) + ": ");
            int año = entrada.nextInt();
            entrada.nextLine(); // Consumir la nueva línea
            libro = new Libro(id,titulo, autor, año, true);


        }
        return libro;

    }
    
    public Libro actualizarDatosLibro(){
    	Libro libro  = new Libro();
        System.out.println("Ingrese id del libro a modificar:");
        int id = entrada.nextInt();
        entrada.nextLine(); // Consumir la nueva línea
        
      
    	//Ingreso de Titulo,autor y Año de publicacion
        System.out.println("Ingrese título del libro  a modificar: ");
        String titulo = entrada.nextLine();

        System.out.println("Ingrese autor del libro a modificar: ");
        String autor = entrada.nextLine();

        System.out.println("Ingrese año de publicación del libro a modificar: ");
        int año = entrada.nextInt();
        entrada.nextLine(); // Consumir la nueva línea
        
        System.out.println("Ingrese la disponibilidad del libro a modificar: ");
        boolean disponibilidad = entrada.nextBoolean();
        entrada.nextLine(); // Consumir la nueva línea
        return libro = new Libro(id,titulo, autor, año, disponibilidad);
    }
    
    public int eliminarDatosLibro(){
        System.out.println("------Eliminar Libro------");
        System.out.println("Ingresa el id del libro a eliminar");
        int id = entrada.nextInt();
        return id;
    }
    
    public int buscarDatosLibro(){
        System.out.println("------Buscar Libro------");
        System.out.println("Ingresa el id del Libro a buscar");
        int id = entrada.nextInt();
        return id;
    }        
    
    public void mostrarInformacionLibro (int id, String titulo, String autor,int año,boolean disponible){
        System.out.println("Datos del Libro: \n" + id + " - " + titulo + " - \n" + autor +" - " + año+" - " + disponible );
  
    }
    
    public void mostrarAlertas(String mensaje){
        System.out.println(mensaje);
    } 
    

	public int libroPrestar(List<Libro> librosDisponibles) {
	    mostrarListaLibrosDisponibles(librosDisponibles);
	    System.out.println("------Prestar Libro------");
	    System.out.println("Ingresa el id del libro a prestar");
	    int id = -1;
	    try {
	        id = entrada.nextInt();
	    } catch (java.util.InputMismatchException e) {
	        System.out.println("Error: Ingresa un valor numérico para el ID del libro.");
	        entrada.nextLine();
	    }
	    return id;
	}
	public int libroDevolver(List<Prestamo> prestamos) {
	    System.out.println("------Devolver Libro------");
	    System.out.println("Libros Prestados:");

	    for (Prestamo prestamo : prestamos) {
	        // Obtener información del libro prestado
	        Libro libroPrestado = prestamo.getLibro();
	        Usuario usuario = prestamo.getUsuario();
	        
	        mostrarInformacionLibroPrestado(libroPrestado.getId(), libroPrestado.getTitulo(), libroPrestado.getAutor(), libroPrestado.getAño(), usuario.getNombre());
	    }


	    System.out.println("Ingresa el id del libro a devolver: ");
	    int id = entrada.nextInt();
	    entrada.nextLine(); // Consumir la nueva línea

	    return id;
	}
	public void mostrarInformacionLibroPrestado(int id, String titulo, String autor, int año, String nombreUsuario) {
	    System.out.println("Datos del Libro Prestado: \n" + id + " - " + titulo + " - \n" + autor + " - " + año + " - Prestado a: " + nombreUsuario);
	}
	public void mostrarListaLibrosDisponibles(List<Libro> libros) {
	    System.out.println("Lista de Libros Disponibles:");
	    for (Libro libro : libros) {
	        mostrarInformacionLibro(libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getAño(), libro.isDisponible());
	    }
	}
    
}