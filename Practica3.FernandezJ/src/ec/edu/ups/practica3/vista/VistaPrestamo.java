package ec.edu.ups.practica3.vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ec.edu.ups.practica3.modelo.Libro;
import ec.edu.ups.practica3.modelo.Prestamo;
import ec.edu.ups.practica3.modelo.Usuario;

public class VistaPrestamo {

	 private Scanner entrada;

	    public VistaPrestamo() {
	        entrada = new Scanner(System.in);
	    }
	    public Prestamo ingresarDatosPrestamo(){
	    	Prestamo prestamo = new Prestamo();
			System.out.println("Ingrese los datos del préstamo:");
			System.out.print("ID del préstamo: ");
			prestamo.setId(entrada.nextInt());

			// Agregar lógica para ingresar el título del libro
			System.out.print("Título del libro: ");
			String tituloLibro = entrada.next();
			Libro libro = new Libro(0, tituloLibro, null, 0, false);
			prestamo.setLibro(libro);
			// Agregar lógica para ingresar el nombre del usuario
			System.out.print("Nombre del usuario: ");
			String nombreUsuario = entrada.next();
			Usuario usuario = new Usuario(null, nombreUsuario, null);
			prestamo.setUsuario(usuario);
			// Agregar lógica para ingresar la fecha de préstamo
			System.out.print("Fecha de préstamo (yyyy-MM-dd): ");
			String fechaStr = entrada.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date fechaPrestamo = dateFormat.parse(fechaStr);
				prestamo.setFechaPrestamo(fechaPrestamo);
			} catch (ParseException e) {
				System.out.println("Error al convertir la fecha. Se utilizará la fecha actual.");
				prestamo.setFechaPrestamo(new Date());
			}
			return prestamo;
		}	    
	    public Prestamo actualizarDatosPrestamo(){
	    	Prestamo prestamo = new Prestamo();

			System.out.println("Ingrese los nuevos datos del préstamo:");
			System.out.print("ID del préstamo a actualizar: ");
			prestamo.setId(entrada.nextInt());
			System.out.print("Nuevo título del libro: ");// Agregar lógica para ingresar el nuevo título del libro
			String tituloLibro = entrada.next();
			Libro libro = new Libro(0, tituloLibro, null, 0, false);
			prestamo.setLibro(libro);
			// Agregar lógica para ingresar el nuevo nombre del usuario
			System.out.print("Nuevo nombre del usuario: ");
			String nombreUsuario = entrada.next();
			Usuario usuario = new Usuario(null, nombreUsuario, null);
			prestamo.setUsuario(usuario);
			// Agregar lógica para actualizar la fecha de préstamo
			System.out.print("Nueva fecha de préstamo (yyyy-MM-dd): ");
			String fechaStr = entrada.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date fechaPrestamo = dateFormat.parse(fechaStr);
				prestamo.setFechaPrestamo(fechaPrestamo);
			} catch (ParseException e) {
				System.out.println("Error al convertir la fecha. Se utilizará la fecha actual.");
				prestamo.setFechaPrestamo(new Date());
			}return prestamo;
	    }
	    public int eliminarDatosPrestamo(){
	        System.out.println("------Eliminar Prestamo------");
	        System.out.println("Ingresa el id del Prestamo a eliminar");
	        int id = entrada.nextInt();
	        return id;
	    }
	    public int buscarDatosCliente(){
	        System.out.println("------Buscar Prestamo------");
	        System.out.println("Ingresa el id del prestamo a buscar");
	        int id = entrada.nextInt();
	        return id;
	    }
	    public void mostrarInformacionPrestamo(int id, Libro libro, Usuario usuario,Date fechaPrestamo, Date fechaDeVolucion){
	        System.out.println("Datos del Prestamo: \n" + id + " - " + libro + " - " + usuario + " - " + fechaPrestamo+ " - " + fechaDeVolucion);
	    }
	    
	    public void mostrarAlertas(String mensaje){
	        System.out.println(mensaje);
	    }	    
}
