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
public class Accion implements Serializable {
    
    private EstadoAccion estado;
    private Maquina maquina;

    public Accion(EstadoAccion estado, Maquina maquina) {
        this.estado = estado;
        this.maquina = maquina;
    }

    public EstadoAccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoAccion estado) {
        this.estado = estado;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }
    
    
    
}
