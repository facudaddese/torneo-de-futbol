package modelo;

import java.util.Objects;

public class Goleador {

	private int cantGoles;
	private Jugador jugador;

	public Goleador(int cantGoles, Jugador jugador) {
		this.cantGoles = cantGoles;
		this.jugador = jugador;
	}

	public int getCantGoles() {
		return cantGoles;
	}

	public void setCantGoles(int cantGoles) {
		this.cantGoles = cantGoles;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantGoles, jugador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goleador other = (Goleador) obj;
		return cantGoles == other.cantGoles && Objects.equals(jugador, other.jugador);
	}

	@Override
	public String toString() {
		return "Goleador [cantGoles=" + cantGoles + ", jugador=" + jugador + "]\n";
	}

}
