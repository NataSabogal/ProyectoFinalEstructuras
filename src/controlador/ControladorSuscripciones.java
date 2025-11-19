/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DAOCliente;
import dao.DAOSuscripcion;
import dao.DAOUsuario;
import idao.IDAOCliente;
import idao.IDAOSuscripcion;
import idao.IDAOUsuario;
import modelo.Cliente;
import modelo.Suscripcion;
import modelo.Usuario;
import util.ILista;

/**
 *
 * @author nataliasabogalrada
 */
public class ControladorSuscripciones {
    
   //TENGO QUE TENER DOS DAO PARA VERFICAR SI SI HAY CLIENTE REGISTRADO Y EL OTRO ES PARA HACER LA GESTION 
    
    IDAOCliente daoCliente;
    IDAOSuscripcion daoSus;

    public ControladorSuscripciones() {
        daoCliente = new DAOCliente();
        daoSus = new DAOSuscripcion();
    }

    public Cliente buscarCliente(String cedula) {
        return daoCliente.buscarCliente(cedula);
    }

    public boolean crearSuscripcion(String cedula, Suscripcion suscripcion) {
        Cliente cliente = buscarCliente(cedula);
        return daoSus.crearSuscripcion(cliente, suscripcion);
    }

    public Suscripcion obtenerSuscripcionActiva(Cliente cliente) {
        return daoSus.obtenerSuscripcionActiva(cliente);
    }

    public ILista<Cliente> obtenerClientesSinSuscripcion() {
        return daoSus.obtenerClientesSinSuscripcion();
    }

    public ILista<Suscripcion> obtenerHistorialSuscripciones(Cliente cliente) {
        return daoSus.obtenerHistorialSuscripciones(cliente);
    }
    
}
