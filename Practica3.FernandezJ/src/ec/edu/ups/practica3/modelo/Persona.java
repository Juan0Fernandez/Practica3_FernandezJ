package ec.edu.ups.practica3.modelo;

public abstract class Persona {
	protected String nombre;
	//atributos de clase abstracta persona
	protected String identificacion;
	
	public Persona() {
		}
    
    
	public Persona(String nombre, String identificacion) {
		
		this.nombre = nombre;
		this.identificacion = identificacion;
	}

	//metodos de encapsulamiento

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public abstract void mostrarInformacion();
    //Metodo abstracto que se usara en la calse usuario	
}
