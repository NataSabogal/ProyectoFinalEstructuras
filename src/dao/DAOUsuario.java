/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import idao.IDAOUsuario;
import modelo.Cliente;
import modelo.Rol;
import modelo.Usuario;
import serializadora.Serializadora;
import util.Lista;

/**
 *
 * @author nataliasabogalrada
 */
public class DAOUsuario implements IDAOUsuario {

    Lista<Usuario> listaUsuarios;

    public DAOUsuario() {
        listaUsuarios = Serializadora.getInstance().getListaUsuarios();
    }

    Usuario admin = new Usuario("123", "Natalia", "320", "123", "123", Rol.ADMINISTRADOR);

    @Override
    public Usuario login(String usuario, String contrasenia) {
        if (usuario.equals(admin.getUsuario()) && contrasenia.equals(admin.getPassword())) {
            return admin;
        } else {
            for (int i = 0; i < listaUsuarios.size(); i++) {
                if (listaUsuarios.get(i).getUsuario().equals(usuario) && listaUsuarios.get(i).getPassword().equals(contrasenia)) {
                    return listaUsuarios.get(i);
                }
            }
            return null;
        }
    }

    @Override
    public void agregaCliente(Cliente cliente) {
        Usuario aux = buscarCliente(cliente.getCedula());
        if (aux == null) {
            listaUsuarios.add(cliente);
            Serializadora.getInstance().escribirListaUsuarios();
            return;
        }
        throw new RuntimeException("El usuario no existe");

    }

    @Override
    public Usuario buscarCliente(String cedula) {
         for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getCedula().equals(cedula)) {
                return listaUsuarios.get(i);
            }
        }
        return null;
    }

}
