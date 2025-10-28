package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import exception.JugadorMenorEdadException;

public class Jugador extends Persona {

	private float altura;
	private float peso;
	private String posicion;
	private int dorsal;
	private List<EstadisticaJugador> estadisticas;

	public Jugador(int id, String nombre, String apellido, long dni, LocalDate fechaNac, float altura, float peso,
			String posicion, int dorsal) throws JugadorMenorEdadException {
		super(id, nombre, apellido, dni, fechaNac);
		this.altura = altura;
		this.peso = peso;
		this.posicion = posicion;
		this.dorsal = dorsal;
	}

	public Jugador(int id, String nombre, String apellido, long dni, LocalDate fechaNac)
			throws JugadorMenorEdadException {
		super(id, nombre, apellido, dni, fechaNac);
		this.estadisticas = new ArrayList<EstadisticaJugador>();
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public List<EstadisticaJugador> getEstadisticas() {

		if (estadisticas == null) {
			this.estadisticas = new ArrayList<>();
		}

		return estadisticas;
	}

	public void setEstadisticas(List<EstadisticaJugador> estadisticas) {
		this.estadisticas = estadisticas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(altura, dorsal, estadisticas, peso, posicion);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Float.floatToIntBits(altura) == Float.floatToIntBits(other.altura) && dorsal == other.dorsal
				&& Objects.equals(estadisticas, other.estadisticas)
				&& Float.floatToIntBits(peso) == Float.floatToIntBits(other.peso)
				&& Objects.equals(posicion, other.posicion);
	}

	@Override
	public String toString() {
		return "Jugador " + super.toString() + "\n [altura=" + altura + ", peso=" + peso + ", posicion=" + posicion
				+ ", dorsal=" + dorsal + ", estadisticas=" + estadisticas + ", ]\n\n";
	}

}
