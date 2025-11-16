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
public interface IQueue<T> extends Serializable {

    public void enQueue(T dato);

    public T deQueue();

    public T peek();

    public boolean isEmpty();

    public T peekLast();

    public void remove(T dato);


}
