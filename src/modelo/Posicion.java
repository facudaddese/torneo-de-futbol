package modelo;

import java.util.Objects;

public class Posicion {

	private Equipo equipo;
	private int puntaje;

	public Posicion(Equipo equipo, int puntaje) {
		this.equipo = equipo;
		this.puntaje = puntaje;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipo, puntaje);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return Objects.equals(equipo, other.equipo) && puntaje == other.puntaje;
	}

	@Override
	public String toString() {
		return "Posicion [equipo=" + equipo + ", puntaje=" + puntaje + "]\n";
	}

}
