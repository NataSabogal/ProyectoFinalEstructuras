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
public class ControladorLogIn {
    
    IDAOUsuario dao;

    public ControladorLogIn() {
        dao = new DAOUsuario();
    }

    public Usuario login(String usuario, String contrasenia) {
        return dao.login(usuario, contrasenia);
    }
    
     
}
