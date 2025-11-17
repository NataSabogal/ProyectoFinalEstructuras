/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DAOUsuario;
import idao.IDAOUsuario;
import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author nataliasabogalrada
 */
public class ControladorRegistroCliente {

    IDAOUsuario dao;

    public ControladorRegistroCliente() {
        dao = new DAOUsuario();

    }

    public void agregaCliente(Cliente cliente) {
        for (int i = 0; i < dao.getListaUsuarios().size(); i++) {
            Usuario u = dao.getListaUsuarios().get(i);
            if (cliente.getCedula().equals(u.getCedula()) || cliente.getUsuario().equals(u.getUsuario()) || cliente.getPassword().equals(u.getPassword())) {
                throw new RuntimeException("Usuario o contraseña ya existen");
            }
        }
        dao.agregaCliente(cliente);

    }

    public Usuario buscarCliente(String cedula) {
        return dao.buscarCliente(cedula);
    }

}
