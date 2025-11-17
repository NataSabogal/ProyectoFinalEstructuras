/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DAOUsuario;
import idao.IDAOUsuario;
import modelo.Usuario;

/**
 *
 * @author nataliasabogalrada
 */
public class ControladorSuscripciones {
    
   //TENGO QUE TENER DOS DAO PARA VERFICAR SI SI HAY CLIENTE REGISTRADO Y EL OTRO ES PARA HACER LA GESTION 
    
    IDAOUsuario daoUser;

    public ControladorSuscripciones() {
        daoUser = new DAOUsuario();
    }

    public Usuario buscarCliente(String cedula) {
        return daoUser.buscarCliente(cedula);
    }
    
    
    
}
