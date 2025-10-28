package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import modelo.*;

public class Test {

	public static void main(String[] args) {

		Sistema sist = new Sistema();

		try {
			// Agrego DT: equipo - Leones
			sist.agregarDt("Carlos", "Gómez", 12345678, LocalDate.of(1980, 6, 15), "4-4-2");
			// Tira error, anda ok
			// sist.agregarDt("Carlos", "Gómez", 12345678, LocalDate.of(1980, 6, 15),
			// "4-4-2");

			// Agrego DT: equipo - Tigres
			sist.agregarDt("Luis", "Martínez", 22345678, LocalDate.of(1978, 9, 22), "4-3-3");
			// Agrego DT: equipo - Halcones
			sist.agregarDt("Jorge", "Pérez", 32345678, LocalDate.of(1982, 3, 10), "3-5-2");
			// Agrego DT: equipo - Lobos
			sist.agregarDt("Andrés", "Suárez", 42345678, LocalDate.of(1979, 11, 3), "5-3-2");

			// System.out.println(sist.getListaDts());
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			// Agrego equipo: Leones
			sist.agregarEquipo("Leones", LocalDate.of(2010, 1, 1), "E001", sist.traerDt(12345678));
			// Tira error, anda ok
			// sist.agregarEquipo("Leones", LocalDate.of(2010, 1, 1), "E001",
			// sist.traerDt(12345678));

			// Agrego equipo: Tigres
			sist.agregarEquipo("Tigres", LocalDate.of(2012, 3, 15), "E002", sist.traerDt(22345678));
			// Agrego equipo: Halcones
			sist.agregarEquipo("Halcones", LocalDate.of(2015, 7, 20), "E003", sist.traerDt(32345678));
			// Agrego equipo: Lobos
			sist.agregarEquipo("Lobos", LocalDate.of(2013, 9, 5), "E004", sist.traerDt(42345678));

			// System.out.println(sist.getListaEquipos());
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			// Agrego jugador: equipo - Leones
			sist.agregarJugador("Juan", "Perez", 11111111, LocalDate.of(2000, 2, 10), 1.80f, 80, "Delantero", 9);
			// Tira error, anda ok
			// sist.agregarJugador("Juan", "Perez", 11111111, LocalDate.of(2000, 2, 10),
			// 1.80f, 80, "Delantero", 9);

			sist.agregarJugador("Martin", "Lopez", 22222222, LocalDate.of(1998, 6, 12), 1.82f, 84, "Defensor", 2);
			sist.agregarJugador("Lucas", "Diaz", 33333333, LocalDate.of(2001, 4, 18), 1.75f, 75, "Mediocampista", 5);
			sist.agregarJugador("Franco", "Ruiz", 44444444, LocalDate.of(1999, 11, 3), 1.85f, 83, "Arquero", 1);
			sist.agregarJugador("Agustin", "Torres", 55555555, LocalDate.of(2002, 7, 21), 1.78f, 79, "Delantero", 11);
			// Agrego jugador: equipo - Tigres
			sist.agregarJugador("Diego", "González", 66666666, LocalDate.of(1999, 2, 4), 1.83f, 78.5f, "Arquero", 1);
			sist.agregarJugador("Nicolás", "Romero", 77777777, LocalDate.of(1997, 9, 10), 1.80f, 75.0f, "Defensor", 6);
			sist.agregarJugador("Rodrigo", "Sosa", 88888888, LocalDate.of(2000, 12, 12), 1.74f, 70.3f, "Mediocampista",
					8);
			sist.agregarJugador("Matías", "Vera", 99999999, LocalDate.of(2002, 1, 5), 1.79f, 72.8f, "Delantero", 9);
			sist.agregarJugador("Pablo", "Castro", 10111111, LocalDate.of(1998, 5, 22), 1.81f, 76.4f, "Defensor", 4);
			// Agrego jugador: equipo - Halcones
			sist.agregarJugador("Emiliano", "Cabrera", 10222222, LocalDate.of(1999, 3, 14), 1.86f, 80.2f, "Arquero", 1);
			sist.agregarJugador("Javier", "Morales", 10333333, LocalDate.of(2001, 10, 19), 1.79f, 74.5f, "Defensor", 2);
			sist.agregarJugador("Gonzalo", "Rivas", 10444444, LocalDate.of(2000, 8, 30), 1.77f, 72.0f, "Mediocampista",
					8);
			sist.agregarJugador("Lautaro", "Fernández", 10555555, LocalDate.of(2003, 2, 17), 1.83f, 76.8f, "Delantero",
					9);
			sist.agregarJugador("Mateo", "Blanco", 10666666, LocalDate.of(2002, 4, 23), 1.72f, 69.4f, "Mediocampista",
					10);
			// Agrego jugador: equipo - Lobos
			sist.agregarJugador("Facundo", "Herrera", 10777777, LocalDate.of(1998, 12, 8), 1.84f, 79.1f, "Arquero", 1);
			sist.agregarJugador("Ignacio", "Ramos", 10888888, LocalDate.of(1999, 9, 1), 1.80f, 75.6f, "Defensor", 2);
			sist.agregarJugador("Tomás", "Benítez", 10999999, LocalDate.of(2000, 5, 15), 1.74f, 70.8f, "Mediocampista",
					8);
			sist.agregarJugador("Sebastián", "Luna", 11000000, LocalDate.of(2001, 7, 7), 1.81f, 74.2f, "Delantero", 9);
			sist.agregarJugador("Enzo", "Correa", 11100000, LocalDate.of(2002, 3, 28), 1.78f, 73.0f, "Defensor", 4);

			// System.out.println(sist.getListaJugadores());
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			System.out.println("--- EQUIPOS ---");
			// Agregar jugador a: equipo - Leones
			sist.agregarJugadorAEquipo(sist.traerEquipo("E001"), sist.traerJugador(11111111));
			// Tira error, anda ok
			// sist.agregarJugadorAEquipo(sist.traerEquipo("E001"),
			// sist.traerJugador(11111111));

			sist.agregarJugadorAEquipo(sist.traerEquipo("E001"), sist.traerJugador(22222222));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E001"), sist.traerJugador(33333333));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E001"), sist.traerJugador(44444444));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E001"), sist.traerJugador(55555555));
			// Agregar jugador a: equipo - Tigres
			sist.agregarJugadorAEquipo(sist.traerEquipo("E002"), sist.traerJugador(66666666));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E002"), sist.traerJugador(77777777));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E002"), sist.traerJugador(88888888));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E002"), sist.traerJugador(99999999));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E002"), sist.traerJugador(10111111));
			// Agregar jugador a: equipo - Halcones
			sist.agregarJugadorAEquipo(sist.traerEquipo("E003"), sist.traerJugador(10222222));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E003"), sist.traerJugador(10333333));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E003"), sist.traerJugador(10444444));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E003"), sist.traerJugador(10555555));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E003"), sist.traerJugador(10666666));
			// Agregar jugador a: equipo - Lobos
			sist.agregarJugadorAEquipo(sist.traerEquipo("E004"), sist.traerJugador(10777777));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E004"), sist.traerJugador(10888888));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E004"), sist.traerJugador(10999999));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E004"), sist.traerJugador(11000000));
			sist.agregarJugadorAEquipo(sist.traerEquipo("E004"), sist.traerJugador(11100000));
			System.out.println(sist.getListaEquipos());
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			// Agregar torneo
			sist.agregarTorneo("Torneo Clausura 2025", "2025", LocalDate.of(2025, 10, 1), LocalDate.of(2025, 10, 14));
			// Tira error, anda ok
			// sist.agregarTorneo("Torneo Clausura 2025", "2025", LocalDate.of(2025, 10, 1),
			// LocalDate.of(2025, 10, 14));

			// System.out.println(sist.getListaTorneos());
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			System.out.println("\n--- AGREGO EQUIPOS AL TORNEO ---");
			// Agregar equipo - Leones a torneo
			sist.agregarEquipoATorneo(sist.traerTorneo("Torneo Clausura 2025"), sist.traerEquipo("E001"));
			// Tira error, anda ok
			// sist.agregarEquipoATorneo(sist.traerTorneo("Torneo Clausura 2025"),
			// sist.traerEquipo("E001"));

			// Agregar equipo - Tigres a torneo
			sist.agregarEquipoATorneo(sist.traerTorneo("Torneo Clausura 2025"), sist.traerEquipo("E002"));
			// Agregar equipo - Halcones a torneo
			sist.agregarEquipoATorneo(sist.traerTorneo("Torneo Clausura 2025"), sist.traerEquipo("E003"));
			// Agregar equipo - Lobos a torneo
			sist.agregarEquipoATorneo(sist.traerTorneo("Torneo Clausura 2025"), sist.traerEquipo("E004"));
			System.out.println(sist.getListaTorneos());
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			System.out.println("\n--- PARTIDOS DEL TORNEO ---");
			// Primer partido: Leones - Tigres
			sist.traerTorneo("Torneo Clausura 2025").agregarPartido(
					LocalDateTime.of(LocalDate.of(2025, 10, 10), LocalTime.of(15, 0)), "Cilindro de Avellaneda",
					sist.traerEquipo("E001"), 2, sist.traerEquipo("E002"), 1);
			// Segundo partido: Halcones - Lobos
			sist.traerTorneo("Torneo Clausura 2025").agregarPartido(
					LocalDateTime.of(LocalDate.of(2025, 10, 17), LocalTime.of(16, 0)), "Maracaná",
					sist.traerEquipo("E003"), 1, sist.traerEquipo("E004"), 1);
			// Tercer partido: Leones - Halcones
			sist.traerTorneo("Torneo Clausura 2025").agregarPartido(
					LocalDateTime.of(LocalDate.of(2025, 10, 24), LocalTime.of(15, 0)), "Santiago Bernabeu",
					sist.traerEquipo("E001"), 3, sist.traerEquipo("E003"), 0);
			// Cuarto partido: Tigres - Lobos
			sist.traerTorneo("Torneo Clausura 2025").agregarPartido(
					LocalDateTime.of(LocalDate.of(2025, 10, 31), LocalTime.of(16, 0)), "Camp Nou",
					sist.traerEquipo("E002"), 0, sist.traerEquipo("E004"), 2);
			// Quinto partido: Leones - Lobos
			sist.traerTorneo("Torneo Clausura 2025").agregarPartido(
					LocalDateTime.of(LocalDate.of(2025, 10, 7), LocalTime.of(15, 30)), "Estadio de San Siro",
					sist.traerEquipo("E001"), 1, sist.traerEquipo("E004"), 3);
			// Sexto partido: Tigres - Halcones
			sist.traerTorneo("Torneo Clausura 2025").agregarPartido(
					LocalDateTime.of(LocalDate.of(2025, 10, 14), LocalTime.of(15, 30)), "Estadio Allianz Arena",
					sist.traerEquipo("E002"), 2, sist.traerEquipo("E003"), 2);
			System.out.println(sist.traerTorneo("Torneo Clausura 2025").getListaPartidos());
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("\n--- ESTADISTICAS POR PARTIDO ---\n\n--- PARTIDO 1 — LEONES 2 - 1 TIGRES ---");
		sist.traerJugador(11111111).getEstadisticas().add(new EstadisticaJugador(1, 1, 0, 90,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(0)));
		System.out.printf("Jugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(11111111).getNombre(), sist.traerJugador(11111111).getApellido(),
				sist.traerEquipo("E001").getNombre(),
				sist.traerJugador(11111111).getEstadisticas()
						.get(sist.traerJugador(11111111).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(11111111).getEstadisticas()
						.get(sist.traerJugador(11111111).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(11111111).getEstadisticas()
						.get(sist.traerJugador(11111111).getEstadisticas().size() - 1).getCantMinutos());

		// Creo la estadistica del jugador de Leones, Agustin Torres
		sist.traerJugador(55555555).getEstadisticas().add(new EstadisticaJugador(2, 1, 0, 85,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(0)));
		System.out.printf("\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(55555555).getNombre(), sist.traerJugador(55555555).getApellido(),
				sist.traerEquipo("E001").getNombre(),
				sist.traerJugador(55555555).getEstadisticas()
						.get(sist.traerJugador(55555555).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(55555555).getEstadisticas()
						.get(sist.traerJugador(55555555).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(55555555).getEstadisticas()
						.get(sist.traerJugador(55555555).getEstadisticas().size() - 1).getCantMinutos());

		// Creo la estadistica del jugador de Tigres, Matias Vera
		sist.traerJugador(99999999).getEstadisticas().add(new EstadisticaJugador(3, 1, 0, 90,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(0)));
		System.out.printf("\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(99999999).getNombre(), sist.traerJugador(99999999).getApellido(),
				sist.traerEquipo("E002").getNombre(),
				sist.traerJugador(99999999).getEstadisticas()
						.get(sist.traerJugador(99999999).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(99999999).getEstadisticas()
						.get(sist.traerJugador(99999999).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(99999999).getEstadisticas()
						.get(sist.traerJugador(99999999).getEstadisticas().size() - 1).getCantMinutos());

		System.out.println("\n\n--- PARTIDO 2 — HALCONES 1 - 1 LOBOS ---");
		// Creo la estadistica del jugador de Halcones, Lautaro Fernández
		sist.traerJugador(10555555).getEstadisticas().add(new EstadisticaJugador(4, 1, 0, 90,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(0)));
		System.out.printf("Jugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(10555555).getNombre(), sist.traerJugador(10555555).getApellido(),
				sist.traerEquipo("E003").getNombre(),
				sist.traerJugador(10555555).getEstadisticas()
						.get(sist.traerJugador(10555555).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(10555555).getEstadisticas()
						.get(sist.traerJugador(10555555).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(10555555).getEstadisticas()
						.get(sist.traerJugador(10555555).getEstadisticas().size() - 1).getCantMinutos());

		// Creo la estadistica del jugador de Lobos, Sebastián Luna
		sist.traerJugador(11000000).getEstadisticas().add(new EstadisticaJugador(5, 1, 0, 90,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(0)));
		System.out.printf("\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(11000000).getNombre(), sist.traerJugador(11000000).getApellido(),
				sist.traerEquipo("E004").getNombre(),
				sist.traerJugador(11000000).getEstadisticas()
						.get(sist.traerJugador(11000000).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(11000000).getEstadisticas()
						.get(sist.traerJugador(11000000).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(11000000).getEstadisticas()
						.get(sist.traerJugador(11000000).getEstadisticas().size() - 1).getCantMinutos());

		System.out.println("\n\n--- PARTIDO 3 — LEONES 3 - 0 HALCONES ---");
		// Creo la estadistica del jugador de Leones, Juan Perez
		sist.traerJugador(11111111).getEstadisticas().add(new EstadisticaJugador(6, 2, 0, 90,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(1)));
		System.out.printf("Jugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(11111111).getNombre(), sist.traerJugador(11111111).getApellido(),
				sist.traerEquipo("E001").getNombre(),
				sist.traerJugador(11111111).getEstadisticas()
						.get(sist.traerJugador(11111111).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(11111111).getEstadisticas()
						.get(sist.traerJugador(11111111).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(11111111).getEstadisticas()
						.get(sist.traerJugador(11111111).getEstadisticas().size() - 1).getCantMinutos());

		// Creo la estadistica del jugador de Leones, Agustin Torres
		sist.traerJugador(55555555).getEstadisticas().add(new EstadisticaJugador(7, 1, 0, 90,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(1)));
		System.out.printf("\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(55555555).getNombre(), sist.traerJugador(55555555).getApellido(),
				sist.traerEquipo("E001").getNombre(),
				sist.traerJugador(55555555).getEstadisticas()
						.get(sist.traerJugador(55555555).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(55555555).getEstadisticas()
						.get(sist.traerJugador(55555555).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(55555555).getEstadisticas()
						.get(sist.traerJugador(55555555).getEstadisticas().size() - 1).getCantMinutos());

		// PARTIDO 4 — TIGRES 0 - 2 LOBOS
		// Creo la estadistica del jugador de Lobos, Sebastian Luna
		sist.traerJugador(11000000).getEstadisticas().add(new EstadisticaJugador(8, 1, 0, 90,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(2)));
		System.out.printf("\n\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(11000000).getNombre(), sist.traerJugador(11000000).getApellido(),
				sist.traerEquipo("E004").getNombre(),
				sist.traerJugador(11000000).getEstadisticas()
						.get(sist.traerJugador(11000000).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(11000000).getEstadisticas()
						.get(sist.traerJugador(11000000).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(11000000).getEstadisticas()
						.get(sist.traerJugador(11000000).getEstadisticas().size() - 1).getCantMinutos());

		// Creo la estadistica del jugador de Lobos, Enzo Correa
		sist.traerJugador(11100000).getEstadisticas().add(new EstadisticaJugador(9, 1, 0, 90,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(2)));
		System.out.printf("\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(11100000).getNombre(), sist.traerJugador(11100000).getApellido(),
				sist.traerEquipo("E004").getNombre(),
				sist.traerJugador(11100000).getEstadisticas()
						.get(sist.traerJugador(11100000).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(11100000).getEstadisticas()
						.get(sist.traerJugador(11100000).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(11100000).getEstadisticas()
						.get(sist.traerJugador(11100000).getEstadisticas().size() - 1).getCantMinutos());

		// PARTIDO 5 — LEONES 1 - 3 LOBOS
		// Creo la estadistica del jugador de Leones, Agustin Torres
		sist.traerJugador(55555555).getEstadisticas().add(new EstadisticaJugador(10, 1, 0, 90,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(3)));
		System.out.printf("\n\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(55555555).getNombre(), sist.traerJugador(55555555).getApellido(),
				sist.traerEquipo("E001").getNombre(),
				sist.traerJugador(55555555).getEstadisticas()
						.get(sist.traerJugador(55555555).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(55555555).getEstadisticas()
						.get(sist.traerJugador(55555555).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(55555555).getEstadisticas()
						.get(sist.traerJugador(55555555).getEstadisticas().size() - 1).getCantMinutos());

		// Creo la estadistica del jugador de Lobos, Sebastian Luna
		sist.traerJugador(11000000).getEstadisticas().add(new EstadisticaJugador(11, 2, 0, 80,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(3)));
		System.out.printf("\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(11000000).getNombre(), sist.traerJugador(11000000).getApellido(),
				sist.traerEquipo("E004").getNombre(),
				sist.traerJugador(11000000).getEstadisticas()
						.get(sist.traerJugador(11000000).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(11000000).getEstadisticas()
						.get(sist.traerJugador(11000000).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(11000000).getEstadisticas()
						.get(sist.traerJugador(11000000).getEstadisticas().size() - 1).getCantMinutos());

		// Creo la estadistica del jugador de Lobos, Enzo Correa
		sist.traerJugador(11100000).getEstadisticas().add(new EstadisticaJugador(12, 1, 0, 90,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(3)));
		System.out.printf("\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(11100000).getNombre(), sist.traerJugador(11100000).getApellido(),
				sist.traerEquipo("E004").getNombre(),
				sist.traerJugador(11100000).getEstadisticas()
						.get(sist.traerJugador(11100000).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(11100000).getEstadisticas()
						.get(sist.traerJugador(11100000).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(11100000).getEstadisticas()
						.get(sist.traerJugador(11100000).getEstadisticas().size() - 1).getCantMinutos());

		// PARTIDO 6 — TIGRES 2 - 2 HALCONES
		// Creo la estadistica del jugador de Tigres, Rodrigo Sosa
		sist.traerJugador(88888888).getEstadisticas().add(new EstadisticaJugador(13, 1, 0, 80,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(4)));
		System.out.printf("\n\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(88888888).getNombre(), sist.traerJugador(88888888).getApellido(),
				sist.traerEquipo("E002").getNombre(),
				sist.traerJugador(88888888).getEstadisticas()
						.get(sist.traerJugador(88888888).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(88888888).getEstadisticas()
						.get(sist.traerJugador(88888888).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(88888888).getEstadisticas()
						.get(sist.traerJugador(88888888).getEstadisticas().size() - 1).getCantMinutos());

		// Creo la estadistica del jugador de Tigres, Matías Vera
		sist.traerJugador(99999999).getEstadisticas().add(new EstadisticaJugador(14, 1, 0, 90,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(4)));
		System.out.printf("\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(99999999).getNombre(), sist.traerJugador(99999999).getApellido(),
				sist.traerEquipo("E002").getNombre(),
				sist.traerJugador(99999999).getEstadisticas()
						.get(sist.traerJugador(99999999).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(99999999).getEstadisticas()
						.get(sist.traerJugador(99999999).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(99999999).getEstadisticas()
						.get(sist.traerJugador(99999999).getEstadisticas().size() - 1).getCantMinutos());

		// Creo la estadistica del jugador de Halcones, Gonzalo Rivas
		sist.traerJugador(10444444).getEstadisticas().add(new EstadisticaJugador(15, 1, 0, 85,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(4)));
		System.out.printf("\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(10444444).getNombre(), sist.traerJugador(10444444).getApellido(),
				sist.traerEquipo("E003").getNombre(),
				sist.traerJugador(10444444).getEstadisticas()
						.get(sist.traerJugador(10444444).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(10444444).getEstadisticas()
						.get(sist.traerJugador(10444444).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(10444444).getEstadisticas()
						.get(sist.traerJugador(10444444).getEstadisticas().size() - 1).getCantMinutos());

		// Creo la estadistica del jugador de Halcones, Lautaro Fernández
		sist.traerJugador(10555555).getEstadisticas().add(new EstadisticaJugador(16, 1, 0, 90,
				sist.traerTorneo("Torneo Clausura 2025").getListaPartidos().get(4)));
		System.out.printf("\nJugador: %s %s | Equipo: %s | Goles: %d | Asistencias: %d | Minutos jugados: %d",
				sist.traerJugador(10555555).getNombre(), sist.traerJugador(10555555).getApellido(),
				sist.traerEquipo("E003").getNombre(),
				sist.traerJugador(10555555).getEstadisticas()
						.get(sist.traerJugador(10555555).getEstadisticas().size() - 1).getCantGoles(),
				sist.traerJugador(10555555).getEstadisticas()
						.get(sist.traerJugador(10555555).getEstadisticas().size() - 1).getCantAsistencias(),
				sist.traerJugador(10555555).getEstadisticas()
						.get(sist.traerJugador(10555555).getEstadisticas().size() - 1).getCantMinutos());

		System.out.println("\n\n--- TABLA DE POSICIONES ---");
		// Muestro la tabla de posiciones
		sist.mostrarTablaPosiciones(sist.traerTorneo("Torneo Clausura 2025"));

		System.out.println("\n--- TABLA DE GOLEADORES ---");
		// Muestro la tabla de goleadores
		sist.mostrarGoleadores(sist.traerTorneo("Torneo Clausura 2025"));

	}

}
