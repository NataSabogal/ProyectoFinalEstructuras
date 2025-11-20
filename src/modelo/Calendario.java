/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import util.Lista;
import util.Queue;

/**
 *
 * @author nataliasabogalrada
 */
public class Calendario implements Serializable{
    
    private LocalDate fecha;
    private Lista<Reserva> listaReservas;
    private Queue<Reserva> colaReserva;

    public Calendario(LocalDate fecha) {
        this.fecha = fecha;
        this.listaReservas = new Lista<>();
        this.colaReserva = new Queue<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Lista<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(Lista<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public Queue<Reserva> getColaReserva() {
        return colaReserva;
    }

    public void setColaReserva(Queue<Reserva> colaReserva) {
        this.colaReserva = colaReserva;
    }
    
    public int calcularHorasTotalesReservadas() {
        int total = 0;
        for (int i = 0; i < listaReservas.size(); i++) {
            total += listaReservas.get(i).getCantidadHorasReserva();
        }
        return total;
    }
    
    public boolean tieneEspacioDisponible(int horasNecesarias) {
        int horasOcupadas = calcularHorasTotalesReservadas();
        return (horasOcupadas + horasNecesarias) <= 8;
    }
    
    
    
}
