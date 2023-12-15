package ec.edu.ups.practica3.controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ec.edu.ups.practica3.dao.BibliotecaDao;
import ec.edu.ups.practica3.idao.IBibliotecaDao;
import ec.edu.ups.practica3.modelo.Biblioteca;
import ec.edu.ups.practica3.modelo.Libro;
import ec.edu.ups.practica3.modelo.Prestamo;
import ec.edu.ups.practica3.modelo.Usuario;
import ec.edu.ups.practica3.vista.VistaBiblioteca;

public class BibliotecaControlador {

    private IBibliotecaDao bibliotecaDao;
    private VistaBiblioteca vistaBiblioteca;
    private Biblioteca biblioteca;

    public BibliotecaControlador(IBibliotecaDao bibliotecaDao, VistaBiblioteca vistaBiblioteca) {
        super();
        this.bibliotecaDao = bibliotecaDao;
        this.vistaBiblioteca = vistaBiblioteca;
    }

    public void crearBiblioteca() {
        biblioteca = vistaBiblioteca.registroDeBiblioteca();
        bibliotecaDao.crearBiblioteca(biblioteca);
    }

    public void eliminarBiblioteca() {
        int id = vistaBiblioteca.eliminarDatosBiblioteca();
        if (bibliotecaDao.eliminarBiblioteca(id)) {
            VistaBiblioteca.mostrarAlertas("Biblioteca eliminada correctamente!");
        } else {
            VistaBiblioteca.mostrarAlertas("Ha ocurrido un error!");
        }
    }

    public Biblioteca listarBiblioteca() {
        // ... tu lógica actual
        return biblioteca; // Asegúrate de devolver la lista de bibliotecas
    }

    public void registrarPrestamo(int id, Libro libro, Usuario usuario) {
        // Verificar que el libro no sea nulo
        if (libro != null) {
            // Generar las fechas de préstamo y devolución
            Date fechaPrestamo = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaPrestamo);
            calendar.add(Calendar.DAY_OF_YEAR, 7); // Añadir 7 días para la devolución
            Date fechaDevolucion = calendar.getTime();

            // Crear el objeto Prestamo
            Prestamo prestamo = new Prestamo(id, libro, usuario, fechaPrestamo, fechaDevolucion);

            // Agregar el préstamo a la lista de préstamos de la biblioteca
            biblioteca.getListaPrestamos().add(prestamo);

            // Cambiar el estado del libro a no disponible
            libro.setDisponible(false);
        } else {
            System.out.println("Error: El libro es nulo.");
        }
    }

    public void mostrarLibrosPrestados() {
        List<Prestamo> prestamos = biblioteca.getListaPrestamos();
        if (prestamos.isEmpty()) {
            vistaBiblioteca.mostrarAlertas("No hay libros prestados actualmente.");
        } else {
            vistaBiblioteca.mostrarAlertas("Lista de Libros Prestados:");
            for (Prestamo prestamo : prestamos) {
                vistaBiblioteca.mostrarInformacionPrestamo(prestamo);
            }
        }
    }

    public List<Prestamo> obtenerPrestamos() {
        // Asegúrate de tener un atributo en tu clase Biblioteca que almacene los préstamos.
        return biblioteca.getListaPrestamos();
    }
}
	 

