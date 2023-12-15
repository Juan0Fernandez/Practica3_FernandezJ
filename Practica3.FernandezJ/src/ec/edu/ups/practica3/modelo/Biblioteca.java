package ec.edu.ups.practica3.modelo;
import java.util.ArrayList;

public class Biblioteca {
	private int id;
	private String nombre;
	private String direccion;
	private ArrayList<Libro> listaLibros = new ArrayList<>();			//Atributos de la clase Biblioteca
	private ArrayList<Usuario> listaUsuarios = new ArrayList<>();	
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
	
	public Biblioteca() {
		super();	//contructor vacio
	}	
	public Biblioteca(String nombre, String direccion, int id) {
		super();
		this.nombre = nombre;	//contructor con el nombre y direccion de la clase 
		this.direccion = direccion;
		this.id= id;
		}
	public Biblioteca(String nombre, String direccion, ArrayList<Libro> listaLibros,
			ArrayList<Usuario> listaUsuarios, ArrayList<Prestamo> listaPrestamos) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaLibros = listaLibros;			//Constructor con todos los atributos de biblioteca
		this.listaUsuarios = listaUsuarios;
		this.listaPrestamos = listaPrestamos;
		}	
	
	//metodos de encapsulamiento
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}
	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
   
    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}
	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + ", listaLibros=" + listaLibros
				+ ", listaUsuarios=" + listaUsuarios + ", listaPrestamos=" + listaPrestamos + "]";
	}	
}
