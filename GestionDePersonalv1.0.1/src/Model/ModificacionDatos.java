package Model;

public class ModificacionDatos {
	private int idModificacion;
	private int idDocumento;
	private String tipoModificacion;
	private String detallesModificacion;

	// Constructor, getters y setters
	public int getIdModificacion() {
		return idModificacion;
	}

	public void setIdModificacion(int idModificacion) {
		this.idModificacion = idModificacion;
	}

	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getTipoModificacion() {
		return tipoModificacion;
	}

	public void setTipoModificacion(String tipoModificacion) {
		this.tipoModificacion = tipoModificacion;
	}

	public String getDetallesModificacion() {
		return detallesModificacion;
	}

	public void setDetallesModificacion(String detallesModificacion) {
		this.detallesModificacion = detallesModificacion;
	}

}