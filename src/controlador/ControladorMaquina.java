/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DAOMaquina;
import idao.IDAOMaquina;
import modelo.Mantenimiento;
import modelo.Maquina;

/**
 *
 * @author nataliasabogalrada
 */
public class ControladorMaquina {

    IDAOMaquina dao;

    public ControladorMaquina() {
        dao = new DAOMaquina();
    }

    public boolean agregarMaquina(int fila, int columna, Maquina maquina) {
        if (maquina != null) {
            dao.agregarMaquina(fila, columna, maquina);
            return true;
        }

        throw new RuntimeException("algo pasó mal");

    }

    public Maquina buscarMaquina(int fila, int columna, String codigo) {
        return dao.buscarMaquina(fila, columna, codigo);
    }

    public void editarMaquina(int fila, int columna, Maquina maquina) {
        dao.editarMaquina(fila, columna, maquina);
    }

    public void eliminarMaquinae(int fila, int columna, String id) {
        dao.eliminarMaquinae(fila, columna, id);
    }

    public Maquina maquinaFuerdaDeServicio(int fila, int columna, Mantenimiento mantenimiento) {

        return dao.maquinaFuerdaDeServicio(fila, columna, mantenimiento);

    }

    public boolean estaRegistrada(int fila, int columna) {
        return dao.estaRegistrada(fila, columna);
    }
    
    

}
