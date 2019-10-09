package usuario;

public abstract class Usuario {
	protected String nombre;
	protected String email;
	protected Integer telefono;

	public Usuario(String nombre, String email, Integer telefono) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
