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
import util.Lista;

/**
 *
 * @author nataliasabogalrada
 */
public class DAOReserva implements IDAOReserva {

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
    public boolean validarDisponibilidadHoras(Calendario calendario, int horaInicio, int cantidadHoras) {
//        if (horaInicio < 0 || horaInicio + cantidadHoras > 8) {
//            return false;
//        }
        return true;

    }

    @Override
    public int calcularPrimeraHoraDisponible(Calendario calendario, int cantidadHoras) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reserva buscarReservaPorId(Calendario calendario, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
