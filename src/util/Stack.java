/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author nataliasabogalrada
 */
public class Stack<T> implements IStack<T>, Serializable {

    private Nodo<T> primero;
    private int size;

    @Override
    public void push(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(primero);
        primero = nuevoNodo;
        size++;

    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            Nodo<T> observador = primero;
            primero = primero.getSiguiente();
            size--;
            return observador.getDato();
        } else {
            throw new IllegalStateException("La pila está vacia");
        }
    }

    @Override
    public T top() {
        if (!isEmpty()) {
            return primero.getDato();
        } else {
            throw new IllegalStateException("La pila está vacia");
        }
    }

    @Override
    public int size() {
        return size;
    }

}
