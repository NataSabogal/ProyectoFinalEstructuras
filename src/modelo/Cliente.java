/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import util.Lista;

/**
 *
 * @author nataliasabogalrada
 */
public class Cliente extends Usuario implements Serializable {

    private int edad;
    private Lista<Suscripcion> historialSuscripciones;
    private Lista<Reserva> reservasDelCliente;
    private double totalInvertido;

    public Cliente(int edad, double totalInvertido, String cedula, String nombre, String telefono, String usuario, String password, Rol rol) {
        super(cedula, nombre, telefono, usuario, password, rol);
        this.edad = edad;
        this.historialSuscripciones = new Lista<>();
        this.reservasDelCliente = new Lista<>();
        this.totalInvertido = totalInvertido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Lista<Suscripcion> getHistorialSuscripciones() {
        return historialSuscripciones;
    }

    public void setHistorialSuscripciones(Lista<Suscripcion> historialSuscripciones) {
        this.historialSuscripciones = historialSuscripciones;
    }

    public Lista<Reserva> getReservasDelCliente() {
        return reservasDelCliente;
    }

    public void setReservasDelCliente(Lista<Reserva> reservasDelCliente) {
        this.reservasDelCliente = reservasDelCliente;
    }

    public double getTotalInvertido() {
        return totalInvertido;
    }

    public void setTotalInvertido(double totalInvertido) {
        this.totalInvertido = totalInvertido;
    }

    
    
    
}
