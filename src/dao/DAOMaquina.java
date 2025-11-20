/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import idao.IDAOMaquina;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.EstadoMaquina;
import modelo.Mantenimiento;
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
        if (maquinas[fila][columna] == null || maquinas[fila][columna].getEstado() == EstadoMaquina.DISPONIBLE) {
            maquinas[fila][columna] = maquina;
            maquina.setEstado(EstadoMaquina.REGISTRADO);
            Serializadora.getInstance().escribirMaquina();
        }
    }

    @Override
    public Maquina buscarMaquina(int fila, int columna, String codigo) {
        Maquina aux = maquinas[fila][columna];
        if (aux != null && aux.getId().equals(codigo)) {
            return aux;
        }
        return null;

    }

    @Override
    public void editarMaquina(int fila, int columna, Maquina maquina) {
        Maquina aux = buscarMaquina(fila, columna, maquina.getId());
        if (aux.getId().equals(maquina.getId()) && aux.getEstado().equals(EstadoMaquina.REGISTRADO)) {

            aux.setEdadMinima(maquina.getEdadMinima());
            aux.setGenero(maquina.getGenero());
            aux.setTipoDeJuego(maquina.getTipoDeJuego());
            aux.setValorPorHora(maquina.getValorPorHora());
            //maquina.setEstado(EstadoMaquina.REGISTRADO);
            Serializadora.getInstance().escribirMaquina();
        }
    }

    @Override
    public void eliminarMaquinae(int fila, int columna, String id) {
        Maquina m = maquinas[fila][columna];

        if (m != null && m.getId().equals(id)) {
            maquinas[fila][columna] = null;
            Serializadora.getInstance().escribirMaquina();
        }
    }

    @Override
    public Maquina entregarMaquina(int fila, int columna) {
        return maquinas[fila][columna];
    }

    @Override
    public boolean isDisponible(int fila, int columna) {
        Maquina aux = maquinas[fila][columna];
        return aux == null
                || aux.getEstado() == null
                || aux.getEstado() == EstadoMaquina.DISPONIBLE;
    }

    @Override
    public boolean estaRegistrada(int fila, int columna) {
        Maquina aux = maquinas[fila][columna];
        return aux != null
                && aux.getEstado() != null
                && aux.getEstado() == EstadoMaquina.REGISTRADO;

    }

    @Override
    public boolean estaFueraDeServicio(int fila, int columna) {
        Maquina aux = maquinas[fila][columna];
        return aux != null
                && aux.getEstado() != null
                && aux.getEstado() == EstadoMaquina.FUERADESERVICIO;

    }

    @Override
    public Maquina maquinaFuerdaDeServicio(int fila, int columna, Mantenimiento mantenimiento) {
        Maquina aux = maquinas[fila][columna];
        if (aux.getEstado().equals(EstadoMaquina.REGISTRADO) && mantenimiento.getRazonFueraDeServicio() != null && (!(mantenimiento.getCantidadDiasFueraDeServicio() == 0))) {
            aux.setEstado(EstadoMaquina.FUERADESERVICIO);
            aux.setMantenimiento(mantenimiento);
            Serializadora.getInstance().escribirMaquina();

            return aux;
        }

        throw new RuntimeException("algo salió mal");
    }

    @Override
    public Mantenimiento mostrarDetalleMantenimiento(int fila, int columna) {
        return entregarMaquina(fila, columna).getMantenimiento();

    }

    @Override
    public boolean mantenimientoFinalizado(int fila, int columna, Mantenimiento mantenimiento) {
        Maquina aux = maquinas[fila][columna];
        if (mantenimiento.diasRestantes() == 0) {
            aux.setEstado(EstadoMaquina.REGISTRADO);
            return true;
        }
        return false;
    }

    @Override
    public int diasRestantes(int fila, int columna, Mantenimiento mantenimiento) {
        Mantenimiento aux = maquinas[fila][columna].getMantenimiento();
        return aux.diasRestantes();

    }

    @Override
    public void actualizarEstadoMantenimiento(int fila, int columna) {
        Maquina aux = maquinas[fila][columna];
        if (aux.getMantenimiento() != null && aux.getMantenimiento().diasRestantes() == 0) {
            aux.setEstado(EstadoMaquina.REGISTRADO);
            aux.setMantenimiento(null);
        }
    }

}
