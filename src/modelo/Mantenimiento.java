/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author nataliasabogalrada
 */
public class Mantenimiento implements Serializable {
    
    private String razonFueraDeServicio;
    private int cantidadDiasFueraDeServicio;

    public Mantenimiento(String razonFueraDeServicio, int cantidadDiasFueraDeServicio) {
        this.razonFueraDeServicio = razonFueraDeServicio;
        this.cantidadDiasFueraDeServicio = cantidadDiasFueraDeServicio;
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

    
}
