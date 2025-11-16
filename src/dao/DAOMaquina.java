/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import idao.IDAOMaquina;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.EstadoMaquina;
import modelo.Maquina;
import serializadora.Serializadora;

/**
 *
 * @author nataliasabogalrada
 */
public class DAOMaquina implements IDAOMaquina {

    private Maquina[][] maquinas;

    public DAOMaquina() {
        maquinas = Serializadora.getInstance().getMaquinas();
    }

    @Override
    public void agregarMaquina(int fila, int columna, Maquina maquina) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Maquina buscarMaquina(int fila, int columna, String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editarMaquina(int fila, int columna, Maquina maquina) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarMaquinae(int fila, int columna, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Maquina entregarMaquina(int fila, int columna) {
        return maquinas[fila][columna];
    }

    @Override
    public boolean isDisponible(int fila, int columna) {
        return maquinas[fila][columna] == null;
    }

    @Override
    public boolean estaRegistrada(int fila, int columna) {
        return maquinas[fila][columna] != null;

    }

    @Override
    public boolean estaFueraDeServicio(int fila, int columna) {
        Maquina aux = maquinas[fila][columna];
        if (aux.getEstado().equals(EstadoMaquina.FUERADESERVICIO)) {
            return true;
        }
        return false;
    }

}
