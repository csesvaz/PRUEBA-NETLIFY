package es.mdef.traducpolPrueba.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class ServicioInterpretacion extends Servicio {
	private Tipo tipo;
	private String horarioInicioServicio;
	private String horarioFinServicio;
	private String provincia;
	private boolean servicioOnline;
	public Tipo getTipo() {
		return Tipo.interpretación;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getHorarioInicioServicio() {
		return horarioInicioServicio;
	}
	public void setHorarioInicioServicio(String horarioInicioServicio) {
		this.horarioInicioServicio = horarioInicioServicio;
	}
	public String getHorarioFinServicio() {
		return horarioFinServicio;
	}
	public void setHorarioFinServicio(String horarioFinServicio) {
		this.horarioFinServicio = horarioFinServicio;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public boolean isServicioOnline() {
		return servicioOnline;
	}
	public void setServicioOnline(boolean servicioOnline) {
		this.servicioOnline = servicioOnline;
	}
	
	
	
}
