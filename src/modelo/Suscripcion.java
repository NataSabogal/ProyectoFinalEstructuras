/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import util.Lista;

/**
 *
 * @author nataliasabogalrada
 */
public class Suscripcion implements Serializable {
    private String id;
    private TipoSuscripcion tipo;
    private LocalDate fechaInicio;
    private double precioBase;
    private double precioFinal;
    private int horasIncluidas;
    private int horasUsadas;
    private double costoHorasExtras;
    private boolean activa;
    private Lista<Reserva> reservaDeLaSuscripcion;

    public Suscripcion(String id, TipoSuscripcion tipo, int horasIncluidas, LocalDate fechaInicio, double precioBase) {
        this.id = id;
        this.tipo = tipo;
        this.horasIncluidas = horasIncluidas;
        this.fechaInicio = fechaInicio;
        this.precioBase = precioBase;
        this.activa = true;
        this.reservaDeLaSuscripcion = new Lista<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoSuscripcion getTipo() {
        return tipo;
    }

    public void setTipo(TipoSuscripcion tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public int getHorasIncluidas() {
        return horasIncluidas;
    }

    public void setHorasIncluidas(int horasIncluidas) {
        this.horasIncluidas = horasIncluidas;
    }

    public int getHorasUsadas() {
        return horasUsadas;
    }

    public void setHorasUsadas(int horasUsadas) {
        this.horasUsadas = horasUsadas;
    }

    public double getCostoHorasExtras() {
        return costoHorasExtras;
    }

    public void setCostoHorasExtras(double costoHorasExtras) {
        this.costoHorasExtras = costoHorasExtras;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    
    
    
}
