package modelo;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ganador {

	private LocalDateTime fecha;
	private int cantGolesConvertidos;
	private Equipo equipo;

	public Ganador(LocalDateTime fecha, int cantGolesConvertidos, Equipo equipo) {
		this.fecha = fecha;
		this.cantGolesConvertidos = cantGolesConvertidos;
		this.equipo = equipo;
	}

	public Ganador() {
	}

	public LocalDateTime getFechaCampeonato() {
		return fecha;
	}

	public void setFechaCampeonato(LocalDateTime nuevaFecha) {
		this.fecha = nuevaFecha;
	}

	public int getCantGolesConvertidos() {
		return cantGolesConvertidos;
	}

	public void setCantGolesConvertidos(int cantGolesConvertidos) {
		this.cantGolesConvertidos = cantGolesConvertidos;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantGolesConvertidos, equipo, fecha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ganador other = (Ganador) obj;
		return cantGolesConvertidos == other.cantGolesConvertidos && Objects.equals(equipo, other.equipo)
				&& fecha == other.fecha;
	}

	@Override
	public String toString() {
		return "Ganador [fecha=" + fecha + ", cantGolesConvertidos=" + cantGolesConvertidos + ", equipo=" + equipo
				+ "]\n";
	}
}
