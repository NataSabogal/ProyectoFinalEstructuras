/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import idao.IDAOCliente;
import modelo.Cliente;
import modelo.Usuario;
import serializadora.Serializadora;
import util.ILista;
import util.Lista;

/**
 *
 * @author nataliasabogalrada
 */
public class DAOCliente implements IDAOCliente {

    ILista<Usuario> listaClientes;

    public DAOCliente() {
        listaClientes = Serializadora.getInstance().getListaUsuarios();
    }

    @Override
    public void agregaCliente(Cliente cliente) {
        Usuario aux = buscarCliente(cliente.getCedula());
        if (aux == null) {
            listaClientes.add(cliente);
            Serializadora.getInstance().escribirListaUsuarios();
            return;
        }

    }

    @Override
    public Cliente buscarCliente(String cedula) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i) instanceof Cliente && listaClientes.get(i).getCedula().equals(cedula)) {
                Cliente cliente = (Cliente) listaClientes.get(i);
                return cliente;
            }
        }
        return null;
    }

    @Override
    public ILista<Cliente> getListaUsuarios() {
        Lista<Cliente> clientes = new Lista<>();
        return clientes;
    }

}
