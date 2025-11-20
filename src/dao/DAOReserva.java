/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import idao.IDAOReserva;
import java.time.LocalDate;
import modelo.Calendario;
import modelo.Maquina;
import modelo.Reserva;
import serializadora.Serializadora;
import util.ILista;
import util.Lista;

/**
 *
 * @author nataliasabogalrada
 */
public class DAOReserva implements IDAOReserva {

    Maquina[][] maquinas;

    public DAOReserva() {
        maquinas = Serializadora.getInstance().getMaquinas();
    }

    @Override
    public Calendario obtenerCalendarioDeMaquina(Maquina maquina, LocalDate fecha) {
        Lista<Calendario> calendarios = maquina.getReservasPorDias();
        for (int i = 0; i < calendarios.size(); i++) {
            Calendario calendario = calendarios.get(i);
            if (calendario.getFecha().equals(fecha)) {
                return calendario;
            }
        }
        Calendario nuevoCalendario = new Calendario(fecha);
        calendarios.add(nuevoCalendario);
        return nuevoCalendario;

    }

    @Override
    public boolean validarDisponibilidadHoras(int fila, int columna, int horaInicio, LocalDate fecha) {
        int horasDisponibles = calcularHorasDisponibles(fila, columna, fecha);
        return horasDisponibles >= 8;
    }

    @Override
    public void crearReserva(Reserva reserva, int fila, int columna) {
        Maquina maquina = maquinas[fila][columna];
        LocalDate fecha = reserva.getFecha();

        Calendario calendario = obtenerCalendarioDeMaquina(maquina, fecha);

        calendario.getListaReservas().add(reserva);
        Serializadora.getInstance().escribirMaquina();
    }

    @Override
    public void cancelarReserva(String id, int fila, int columna, LocalDate fecha) {
        Maquina maquina = maquinas[fila][columna];
        Calendario calendario = obtenerCalendarioDeMaquina(maquina, fecha);

        if (calendario == null) {
            return;
        }

        Reserva reservaCancelada = null;
        for (int i = 0; i < calendario.getListaReservas().size(); i++) {
            if (calendario.getListaReservas().get(i).getId().equals(id)) {
                calendario.getListaReservas().removeObject(reservaCancelada);
            }
        }
        Serializadora.getInstance().escribirMaquina();
    }

    @Override
    public int calcularHorasDisponibles(int fila, int columna, LocalDate fecha) {
        Maquina maquina = maquinas[fila][columna];
        Calendario calendario = obtenerCalendarioDeMaquina(maquina, fecha);

        if (calendario == null) {
            return 8;
        }

        int horasUsadas = 0;
        ILista<Reserva> reservas = calendario.getListaReservas();

        for (int i = 0; i < reservas.size(); i++) {
            horasUsadas += reservas.get(i).getCantidadHorasReserva();
        }

        return 8 - horasUsadas;
    }

    @Override
    public void agregarAColaEspera(Reserva reserva, int fila, int columna, LocalDate fecha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean hayDisponibilidad(int fila, int columna, LocalDate fecha, int horasNecesarias) {
        int horasDisponibles = calcularHorasDisponibles(fila, columna, fecha);
        return horasDisponibles >= horasNecesarias;
    }

    @Override
    public String obtenerHorasAsignadas(String id, int fila, int columna, LocalDate fecha) {
        Maquina maquina = maquinas[fila][columna];
        Calendario calendario = obtenerCalendarioDeMaquina(maquina, fecha);

        if (calendario == null) {
            return null;
        }

        int horaInicio = 0;
        ILista<Reserva> reservas = calendario.getListaReservas();

        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            if (r.getId().equals(id)) {
                int horaFin = horaInicio + r.getCantidadHorasReserva();
                return formatearHoras(horaInicio, horaFin);
            }
            horaInicio += r.getCantidadHorasReserva();
        }

        return null;
    }

    private String formatearHoras(int inicio, int fin) {
        return "De " + inicio + ":00 a " + fin + ":00";
    }

    @Override
    public String calcularProximaHoraDisponible(int fila, int columna, LocalDate fecha, int horasNecesarias) {
        Maquina maquina = maquinas[fila][columna];
        Calendario calendario = obtenerCalendarioDeMaquina(maquina, fecha);

        if (calendario == null) {
            return formatearHoras(0, horasNecesarias);
        }

        int horaInicio = 0;
        ILista<Reserva> reservas = calendario.getListaReservas();

        for (int i = 0; i < reservas.size(); i++) {
            horaInicio += reservas.get(i).getCantidadHorasReserva();
        }

        if (horaInicio + horasNecesarias > 8) {
            return null;
        }

        int horaFin = horaInicio + horasNecesarias;
        return formatearHoras(horaInicio, horaFin);
    }

}
