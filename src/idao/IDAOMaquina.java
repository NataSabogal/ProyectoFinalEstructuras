/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Maquina;

/**
 *
 * @author nataliasabogalrada
 */
public interface IDAOMaquina {
    
    public void agregarMaquina(int fila, int columna, Maquina maquina);
    
    public Maquina buscarMaquina(int fila, int columna, String codigo);
    
    public void editarMaquina(int fila, int columna, Maquina maquina);
    
    public void eliminarMaquinae(int fila, int columna, String id);
            
    public Maquina entregarMaquina(int fila, int columna);
        
    public boolean isDisponible (int fila, int columna);
        
    public boolean estaRegistrada (int fila, int columna);
    
    public boolean estaFueraDeServicio (int fila, int columna);

}
