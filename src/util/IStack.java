/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author nataliasabogalrada
 */
public interface IStack<T> extends Serializable {

    public boolean isEmpty();

    public void push(T dato);

    public T pop();

    public T top();

    public int size();

    

}
