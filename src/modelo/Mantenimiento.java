/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author nataliasabogalrada
 */
public class Mantenimiento implements Serializable {
    
    private String razonFueraDeServicio;
    private int cantidadDiasFueraDeServicio;
    private LocalDate fechaInicio;

    public Mantenimiento(String razonFueraDeServicio, int cantidadDiasFueraDeServicio) {
        this.razonFueraDeServicio = razonFueraDeServicio;
        this.cantidadDiasFueraDeServicio = cantidadDiasFueraDeServicio;
        this.fechaInicio = LocalDate.now();
    }

    public String getRazonFueraDeServicio() {
        return razonFueraDeServicio;
    }

    public void setRazonFueraDeServicio(String razonFueraDeServicio) {
        this.razonFueraDeServicio = razonFueraDeServicio;
    }

    public int getCantidadDiasFueraDeServicio() {
        return cantidadDiasFueraDeServicio;
    }

    public void setCantidadDiasFueraDeServicio(int cantidadDiasFueraDeServicio) {
        this.cantidadDiasFueraDeServicio = cantidadDiasFueraDeServicio;
    }

    public int diasRestantes() {
        LocalDate fechaFin = fechaInicio.plusDays(cantidadDiasFueraDeServicio);
        if (fechaInicio.isAfter(fechaFin)) {
            return 0;
        } else {
            long restan = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
            return (int) restan;
        }
    }
    
}
