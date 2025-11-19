/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import modelo.Cliente;
import modelo.Suscripcion;
import util.ILista;

/**
 *
 * @author nataliasabogalrada
 */
public interface IDAOSuscripcion {

    public boolean crearSuscripcion(Cliente cliente, Suscripcion suscripcion);

    public Suscripcion obtenerSuscripcionActiva(Cliente cliente);
    
    public ILista<Cliente> obtenerClientesSinSuscripcion();
    
    public ILista<Suscripcion> obtenerHistorialSuscripciones(Cliente cliente);
}
