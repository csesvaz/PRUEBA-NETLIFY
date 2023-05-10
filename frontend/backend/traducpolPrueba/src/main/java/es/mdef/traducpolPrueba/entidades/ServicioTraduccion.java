package es.mdef.traducpolPrueba.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("T")
public class ServicioTraduccion extends Servicio {
	private Tipo tipo;
	private String tipoDocumento;
	private String plazoEntrega;
	private boolean traductorJurado;
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getPlazoEntrega() {
		return plazoEntrega;
	}
	public void setPlazoEntrega(String plazoEntrega) {
		this.plazoEntrega = plazoEntrega;
	}
	public boolean isTraductorJurado() {
		return traductorJurado;
	}
	public void setTraductorJurado(boolean traductorJurado) {
		this.traductorJurado = traductorJurado;
	}
	public Tipo getTipo() {
		return Tipo.traducción;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}
