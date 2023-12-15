package ec.edu.ups.practica3.test;

import java.util.ArrayList;
import java.util.Scanner;

import ec.edu.ups.practica3.controlador.BibliotecaControlador;
import ec.edu.ups.practica3.controlador.LibroControlador;
import ec.edu.ups.practica3.controlador.PrestamoControlador;
import ec.edu.ups.practica3.controlador.UsuarioControlador;
import ec.edu.ups.practica3.dao.BibliotecaDao;
import ec.edu.ups.practica3.dao.LibroDao;
import ec.edu.ups.practica3.dao.PrestamoDao;
import ec.edu.ups.practica3.dao.UsuarioDao;
import ec.edu.ups.practica3.idao.IBibliotecaDao;
import ec.edu.ups.practica3.idao.ILibroDao;
import ec.edu.ups.practica3.idao.IPrestamoDao;
import ec.edu.ups.practica3.idao.IUsuarioDao;
import ec.edu.ups.practica3.vista.VistaBiblioteca;
import ec.edu.ups.practica3.vista.VistaLibro;
import ec.edu.ups.practica3.vista.VistaPrestamo;
import ec.edu.ups.practica3.vista.VistaUsuario;

public class Main {

	public static void main(String[] args) {

		// Crear un objeto Scanner para el ingreso por consola
		Scanner entrada = new Scanner(System.in);
		IBibliotecaDao bibliotecaDao = new BibliotecaDao();
		VistaBiblioteca vistaBiblioteca = new VistaBiblioteca();
		ILibroDao libroDao = new LibroDao();
		VistaLibro vistaLibro = new VistaLibro();
		IUsuarioDao usuarioDao = new UsuarioDao();
		VistaUsuario vistaUsuario = new VistaUsuario();
		IPrestamoDao prestamoDao = new PrestamoDao();
		VistaPrestamo vistaPrestamo = new VistaPrestamo();

		BibliotecaControlador bibliotecaControlador = new BibliotecaControlador(bibliotecaDao, vistaBiblioteca);
		LibroControlador libroControlador = new LibroControlador(libroDao, vistaLibro);
		UsuarioControlador usuarioControlador = new UsuarioControlador(usuarioDao, vistaUsuario);
		PrestamoControlador prestamoControlador = new PrestamoControlador(prestamoDao, vistaPrestamo);

		//Agrego una lista de libros a la biblioteca
		libroDao.create(new ec.edu.ups.practica3.modelo.Libro(1,"El señor de los anillos", "J.R.R. Tolkien", 1954, true));
		libroDao.create(new ec.edu.ups.practica3.modelo.Libro(2,"Cien años de soledad", "Gabriel García Márquez", 1967, true));
		libroDao.create(new ec.edu.ups.practica3.modelo.Libro(3,"To Kill a Mockingbird", "Harper Lee", 1960, true));
		libroDao.create(new ec.edu.ups.practica3.modelo.Libro(4,"The Great Gatsby", "JF. Scott Fitzgerald", 1925, true));
		libroDao.create(new ec.edu.ups.practica3.modelo.Libro(5,"One Hundred Years of Solitude", "Gabriel García Márquez", 1967, true));
		libroDao.create(new ec.edu.ups.practica3.modelo.Libro(6,"Brave New World", "Aldous Huxley", 1932, true));
		libroDao.create(new ec.edu.ups.practica3.modelo.Libro(7,"The Catcher in the Rye", "J.D. Salinger", 1951, true));
		libroDao.create(new ec.edu.ups.practica3.modelo.Libro(8,"The Lord of the Rings", "J.R.R. Tolkien", 1955, true));
		libroDao.create(new ec.edu.ups.practica3.modelo.Libro(9,"Pride and Prejudice", "Jane Austen", 1954, true));
		libroDao.create(new ec.edu.ups.practica3.modelo.Libro(10,"The Hobbit", "J.R.R. Tolkien", 1937, true));
        // Agrego una lista de usuarios
        usuarioDao.create(new ec.edu.ups.practica3.modelo.Usuario("Juan Fernandez", "0101010101", "Fernandez@gmail.com"));
        usuarioDao.create(new ec.edu.ups.practica3.modelo.Usuario("Pablo Perez", "0202020202", "Perez@hotmail.com"));
		
        bibliotecaControlador.crearBiblioteca();
		
		// Variable para almacenar la opciónque ingresa el usuario
		int opcion;

		if (bibliotecaControlador.listarBiblioteca() != null) {//Si no secrea la biblioteca no se puede realizar nada 
			// Menú principal
			do {
				System.out.println("Bienvenido al Sistema de Gestión de  Biblioteca");
				System.out.println("1. Agregar Libro");
				System.out.println("2. Registrar Usuario");
				System.out.println("3. Buscar Libro");
				System.out.println("4. Prestar Libro");
				System.out.println("5. Devolver Libro");
				System.out.println("6. Salir");
				System.out.print("Ingrese una opción: ");

				// Leer la opción del usuario
				opcion = entrada.nextInt();
				entrada.nextLine(); // Consumir la nueva línea

				// Switch para manejar el menu
				switch (opcion) {
				
				case 1:
					libroControlador.crearLibro();
					libroControlador.listarLibros();
					break;

				case 2:
					usuarioControlador.crearCliente();
					usuarioControlador.listarClientes();
					break;

				case 3:
					libroControlador.buscarLibroPorId();
					break;

				case 4:
                    libroControlador.Prestar(vistaUsuario, usuarioDao, bibliotecaControlador);
                    break;

				case 5:
					libroControlador.Devolver(usuarioDao, bibliotecaControlador);
					break;

				case 6:
					System.out.println("Saliendo del sistema...");
					break;

				default:
					System.out.println("Opción no válida. Por favor intente de nuevo.");
				}
			} while (opcion != 6);
	    } else {
	        System.out.println("No se ha creado la biblioteca. Saliendo del sistema...");
	    }
		// Cerrar el objeto Scanner al salir del programa
		entrada.close();
	}
}
