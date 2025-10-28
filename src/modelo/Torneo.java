package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import exception.InformacionExistenteException;

public class Torneo {

	private int id;
	private String nombre;
	private String temporada;
	private List<Equipo> equipos;
	private List<Partido> partidos;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public Torneo(int id, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
		this.nombre = nombre;
		this.temporada = temporada;
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Torneo() {
		this.equipos = new ArrayList<Equipo>();
		this.partidos = new ArrayList<Partido>();
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

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public List<Equipo> getListaEquipos() {

		if (equipos == null) {
			equipos = new ArrayList<>();
		}

		return equipos;
	}

	public void setListaEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<Partido> getListaPartidos() {

		if (partidos == null) {
			partidos = new ArrayList<>();
		}

		return partidos;
	}

	public void setListaPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, equipos, fechaFin, fechaInicio, nombre, partidos, temporada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torneo other = (Torneo) obj;
		return Objects.equals(equipos, other.equipos) && Objects.equals(fechaFin, other.fechaFin)
				&& Objects.equals(fechaInicio, other.fechaInicio) && id == other.id
				&& Objects.equals(nombre, other.nombre) && Objects.equals(partidos, other.partidos)
				&& Objects.equals(temporada, other.temporada);
	}

	@Override
	public String toString() {
		String nombresEquipos = equipos.stream().map(Equipo::getNombre).reduce((a, b) -> a + ", " + b)
				.orElse("Sin equipos");

		return "Torneo [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada + "\n, equipos=[" + nombresEquipos
				+ "]" + "\n, fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 1
	public boolean agregarPartido(LocalDateTime fecha, String estadio, Equipo equipoLocal, int golesLocal,
			Equipo equipoVisitante, int golesVisitante) throws Exception {

		if (equipoLocal.equals(equipoVisitante)) {
			throw new InformacionExistenteException("Error, <" + equipoLocal.getNombre() + "> no puede jugar contra <"
					+ equipoVisitante.getNombre() + ">");
		}

		int id = 1;

		if (!getListaPartidos().isEmpty()) {
			id = getListaPartidos().get(getListaPartidos().size() - 1).getId() + 1;
		}

		return getListaPartidos()
				.add(new Partido(id, fecha, estadio, equipoLocal, golesLocal, equipoVisitante, golesVisitante));
	}

	// FIN PUNTO 1
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 3
	public Partido traerPartido(int id) {

		Partido partido = null;
		int i = 0;
		boolean existe = false;

		while (i < partidos.size() && !existe) {
			if (partidos.get(i).getId() == id) {
				partido = partidos.get(i);
				existe = true;
			}

			i++;
		}

		return partido;
	}

	// FIN PUNTO 3
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 10
	public int calcularPuntos(Torneo torneo, Equipo equipo) {

		int puntos = 0;

		for (Partido partido : torneo.getListaPartidos()) {
			if (partido.getEquipoLocal().equals(equipo)) {
				if (partido.getGolesLocal() > partido.getGolesVisitante()) {
					puntos += 3;
				} else if (partido.getGolesLocal() == partido.getGolesVisitante()) {
					puntos += 1;
				}
			} else if (partido.getEquipoVisitante().equals(equipo)) {
				if (partido.getGolesVisitante() > partido.getGolesLocal()) {
					puntos += 3;
				} else if (partido.getGolesVisitante() == partido.getGolesLocal()) {
					puntos += 1;
				}
			}
		}

		return puntos;
	}

	// FIN PUNTO 10
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 11
	public void ordenarTabla(List<Posicion> tabla) {

		Posicion aux;

		for (int i = 0; i < tabla.size() - 1; i++) {
			for (int j = 0; j < tabla.size() - 1 - i; j++) {
				if (tabla.get(j).getPuntaje() < tabla.get(j + 1).getPuntaje()) {
					aux = tabla.get(j);
					tabla.set(j, tabla.get(j + 1));
					tabla.set(j + 1, aux);
				}
			}
		}
	}

	public List<Posicion> tablaPosiciones() {

		List<Posicion> tabla = new ArrayList<>();

		for (Equipo equipo : getListaEquipos()) {
			int puntos = calcularPuntos(this, equipo);
			tabla.add(new Posicion(equipo, puntos));
		}

		ordenarTabla(tabla);

		return tabla;
	}

	// FIN PUNTO 11
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 12
	public int totalGoles(Torneo torneo, Jugador jugador) {

		int totalGoles = 0;

		for (Partido partido : torneo.getListaPartidos()) {
			for (Jugador jug : partido.getEquipoLocal().getListaJugadores()) {
				if (jug.equals(jugador)) {
					for (EstadisticaJugador estadistica : jug.getEstadisticas()) {
						if (estadistica.getPartido().equals(partido)) {
							totalGoles += estadistica.getCantGoles();
						}
					}
				}
			}

			for (Jugador jug : partido.getEquipoVisitante().getListaJugadores()) {
				if (jug.equals(jugador)) {
					for (EstadisticaJugador estadistica : jug.getEstadisticas()) {
						if (estadistica.getPartido().equals(partido)) {
							totalGoles += estadistica.getCantGoles();
						}
					}
				}
			}
		}

		return totalGoles;
	}

	// FIN PUNTO 12
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 13
	public int totalAsistencia(Jugador jugador) {

		int cantAsistencias = 0;

		for (Partido partido : partidos) {
			for (Jugador j : partido.getEquipoLocal().getListaJugadores()) {
				if (j.equals(jugador)) {
					for (EstadisticaJugador est : j.getEstadisticas()) {
						if (est.getPartido().equals(partido)) {
							cantAsistencias += est.getCantAsistencias();
						}
					}
				}
			}
			for (Jugador j : partido.getEquipoVisitante().getListaJugadores()) {
				if (j.equals(jugador)) {
					for (EstadisticaJugador est : j.getEstadisticas()) {
						if (est.getPartido().equals(partido)) {
							cantAsistencias += est.getCantAsistencias();
						}
					}
				}
			}
		}

		return cantAsistencias;
	}

	// FIN PUNTO 13
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 14
	public void ordenarGoleadores(List<Goleador> tabla) {

		Goleador aux;

		for (int i = 0; i < tabla.size() - 1; i++) {
			for (int j = 0; j < tabla.size() - 1 - i; j++) {
				if (tabla.get(j).getCantGoles() < tabla.get(j + 1).getCantGoles()) {
					aux = tabla.get(j);
					tabla.set(j, tabla.get(j + 1));
					tabla.set(j + 1, aux);
				}
			}
		}
	}

	public List<Goleador> tablaGoleadores() {

		List<Goleador> goleadores = new ArrayList<>();

		for (Equipo equipo : equipos) {
			for (Jugador jugador : equipo.getListaJugadores()) {
				int goles = totalGoles(this, jugador);
				goleadores.add(new Goleador(goles, jugador));
			}
		}

		for (int i = 0; i < goleadores.size() - 1; i++) {
			for (int j = i + 1; j < goleadores.size(); j++) {
				if (goleadores.get(i).getCantGoles() < goleadores.get(j).getCantGoles()) {
					Goleador aux = goleadores.get(i);
					goleadores.set(i, goleadores.get(j));
					goleadores.set(j, aux);
				}
			}
		}

		return goleadores;
	}

	// FIN PUNTO 14
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 15
	public List<Asistidor> tablaAsistidores() {
		List<Asistidor> asistidores = new ArrayList<>();

		for (Equipo equipo : getListaEquipos()) {
			for (Jugador jugador : equipo.getListaJugadores()) {
				int totalAsistencias = totalAsistencia(jugador);
				if (totalAsistencias > 0) {
					asistidores.add(new Asistidor(totalAsistencias, jugador));
				}
			}
		}

		for (int i = 0; i < asistidores.size() - 1; i++) {
			for (int j = i + 1; j < asistidores.size(); j++) {
				if (asistidores.get(j).getCantAsistencias() > asistidores.get(i).getCantAsistencias()) {
					Asistidor temp = asistidores.get(i);
					asistidores.set(i, asistidores.get(j));
					asistidores.set(j, temp);
				}
			}
		}

		return asistidores;
	}

	// --------------------------------------------------------------------------------------------------------------------------------
}
