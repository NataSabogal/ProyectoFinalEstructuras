/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author nataliasabogalrada
 */
    public class Reserva implements Serializable {
    
    private String id;
    private Cliente cliente;
    private Maquina maquina;
    private LocalDate fecha;
    private int cantidadHorasReserva;

    public Reserva(String id, Cliente cliente, Maquina maquina, LocalDate fecha, int cantidadHorasReserva) {
        this.id = id;
        this.cliente = cliente;
        this.maquina = maquina;
        this.fecha = fecha;
        this.cantidadHorasReserva = cantidadHorasReserva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCantidadHorasReserva() {
        return cantidadHorasReserva;
    }

    public void setCantidadHorasReserva(int cantidadHorasReserva) {
        this.cantidadHorasReserva = cantidadHorasReserva;
    }
    
    
}
