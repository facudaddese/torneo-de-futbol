package modelo;

import java.time.LocalDate;
import java.util.Objects;

import exception.JugadorMenorEdadException;

public abstract class Persona {

	protected int id;
	protected String nombre;
	protected String apellido;
	protected long dni;
	protected LocalDate fechaNac;

	public Persona(int id, String nombre, String apellido, long dni, LocalDate fechaNac)
			throws JugadorMenorEdadException {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		setFechaNac(fechaNac);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) throws JugadorMenorEdadException {

		if (fechaNac.isAfter(LocalDate.now().minusYears(18))) {
			throw new JugadorMenorEdadException("Error, el jugador debe ser mayor de edad");
		}

		this.fechaNac = fechaNac;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, fechaNac, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && dni == other.dni && Objects.equals(fechaNac, other.fechaNac)
				&& id == other.id && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "[id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNac="
				+ fechaNac + "]";
	}

}
