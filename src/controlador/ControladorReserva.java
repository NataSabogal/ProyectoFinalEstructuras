/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DAOMaquina;
import dao.DAOReserva;
import idao.IDAOMaquina;
import idao.IDAOReserva;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import modelo.Maquina;
import modelo.Reserva;

/**
 *
 * @author nataliasabogalrada
 */
public class ControladorReserva {

    IDAOReserva dao;
    IDAOMaquina daoM;

    public ControladorReserva() {
        dao = new DAOReserva();
        daoM = new DAOMaquina();
    }

    public Maquina entregarMaquina (int fila, int columna){
        return daoM.entregarMaquina(fila, columna);
    }
    public void crearReserva(Reserva reserva, int fila, int columna) {

        if (!daoM.estaRegistrada(fila, columna)) {
            throw new RuntimeException("La máquina no está registrada");
        }

        Maquina maquina = daoM.entregarMaquina(fila, columna);
        if (reserva.getCliente().getEdad() < maquina.getEdadMinima()) {
            throw new RuntimeException("No cumples con la edad mínima para esta máquina");
        }

        dao.crearReserva(reserva, fila, columna);
    }

    public void cancelarReserva(String idReserva, int fila, int columna, LocalDate fechaReserva, LocalDate fechaActual) {
        long diasAnticipacion = ChronoUnit.DAYS.between(fechaActual, fechaReserva);

        if (diasAnticipacion < 2) {
            throw new RuntimeException("Debe cancelar con mínimo 2 días de anticipación");
        }

        dao.cancelarReserva(idReserva, fila, columna, fechaReserva);
    }

    public int calcularHorasDisponibles(int fila, int columna, LocalDate fecha) {
        return dao.calcularHorasDisponibles(fila, columna, fecha);
    }

    public boolean hayDisponibilidad(int fila, int columna, LocalDate fecha, int horas) {
        return dao.hayDisponibilidad(fila, columna, fecha, horas);
    }

    public String obtenerHorasAsignadas(String idReserva, int fila, int columna, LocalDate fecha) {
        return dao.obtenerHorasAsignadas(idReserva, fila, columna, fecha);
    }
    
    public String calcularProximaHoraDisponible(int fila, int columna, LocalDate fecha, int horasNecesarias) {
    if (!daoM.estaRegistrada(fila, columna)) {
        throw new RuntimeException("La máquina no está registrada");
    }
    
    return dao.calcularProximaHoraDisponible(fila, columna, fecha, horasNecesarias);
}

}
