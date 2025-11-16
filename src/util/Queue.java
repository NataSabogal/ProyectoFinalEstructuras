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
public class Queue<T> implements IQueue<T>, Serializable {

    private Nodo<T> primero;
    private int size;

    public Queue() {
        this.primero = null;
        this.size = 0;
    }

    @Override
    public void enQueue(T dato) {
        Nodo<T> nuevo = new Nodo<T>(dato);

        if (isEmpty()) {
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);

        }
        size++;

    }

    @Override
    public T deQueue() {
        if (!isEmpty()) {
            Nodo<T> aux = primero;
            primero = primero.getSiguiente();
            size--;
            return aux.getDato();

        } else {
            throw new RuntimeException("Lista vacia");
        }

    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return primero.getDato();

        } else {
            throw new RuntimeException("Lista vacia");
        }
    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }

    @Override
    public T peekLast() {
        if (!isEmpty()) {
            Nodo<T> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            return aux.getDato();
        } else {
            throw new RuntimeException("Lista Vacia");
        }
    }

    @Override
    public void remove(T dato) { 
        if (!isEmpty()) {
            Queue<T> otraCola = new Queue<>();
            while (!isEmpty()) {
                Nodo<T> actual = primero;
                if (!actual.getDato().equals(dato)) {
                    otraCola.enQueue(actual.getDato());
                    deQueue();
                } else {
                    deQueue();
                }
            }
            primero = otraCola.primero;
            size = otraCola.size;
        }

    }

   
}
