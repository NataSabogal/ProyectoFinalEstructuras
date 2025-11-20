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
public class Maquina implements Serializable {

    private String id;
    private String tipoDeJuego;
    private String genero;
    private int edadMinima;
    private EstadoMaquina estado;
    private double valorPorHora;
    private Mantenimiento mantenimiento;
    private Lista<Calendario> reservasPorDias;

    public Maquina() {
        this.id = null;
        this.tipoDeJuego = null;
        this.genero = null;
        this.edadMinima = 0;
        this.estado = EstadoMaquina.DISPONIBLE;
        this.valorPorHora = 0.0;
        this.reservasPorDias = new Lista<>();

    }

    public Maquina(String id, String tipoDeJuego, String genero, int edadMinima, double valorPorHora) {
        this.id = id;
        this.tipoDeJuego = tipoDeJuego;
        this.genero = genero;
        this.edadMinima = edadMinima;
        this.estado = EstadoMaquina.DISPONIBLE;
        this.valorPorHora = valorPorHora;
        this.reservasPorDias = new Lista<>();
    }

    public Maquina(String id, String tipoDeJuego, String genero, int edadMinima, EstadoMaquina estado, double valorPorHora, Mantenimiento mantenimiento) {
        this.id = id;
        this.tipoDeJuego = tipoDeJuego;
        this.genero = genero;
        this.edadMinima = edadMinima;
        this.estado = EstadoMaquina.FUERADESERVICIO;
        this.valorPorHora = valorPorHora;
        this.mantenimiento = mantenimiento;
        this.reservasPorDias = new Lista<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoDeJuego() {
        return tipoDeJuego;
    }

    public void setTipoDeJuego(String tipoDeJuego) {
        this.tipoDeJuego = tipoDeJuego;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public EstadoMaquina getEstado() {
        return estado;
    }

    public void setEstado(EstadoMaquina estado) {
        this.estado = estado;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public boolean estaDisponible() {
        return estado == EstadoMaquina.DISPONIBLE;
    }

    public boolean maquinaRegistrada() {
        return estado == EstadoMaquina.REGISTRADO;

    }

    public boolean fueraDeServicio() {
        return estado == EstadoMaquina.FUERADESERVICIO;
    }

    public Lista<Calendario> getReservasPorDias() {
        return reservasPorDias;
    }
    
    
}
