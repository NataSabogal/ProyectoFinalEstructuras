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
    private Lista<Suscripcion> misSuscripciones;
    private Lista<Reserva> reservasSinSuscripcion;
    private double totalInvertido;

    public Cliente(int edad, String cedula, String nombre, String telefono, String usuario, String password, Rol rol) {
        super(cedula, nombre, telefono, usuario, password, rol);
        this.edad = edad;
        this.misSuscripciones = new Lista<>();
        this.reservasSinSuscripcion = new Lista<>();
        
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Lista<Suscripcion> getMisSuscripciones() {
        return misSuscripciones;
    }

    public void setMisSuscripciones(Lista<Suscripcion> misSuscripciones) {
        this.misSuscripciones = misSuscripciones;
    }

    public Lista<Reserva> getReservasSinSuscripcion() {
        return reservasSinSuscripcion;
    }

    public void setReservasSinSuscripcion(Lista<Reserva> reservasSinSuscripcion) {
        this.reservasSinSuscripcion = reservasSinSuscripcion;
    }

    public double getTotalInvertido() {
        return totalInvertido;
    }

    public void setTotalInvertido(double totalInvertido) {
        this.totalInvertido = totalInvertido;
    }
}
