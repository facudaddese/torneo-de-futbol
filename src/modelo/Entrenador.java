package modelo;

import java.time.LocalDate;
import java.util.Objects;

import exception.JugadorMenorEdadException;

public class Entrenador extends Persona {

	private String estrategia;

	public Entrenador(int id, String nombre, String apellido, long dni, LocalDate fechaNac, String estrategia)
			throws JugadorMenorEdadException {
		super(id, nombre, apellido, dni, fechaNac);
		this.estrategia = estrategia;
	}

	public String getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(estrategia);
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
		Entrenador other = (Entrenador) obj;
		return Objects.equals(estrategia, other.estrategia);
	}

	@Override
	public String toString() {
		return "Entrenador " + super.toString() + " [estrategia=" + estrategia + ", ]\n";
	}

}
