/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author nataliasabogalrada
 */
public interface IDAOUsuario {

    public Usuario login(String usuario, String contrasenia);

    public void agregaCliente(Cliente cliente);
    
    public Usuario buscarCliente(String cedula);
}
