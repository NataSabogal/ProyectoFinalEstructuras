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
    
    public Calendario obtenerCalendarioDeMaquina(Maquina maquina, LocalDate fecha);
    
    public boolean validarDisponibilidadHoras(Calendario calendario, int horaInicio, int cantidadHoras);
    
    public int calcularPrimeraHoraDisponible(Calendario calendario, int cantidadHoras);
    
    public Reserva buscarReservaPorId(Calendario calendario, String id);
    
}
