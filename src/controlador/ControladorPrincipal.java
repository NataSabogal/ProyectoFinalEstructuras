/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DAOMaquina;
import idao.IDAOMaquina;
import modelo.Maquina;

/**
 *
 * @author nataliasabogalrada
 */
public class ControladorPrincipal {
    
    IDAOMaquina dao;

    public ControladorPrincipal() {
        dao = new DAOMaquina();
    }

    public Maquina entregarMaquina(int fila, int columna) {
        return dao.entregarMaquina(fila, columna);
    }

    public boolean isDisponible(int fila, int columna) {
        return dao.isDisponible(fila, columna);
    }

    public boolean estaRegistrada(int fila, int columna) {
        return dao.estaRegistrada(fila, columna);
    }

    public boolean estaFueraDeServicio(int fila, int columna) {
        return dao.estaFueraDeServicio(fila, columna);
    }
    
    
    
    
}
