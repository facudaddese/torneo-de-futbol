package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {

	private int id;
	private String nombre;
	private String codigo;
	private LocalDate fechaFundacion;
	private List<Jugador> jugadores;
	private Entrenador dt;

	public Equipo(int id, String nombre, LocalDate fechaFundacion, String codigo, Entrenador dt) {
		this.id = id;
		this.nombre = nombre;
		this.fechaFundacion = fechaFundacion;
		this.codigo = codigo;
		this.dt = dt;
	}
	
	public Equipo() {
		this.jugadores = new ArrayList<Jugador>();
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

	public LocalDate getFechaFundacion() {
		return fechaFundacion;
	}

	public void setfechaFundacion(LocalDate fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Jugador> getListaJugadores() {
		
		if(jugadores == null) {
			this.jugadores = new ArrayList<>();
		}
		return jugadores;
	}

	public void setListaJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Entrenador getDt() {
		return dt;
	}

	public void setDt(Entrenador dt) {
		this.dt = dt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, codigo, dt, fechaFundacion, jugadores, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(dt, other.dt)
				&& Objects.equals(fechaFundacion, other.fechaFundacion) && id == other.id
				&& Objects.equals(jugadores, other.jugadores) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Equipo [");
		sb.append("id=").append(id).append(", nombre=").append(nombre).append(", codigo=").append(codigo)
				.append(", fechaFundacion=").append(fechaFundacion).append("\n");

		sb.append("   jugadores=[\n");
		for (Jugador j : jugadores) {
			sb.append("      ").append(j).append("");
		}
		sb.append("   ]");

		if (dt != null) {
			sb.append("   dt=[nombre=").append(dt.getNombre()).append(", apellido=").append(dt.getApellido())
					.append(", dni=").append(dt.getDni()).append(", tacticaPreferida=").append(dt.getEstrategia())
					.append("]\n");
		} else {
			sb.append("   dt=Sin DT\n");
		}

		sb.append("]\n\n");
		return sb.toString();
	}

}
