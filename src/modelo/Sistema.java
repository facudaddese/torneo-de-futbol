package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import exception.InformacionExistenteException;
import exception.JugadorMenorEdadException;

public class Sistema {

	private List<Jugador> listaJugadores;
	private List<Equipo> listaEquipos;
	private List<Entrenador> listaDts;
	private List<Torneo> listaTorneos;

	public Sistema() {
		this.listaJugadores = new ArrayList<Jugador>();
		this.listaEquipos = new ArrayList<Equipo>();
		this.listaDts = new ArrayList<Entrenador>();
		this.listaTorneos = new ArrayList<Torneo>();
	}

	public List<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	public List<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	public List<Entrenador> getListaDts() {
		return listaDts;
	}

	public void setListaDts(List<Entrenador> listaDts) {
		this.listaDts = listaDts;
	}

	public List<Torneo> getListaTorneos() {
		return listaTorneos;
	}

	public void setListaTorneos(List<Torneo> listaTorneos) {
		this.listaTorneos = listaTorneos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listaDts, listaEquipos, listaJugadores, listaTorneos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sistema other = (Sistema) obj;
		return Objects.equals(listaDts, other.listaDts) && Objects.equals(listaEquipos, other.listaEquipos)
				&& Objects.equals(listaJugadores, other.listaJugadores)
				&& Objects.equals(listaTorneos, other.listaTorneos);
	}

