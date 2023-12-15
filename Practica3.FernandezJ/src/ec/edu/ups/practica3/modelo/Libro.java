package ec.edu.ups.practica3.modelo;

public class Libro {
	
	private int id;
	private String titulo;
    private String autor;			//Atributos de la clase Libro
    private int año;
    private boolean disponible = true;
	private String idUsuarioPrestamo;
    
	public Libro() {
		super();
	}
	public Libro(int id,String titulo, String autor, int año, boolean disponible) {
		super();
		this.id= id ;
		this.titulo = titulo;
		this.autor = autor;
		this.año = año;
		this.disponible = disponible;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getIdUsuarioPrestamo() {
	    return idUsuarioPrestamo;
	}

	public void setIdUsuarioPrestamo(String idUsuarioPrestamo) {
	    this.idUsuarioPrestamo = idUsuarioPrestamo;
	}
}
