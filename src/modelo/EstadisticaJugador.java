package modelo;

import java.util.Objects;

public class EstadisticaJugador {

	private int id;
	private int cantGoles;
	private int cantAsistencias;
	private int cantMinutos;
	private Partido partido;

	public EstadisticaJugador(int id, int cantGoles, int cantAsistencias, int cantMinutos, Partido partido) {
		this.id = id;
		this.cantGoles = cantGoles;
		this.cantAsistencias = cantAsistencias;
		this.cantMinutos = cantMinutos;
		this.partido = partido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantGoles() {
		return cantGoles;
	}

	public void setCantGoles(int cantGoles) {
		this.cantGoles = cantGoles;
	}

	public int getCantAsistencias() {
		return cantAsistencias;
	}

	public void setCantAsistencias(int cantAsistencias) {
		this.cantAsistencias = cantAsistencias;
	}

	public int getCantMinutos() {
		return cantMinutos;
	}

	public void setCantMinutos(int cantMinutos) {
		this.cantMinutos = cantMinutos;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, cantAsistencias, cantGoles, cantMinutos, partido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadisticaJugador other = (EstadisticaJugador) obj;
		return cantAsistencias == other.cantAsistencias && cantGoles == other.cantGoles
				&& cantMinutos == other.cantMinutos && id == other.id && Objects.equals(partido, other.partido);
	}

	@Override
	public String toString() {
		return "EstadisticaJugador [id=" + id + ", cantGoles=" + cantGoles + ", cantAsistencias=" + cantAsistencias
				+ ", cantMinutos=" + cantMinutos + ", partido=" + partido + "]\n";
	}

}
