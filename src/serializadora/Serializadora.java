/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializadora;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Maquina;
import modelo.Usuario;
import util.ILista;
import util.Lista;
/**
 *
 * @author nataliasabogalrada
 */
public class Serializadora {

    private static final Serializadora instance = new Serializadora();
    
    private ILista<Usuario> listaUsuarios;

    private Maquina[][] maquinas;

    public Serializadora() {
        this.maquinas = leerMaquina();
        this.listaUsuarios = leerListausuarios();
    }

    public static Serializadora getInstance() {
        return instance;
    }

    public Maquina[][] getMaquinas() {
        return maquinas;
    }

    public ILista<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    
    
    public void escribirMaquina() {
        try {
            FileOutputStream archivo = new FileOutputStream("src/serializadora/matrizMaquinas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(maquinas);
            escritor.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Maquina[][] leerMaquina() {

        try {
            FileInputStream archivo = new FileInputStream("src/serializadora/matrizMaquinas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            Maquina[][] maq = (Maquina[][]) lector.readObject();
            lector.close();
            return maq;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            maquinas = new Maquina[3][4];
            for (int i = 0; i < maquinas.length; i++) {
                for (int j = 0; j < maquinas[i].length; j++) {
                    maquinas[i][j] = new Maquina();
                }
            }

            return maquinas;
        }
    }
    
    public void escribirListaUsuarios() {
        try {
            FileOutputStream archivo = new FileOutputStream("src/serializadora/usuarios.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaUsuarios);
            escritor.close();

        } catch (IOException e) {
            e.getMessage();
        }
    }

    public ILista<Usuario> leerListausuarios() {
        try {
            FileInputStream archivo = new FileInputStream("src/serializadora/usuarios.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            ILista<Usuario> lista = (ILista<Usuario>) lector.readObject();
            lector.close();
            return lista;
        } catch (IOException | ClassNotFoundException ex) {
            return new Lista<>();
        }
    }
}
