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
import util.ILista;

/**
 *
 * @author nataliasabogalrada
 */
public class DAOUsuario implements IDAOUsuario {

    ILista<Usuario> listaUsuarios;

    public DAOUsuario() {
        listaUsuarios = Serializadora.getInstance().getListaUsuarios();
        verificarAdmin();
    }

    private void verificarAdmin() {
        if (listaUsuarios.size() == 0) {
            Usuario admin = new Usuario("123", "Natalia", "320", "123", "123", Rol.ADMINISTRADOR);
            listaUsuarios.add(admin);
            Serializadora.getInstance().escribirListaUsuarios();
        }
    }

    @Override
    public Usuario login(String usuario, String contrasenia) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getUsuario().equals(usuario)
                    && listaUsuarios.get(i).getPassword().equals(contrasenia)) {
                return listaUsuarios.get(i);
            }
        }
        return null;
    }


    @Override
    public ILista<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

}
