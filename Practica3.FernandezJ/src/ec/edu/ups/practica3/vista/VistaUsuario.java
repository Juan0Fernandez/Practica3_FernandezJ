package ec.edu.ups.practica3.vista;

import java.util.List;
import java.util.Scanner;

import ec.edu.ups.practica3.modelo.Biblioteca;
import ec.edu.ups.practica3.modelo.Usuario;

public class VistaUsuario {

	public Scanner entrada;

	public VistaUsuario () {
		entrada = new Scanner(System.in);
	}
    public Usuario registroDeUsuario(){
        System.out.println("------ Creacion de Usuario ------");
        System.out.println("Ingresa el nombre del usuario: ");
        String nombre = entrada.nextLine();
        entrada.nextLine(); // Consumir la nueva línea
        System.out.println("Ingresa el identificacion del usuraio: ");
        String identificacion = entrada.nextLine();
        System.out.println("Ingresa el correo del usuario: ");
        String correo = entrada.nextLine();
        entrada.nextLine(); // Consumir la nueva línea
        return new Usuario(nombre,identificacion,correo);
    }
    public	Usuario actualizarDatosUsuario(){
        System.out.println("------Actualizar usuario------");
        System.out.println("Ingresa el nombre del usuario a actualizar: ");
        String nombre = entrada.next();
        System.out.println("Ingresa el identificacion del usuraio a actualizar: ");
        String identificacion = entrada.next();
        System.out.println("Ingresa el correo del usuario a actualizar: ");
        String correo = entrada.nextLine();
        entrada.nextLine(); // Consumir la nueva línea
        return new Usuario(nombre, identificacion,correo);
    }
    public String eliminarDatosUsuario(){
        System.out.println("------Eliminar Usuario------");
        System.out.println("Ingresa el id del cliente a eliminar");
        String id = entrada.nextLine();
        return id;
    }
    
    public String buscarDatosUsuario() {
    	System.out.println("------Buscar Usuario------");
        System.out.println("Ingresa el id del usuario a buscar");
        String id = entrada.nextLine();
        return id;
    }
    
    public void mostrarInformacionUsuario(String nombre, String identificacion, String correo){
        System.out.println("Datos del Usuario: \n" + nombre + " - " + identificacion + " - " + correo);
    }
	public static void mostrarAlertas(String mensaje) {
		System.out.println(mensaje);
	}
	
	public void mostrarListaUsuarios(List<Usuario> listaUsuarios) {
		System.out.println("------ Lista de Usuarios ------");
	    for (Usuario usuario : listaUsuarios) {
	        mostrarInformacionUsuario(usuario);
	    }
    }
	public String solicitarUsuarioPrestamo(List<Usuario> listaUsuarios) {
		// Mostrar la lista de usuarios
	    System.out.println("------ Lista de Usuarios ------");
	    for (Usuario usuario : listaUsuarios) {
	        System.out.println("Identificación: " + usuario.getIdentificacion() + " - Nombre: " + usuario.getNombre());
	    }

	    // Solicitar la identificación del usuario al que se prestará el libro
	    System.out.print("Ingrese la identificación del usuario al que se prestará el libro: ");
	    Scanner scanner = new Scanner(System.in);
	    String identificacionUsuario = scanner.nextLine();

	    return identificacionUsuario;
	}
	public void mostrarInformacionUsuario(Usuario usuario) {
	    System.out.println("Datos del Usuario: ");
	    System.out.println(usuario.getNombre() + " - " + usuario.getIdentificacion() + " - " + usuario.getCorreo());
	}
	public void mostrarInformacionLibroPrestado(int id, String titulo, String autor, int año, String nombreUsuario) {
	    System.out.println("Datos del Libro Prestado: \n" + id + " - " + titulo + " - \n" + autor + " - " + año + " - Prestado a: " + nombreUsuario);
	}
	
}
