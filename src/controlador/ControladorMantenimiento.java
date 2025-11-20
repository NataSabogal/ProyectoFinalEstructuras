/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DAOMaquina;
import idao.IDAOMaquina;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import modelo.EstadoMaquina;
import modelo.Mantenimiento;

/**
 *
 * @author nataliasabogalrada
 */
public class ControladorMantenimiento {

    IDAOMaquina dao;

    public ControladorMantenimiento() {
        dao = new DAOMaquina();
    }

    public Mantenimiento mostrarDetalleMantenimiento(int fila, int columna) {
        return dao.mostrarDetalleMantenimiento(fila, columna);
    }

    

//    public boolean mantenimientoFinalizado(int fila, int columna) {
//        if (diasRestantes(fila, columna) == 0) {
//            dao.entregarMaquina(fila, columna).setEstado(EstadoMaquina.DISPONIBLE);
//        }
//
//    }

    public boolean mantenimientoFinalizado(int fila, int columna, Mantenimiento mantenimiento) {
        return dao.mantenimientoFinalizado(fila, columna, mantenimiento);
    }

    public int diasRestantes(int fila, int columna, Mantenimiento mantenimiento) {
        return dao.diasRestantes(fila, columna, mantenimiento);
    }

    public void actualizarEstadoMantenimiento(int fila, int columna) {
        dao.actualizarEstadoMantenimiento(fila, columna);
    }

    
}
