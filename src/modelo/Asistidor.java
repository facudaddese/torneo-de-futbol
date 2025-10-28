package modelo;

import java.util.Objects;

public class Asistidor {

	private int cantAsistencias;
	private Jugador jugador;

	public Asistidor(int cantAsistencias, Jugador jugador) {
		this.cantAsistencias = cantAsistencias;
		this.jugador = jugador;
	}

	public int getCantAsistencias() {
		return cantAsistencias;
	}

	public void setCantAsistencias(int cantAsistencias) {
		this.cantAsistencias = cantAsistencias;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantAsistencias, jugador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asistidor other = (Asistidor) obj;
		return cantAsistencias == other.cantAsistencias && Objects.equals(jugador, other.jugador);
	}

	@Override
	public String toString() {
		return "Asistidor [cantAsistencias=" + cantAsistencias + ", jugador=" + jugador + "]\n";
	}
}
