package Model;

public class ControlAdministrativo {
	private int idControl;
	private int idDocumento;
	private String tipoControl;
	private String detallesControl;

	// Constructor, getters y setters
	public int getIdControl() {
		return idControl;
	}

	public void setIdControl(int idControl) {
		this.idControl = idControl;
	}

	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getTipoControl() {
		return tipoControl;
	}

	public void setTipoControl(String tipoControl) {
		this.tipoControl = tipoControl;
	}

	public String getDetallesControl() {
		return detallesControl;
	}

	public void setDetallesControl(String detallesControl) {
		this.detallesControl = detallesControl;
	}

}
