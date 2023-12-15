package ec.edu.ups.practica3.vista;

import java.util.Scanner;
import ec.edu.ups.practica3.modelo.Biblioteca;
import ec.edu.ups.practica3.modelo.Prestamo;

public class VistaBiblioteca {

    private Scanner entrada;

    public VistaBiblioteca() {
        entrada = new Scanner(System.in);
    }
    //imprime los datos para registrar una biblioteca
    public Biblioteca registroDeBiblioteca(){
        System.out.println("------ Creacion de biblioteca ------");
        System.out.println("Ingresa el nombre la nueva biblioteca");
        String nombre = entrada.nextLine();
        System.out.println("Ingresa la direccion de la biblioteca");
        String direccion = entrada.nextLine();
        System.out.println("Ingresa  id del la biblioteca");
        int id = entrada.nextInt();
        
        return new Biblioteca( nombre, direccion,id);
    }
    public Biblioteca actualizarDatosBiblioteca(){
        System.out.println("------Actualizar Biblioteca------");
        System.out.println("Ingresa el nombre la nueva biblioteca");
        String nombre = entrada.next();
        System.out.println("Ingresa la direccion de la biblioteca");
        String direccion = entrada.next();
        System.out.println("Ingresa  id del la biblioteca");
        int id = entrada.nextInt();
        
        return new Biblioteca(nombre, direccion,id);
    }
    
    public int eliminarDatosBiblioteca(){
        System.out.println("------Eliminar Biblioteca------");
        System.out.println("Ingresa el id de la Biblioteca a eliminar");
        int id = entrada.nextInt();
        return id;
    }

	public static void mostrarAlertas(String mensaje) {
		System.out.println(mensaje);
		
	}
	public void mostrarInformacionPrestamo(Prestamo prestamo) {
	    System.out.println("Prestamo: " + prestamo.toString());
	}
}