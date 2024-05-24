package Model;

public class Personal {
	private int idDocumento;
	private String tipoIdentificacion;
	private String nombre;
	private String apellido;
	private String direccion;
	private String correoElectronico;
	private String telefono;

	public Personal(int idDocumento, String tipoIdentificacion, String nombre, String apellido, String direccion,
			String correoElectronico, String telefono) {
		this.idDocumento = idDocumento;
		this.tipoIdentificacion = tipoIdentificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
	}

	// Constructor, getters y setters

	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
