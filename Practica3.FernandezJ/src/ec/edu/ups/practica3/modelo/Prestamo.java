package ec.edu.ups.practica3.modelo;

import java.time.LocalDate;
import java.util.Date;

public class Prestamo {
		private int id;
	 	private Libro libro;
	    private Usuario usuario;			//Atributos de la clase Prestamo
	    private Date fechaPrestamo;
	    private Date fechaDeVolucion;
		public Prestamo(int id, Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDeVolucion) {
			super();
			this.id = id;
			this.libro = libro;
			this.usuario = usuario;
			this.fechaPrestamo = fechaPrestamo;
			this.fechaDeVolucion = fechaDeVolucion;
		}
		
		public Prestamo(int id,Libro libro, Usuario usuario, Date fechaPrestamo) {
			super();
			this.id = id;
			this.libro = libro;
			this.usuario = usuario;
			this.fechaPrestamo = fechaPrestamo;
		}

		public Prestamo() {
			super();
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Libro getLibro() {
			return libro;
		}
		public void setLibro(Libro libro) {
			this.libro = libro;
		}
		public Usuario getUsuario() {
			return usuario;
		}
		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		public Date getFechaPrestamo() {
			return fechaPrestamo;
		}
		public void setFechaPrestamo(Date fechaPrestamo) {
			this.fechaPrestamo = fechaPrestamo;
		}
		public Date getFechaDeVolucion() {
			return fechaDeVolucion;
		}
		public void setFechaDeVolucion(Date fechaDeVolucion) {
			this.fechaDeVolucion = fechaDeVolucion;
		}
		@Override
		public String toString() {
			return "Prestamo [libro=" + libro + ", usuario=" + usuario + ", fechaPrestamo=" + fechaPrestamo
					+ ", fechaDeVolucion=" + fechaDeVolucion + "]";
		}
}