	@Override
	public String toString() {
		return "Sistema [listaEquipos=" + listaEquipos + ", listaJugadores=" + listaJugadores + ", listaDts=" + listaDts
				+ ", listaTorneos=" + listaTorneos + "]\n";
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 1
	public boolean agregarJugador(String nombre, String apellido, long dni, LocalDate fechaNac, float altura,
			float peso, String posicion, int dorsal) throws InformacionExistenteException, JugadorMenorEdadException {

		if (traerJugador(dni) != null) {
			throw new InformacionExistenteException(
					"Error, <" + nombre + " " + apellido + "> ya se encuentra en la lista");
		}

		int id = 1;

		if (!listaJugadores.isEmpty()) {
			id = listaJugadores.get(listaJugadores.size() - 1).getId() + 1;
		}

		return listaJugadores.add(new Jugador(id, nombre, apellido, dni, fechaNac, altura, peso, posicion, dorsal));
	}

	public boolean agregarEquipo(String nombre, LocalDate fechaFundacion, String codigo, Entrenador dt)
			throws InformacionExistenteException {

		if (traerEquipo(codigo) != null) {
			throw new InformacionExistenteException("Error, <" + nombre + "> ya se encuentra en la lista");
		}

		int id = 1;

		if (!listaEquipos.isEmpty()) {
			id = listaEquipos.get(listaEquipos.size() - 1).getId() + 1;
		}

		return listaEquipos.add(new Equipo(id, nombre, fechaFundacion, codigo, dt));
	}

	public boolean agregarJugadorAEquipo(Equipo equipo, Jugador jugador) throws InformacionExistenteException {

		boolean seAgrega = false;
		int i = 0;

		while (i < listaEquipos.size() && !seAgrega) {
			if (listaEquipos.get(i).equals(equipo)) {
				if (listaEquipos.get(i).getListaJugadores().contains(jugador)) {
					throw new InformacionExistenteException("Error, <" + jugador.getNombre() + " "
							+ jugador.getApellido() + "> ya se encuentra jugando en <" + equipo.getNombre() + ">");
				}

				listaEquipos.get(i).getListaJugadores().add(jugador);
				seAgrega = true;
			}

			i++;
		}

		return seAgrega;
	}

	public boolean agregarDt(String nombre, String apellido, long dni, LocalDate fechaNac, String estrategia)
			throws InformacionExistenteException, JugadorMenorEdadException {

		if (traerDt(dni) != null) {
			throw new InformacionExistenteException(
					"Error, <" + nombre + " " + apellido + "> ya se encuentra en la lista");
		}

		int id = 1;

		if (!listaDts.isEmpty()) {
			id = listaDts.get(listaDts.size() - 1).getId() + 1;
		}

		return listaDts.add(new Entrenador(id, nombre, apellido, dni, fechaNac, estrategia));
	}

	public boolean agregarDtAEquipo(Equipo equipo, Entrenador dt) throws InformacionExistenteException {

		boolean seAgrega = false;
		int i = 0;

		while (i < listaEquipos.size() && !seAgrega) {
			if (listaEquipos.get(i).equals(equipo)) {
				if (listaEquipos.get(i).getDt() != null && listaEquipos.get(i).getDt().equals(dt)) {
					throw new InformacionExistenteException("Error, <" + dt.getNombre() + " " + dt.getApellido()
							+ "> ya se encuentra dirigiendo a <" + equipo.getNombre() + ">");
				}

				listaEquipos.get(i).setDt(dt);
				seAgrega = true;
			}

			i++;
		}

		return seAgrega;
	}

	public boolean agregarTorneo(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin)
			throws InformacionExistenteException, JugadorMenorEdadException {

		if (traerTorneo(nombre) != null) {
			throw new InformacionExistenteException("Error, <" + nombre + "> ya se encuentra en la lista");
		}

		int id = 1;

		if (!listaTorneos.isEmpty()) {
			id = listaTorneos.get(listaTorneos.size() - 1).getId() + 1;
		}

		return listaTorneos.add(new Torneo(id, nombre, temporada, fechaInicio, fechaFin));
	}

	public boolean agregarEquipoATorneo(Torneo torneo, Equipo equipo) throws InformacionExistenteException {

		int i = 0;
		boolean seAgrega = false;

		while (i < listaTorneos.size() && !seAgrega) {
			if (listaTorneos.get(i).equals(torneo)) {
				if (listaTorneos.get(i).getListaEquipos().contains(equipo)) {
					throw new InformacionExistenteException(
							"Error, <" + equipo.getNombre() + "> ya se encuentra jugando <" + torneo.getNombre() + ">");
				}

				listaTorneos.get(i).getListaEquipos().add(equipo);
				seAgrega = true;
			}

			i++;
		}

		return seAgrega;
	}

	public boolean agregarPartidoATorneo(Torneo torneo, Partido partido) throws InformacionExistenteException {

		int i = 0;
		boolean seAgrega = false;

		while (i < listaTorneos.size() && !seAgrega) {
			if (listaTorneos.get(i).equals(torneo)) {
				if (listaTorneos.get(i).getListaPartidos().contains(partido)) {
					throw new InformacionExistenteException(
							"Error, el partido ya se encuentra registrado en el torneo");
				}

				listaTorneos.get(i).getListaPartidos().add(partido);
				seAgrega = true;
			}

			i++;
		}

		return seAgrega;
	}

	// FIN PUNTO 1
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 2
	public boolean eliminarJugador(Jugador jugador) {
		return listaJugadores.remove(jugador);
	}

	public boolean eliminarEquipo(Equipo equipo) {
		return listaEquipos.remove(equipo);
	}

	public boolean eliminarJugadorDeEquipo(Equipo equipo, Jugador jugador) {
		return equipo.getListaJugadores().remove(jugador);
	}

	public boolean eliminarDt(Entrenador dt) {
		return listaDts.remove(dt);
	}

	public boolean eliminarDtDeEquipo(Equipo equipo, Entrenador dt) {

		boolean eliminado = false;
		int i = 0;

		while (i < listaEquipos.size() && !eliminado) {
			if (listaEquipos.get(i).equals(equipo)) {
				if (listaEquipos.get(i).getDt() != null && listaEquipos.get(i).getDt().equals(dt)) {
					listaEquipos.get(i).setDt(null);
					eliminado = true;
				}
			}

			i++;
		}

		return eliminado;
	}

	public boolean eliminarTorneo(Torneo torneo) {
		return listaTorneos.remove(torneo);
	}

	public boolean eliminarEquipoDeTorneo(Torneo torneo, Equipo equipo) {

		boolean eliminado = false;
		int i = 0;

		while (i < listaTorneos.size() && !eliminado) {
			if (listaTorneos.get(i).equals(torneo)) {
				if (listaTorneos.get(i).getListaEquipos().contains(equipo)) {
					listaTorneos.get(i).getListaEquipos().remove(equipo);
					eliminado = true;
				}
			}

			i++;
		}

		return eliminado;
	}

	public boolean eliminarPartidoDeTorneo(Torneo torneo, Partido partido) {

		boolean eliminado = false;
		int i = 0;

		while (i < listaTorneos.size() && !eliminado) {
			if (listaTorneos.get(i).equals(torneo)) {
				if (listaTorneos.get(i).getListaPartidos().contains(partido)) {
					listaTorneos.get(i).getListaPartidos().remove(partido);
					eliminado = true;
				}
			}

			i++;
		}

		return eliminado;
	}

	// FIN PUNTO 2
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 3
	public Jugador traerJugador(long dni) {

		int i = 0;
		boolean encontrado = false;
		Jugador jugador = null;

		while (i < listaJugadores.size() && !encontrado) {
			if (listaJugadores.get(i).getDni() == dni) {
				jugador = listaJugadores.get(i);
				encontrado = true;
			}

			i++;
		}

		return jugador;
	}

	public Equipo traerEquipo(String codigo) {

		int i = 0;
		boolean encontrado = false;
		Equipo equipo = null;

		while (i < listaEquipos.size() && !encontrado) {
			if (listaEquipos.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				equipo = listaEquipos.get(i);
				encontrado = true;
			}

			i++;
		}

		return equipo;
	}

	public Entrenador traerDt(long dni) {

		int i = 0;
		boolean encontrado = false;
		Entrenador dt = null;

		while (i < listaDts.size() && !encontrado) {
			if (listaDts.get(i).getDni() == dni) {
				dt = listaDts.get(i);
				encontrado = true;
			}

			i++;
		}

		return dt;
	}

	public Torneo traerTorneo(String nombre) {

		int i = 0;
		boolean encontrado = false;
		Torneo torneo = null;

		while (i < listaTorneos.size() && !encontrado) {
			if (listaTorneos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				torneo = listaTorneos.get(i);
				encontrado = true;
			}

			i++;
		}

		return torneo;
	}

	// FIN PUNTO 3
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 4
	public List<Ganador> traerListaEquiposGanadores(Torneo torneo, LocalDateTime fecha) {

		List<Ganador> ganadores = new ArrayList<>();

		for (Torneo t : listaTorneos) {
			if (t.equals(torneo)) {
				for (Partido partido : t.getListaPartidos()) {
					if (partido.getFecha().isEqual(fecha)) {

						Equipo equipoGanador = null;
						int golesConvertidos = 0;

						if (partido.getGolesLocal() > partido.getGolesVisitante()) {
							equipoGanador = partido.getEquipoLocal();
							golesConvertidos = partido.getGolesLocal();
						} else if (partido.getGolesVisitante() > partido.getGolesLocal()) {
							equipoGanador = partido.getEquipoVisitante();
							golesConvertidos = partido.getGolesVisitante();
						}

						if (equipoGanador != null) {
							ganadores.add(new Ganador(partido.getFecha(), golesConvertidos, equipoGanador));
						}
					}
				}
			}
		}

		return ganadores;
	}

	// FIN PUNTO 4
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 5
	public List<Entrenador> traerListaEntrenadoresPorEstrategia(String estrategia) {

		List<Entrenador> entrenadores = new ArrayList<>();

		for (Equipo equipo : listaEquipos) {
			if (equipo.getDt().getEstrategia().equalsIgnoreCase(estrategia)) {
				entrenadores.add(equipo.getDt());
			}
		}

		return entrenadores;
	}

	// FIN PUNTO 5
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 6
	public List<Jugador> traerListaJugadoresPorFechaNac(LocalDate desde, LocalDate hasta) {

		List<Jugador> jugadores = new ArrayList<>();

		for (Jugador jugador : listaJugadores) {
			if (jugador.getFechaNac().isBefore(hasta) && jugador.getFechaNac().isAfter(desde)) {
				jugadores.add(jugador);
			}
		}

		return jugadores;
	}

	// FIN PUNTO 6
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 7
	public List<Equipo> traerListaEquiposPorFechaFundacion(LocalDate hasta) {

		List<Equipo> equipos = new ArrayList<>();

		for (Equipo equipo : listaEquipos) {
			if (equipo.getFechaFundacion().isBefore(hasta)) {
				equipos.add(equipo);
			}
		}

		return equipos;
	}

	// FIN PUNTO 7
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 8
	public float promedioAlturaDeEquipo(Equipo equipo) {

		float altura = 0;
		int cant = 0;
		int i = 0;
		boolean encontrado = false;

		while (i < listaEquipos.size() && !encontrado) {
			if (listaEquipos.get(i).equals(equipo)) {
				encontrado = true;
				for (Jugador jugador : listaEquipos.get(i).getListaJugadores()) {
					altura += jugador.getAltura();
					cant++;
				}
			}

			i++;
		}

		return altura / cant;
	}

	// FIN PUNTO 8
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 9
	public Equipo equipoConMayorAltura() {

		Equipo equipo = null;
		float mayorAltura = 0;

		for (Equipo equipoAux : listaEquipos) {
			float altura = promedioAlturaDeEquipo(equipoAux);

			if (altura > mayorAltura) {
				equipo = equipoAux;
				mayorAltura = altura;
			}
		}

		return equipo;
	}

	// FIN PUNTO 9
	// --------------------------------------------------------------------------------------------------------------------------------
	// A PARTIR DE ACA EMPIEZA EL PUNTO 11
	public void mostrarTablaPosiciones(Torneo torneo) {

		List<Posicion> tabla = torneo.tablaPosiciones();

		int pos = 1;

		for (Posicion posicion : tabla) {
			System.out.println(pos + "° " + posicion.getEquipo().getNombre() + " - " + posicion.getPuntaje() + " pnts");
			pos++;
		}
	}

	public void mostrarGoleadores(Torneo torneo) {

		List<Goleador> goleadores = new ArrayList<>();

		for (Equipo equipo : torneo.getListaEquipos()) {
			for (Jugador jugador : equipo.getListaJugadores()) {
				int goles = 0;

				if (jugador.getEstadisticas() != null) {
					for (EstadisticaJugador estadistica : jugador.getEstadisticas()) {
						goles += estadistica.getCantGoles();
					}
				}

				if (goles > 0) {
					goleadores.add(new Goleador(goles, jugador));
				}
			}
		}

		torneo.ordenarGoleadores(goleadores);

		for (Goleador goleador : goleadores) {
			System.out.printf(goleador.getJugador().getNombre() + " " + goleador.getJugador().getApellido() + ": "
					+ goleador.getCantGoles() + " goles\n");
		}
	}

	// FIN PUNTO 11
	// --------------------------------------------------------------------------------------------------------------------------------

}