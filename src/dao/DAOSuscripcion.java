/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import idao.IDAOSuscripcion;
import modelo.Cliente;
import modelo.Suscripcion;
import modelo.Usuario;
import serializadora.Serializadora;
import util.ILista;
import util.Lista;

/**
 *
 * @author nataliasabogalrada
 */
public class DAOSuscripcion implements IDAOSuscripcion {

    private ILista<Usuario> listaUsuarios;

    public DAOSuscripcion() {
        listaUsuarios = Serializadora.getInstance().getListaUsuarios();
    }

    @Override
    public boolean crearSuscripcion(Cliente cliente, Suscripcion suscripcion) {
        Suscripcion activa = obtenerSuscripcionActiva(cliente);
        if (activa == null) {
            cliente.getMisSuscripciones().add(suscripcion);
            Serializadora.getInstance().escribirListaUsuarios();
            return true;
        } else {
            throw new RuntimeException("hay suscripciones activas ");
        }

    }

    @Override
    public Suscripcion obtenerSuscripcionActiva(Cliente cliente) {
        ILista<Suscripcion> suscripciones = cliente.getMisSuscripciones();

        for (int i = 0; i < suscripciones.size(); i++) {
            Suscripcion aux = suscripciones.get(i);
            if (aux.isActiva()) {
                return aux;
            }
        }

        return null;
    }

    @Override
    public ILista<Cliente> obtenerClientesSinSuscripcion() {
        ILista<Cliente> resultado = new Lista<>();

        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario aux = listaUsuarios.get(i);

            if (aux instanceof Cliente) {
                Cliente cliente = (Cliente) aux;

                if (obtenerSuscripcionActiva(cliente) == null) {
                    resultado.add(cliente);
                }
            }
        }

        return resultado;

    }

    @Override
    public ILista<Suscripcion> obtenerHistorialSuscripciones(Cliente cliente) {
        return cliente.getMisSuscripciones();
    }

}
