/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import java.time.LocalDate;
import modelo.Calendario;
import modelo.Maquina;
import modelo.Reserva;

/**
 *
 * @author nataliasabogalrada
 */
public interface IDAOReserva {

    public void crearReserva(Reserva reserva, int fila, int columna);

    public Calendario obtenerCalendarioDeMaquina(Maquina maquina, LocalDate fecha);

    public boolean validarDisponibilidadHoras(int fila, int columna, int horaInicio, LocalDate fecha);

    public void cancelarReserva(String id, int fila, int columna, LocalDate fecha);

    public int calcularHorasDisponibles(int fila, int columna, LocalDate fecha);

    public void agregarAColaEspera(Reserva reserva, int fila, int columna, LocalDate fecha);

    public boolean hayDisponibilidad(int fila, int columna, LocalDate fecha, int horasNecesarias);

    public String obtenerHorasAsignadas(String id, int fila, int columna, LocalDate fecha);
    
    public String calcularProximaHoraDisponible(int fila, int columna, LocalDate fecha, int horasNecesarias);
}
