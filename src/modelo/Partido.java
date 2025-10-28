package modelo;

import java.time.LocalDateTime;
import java.util.Objects;

public class Partido {

	private int id;
	private LocalDateTime fecha;
	private String estadio;
	private Equipo equipoLocal;
	private int golesLocal;
	private Equipo equipoVisitante;
	private int golesVisitante;

	public Partido(int id, LocalDateTime fecha, String estadio, Equipo equipoLocal, int golesLocal,
			Equipo equipoVisitante, int golesVisitante) {
		this.id = id;
		this.fecha = fecha;
		this.estadio = estadio;
		this.equipoLocal = equipoLocal;
		this.golesLocal = golesLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesVisitante = golesVisitante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipoLocal, equipoVisitante, estadio, fecha, golesLocal, golesVisitante, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(equipoLocal, other.equipoLocal) && Objects.equals(equipoVisitante, other.equipoVisitante)
				&& Objects.equals(estadio, other.estadio) && Objects.equals(fecha, other.fecha)
				&& golesLocal == other.golesLocal && golesVisitante == other.golesVisitante && id == other.id;
	}

	@Override
	public String toString() {
		return "Partido [id=" + id + ", fecha=" + fecha + ", estadio=" + estadio + "\n, equipoLocal="
				+ equipoLocal.getNombre() + ", golesLocal=" + golesLocal + ", equipoVisitante="
				+ equipoVisitante.getNombre() + ", golesVisitante=" + golesVisitante + "]\n\n";
	}

}
