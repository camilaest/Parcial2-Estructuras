package co.edu.uniquindio.pilas_colas;

import java.util.Iterator;

/**
 * Pila genérica con métodos de agregación y eliminación (apilar y desapilar)
 * Incluye método para mostrar su contenido, determinar si está vacía y saber su tamaño
 * @param <T>
 */
public class Pila<T> implements Iterable<T> {
    private Nodo<T> cima;
    private int tam;

    public Pila() {
        cima = null;
        tam = 0;
    }

    public void apilar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
        tam++;
    }

    public T desapilar() {
        if (estaVacia()){
            return null;
        }
        T dato = cima.getDato();
        cima = cima.getSiguiente();
        tam--;
        return dato;
    }

    public int tamanio(){
        return tam;
    }

    public boolean estaVacia() {
        if(cima == null && tam == 0){
            return true;
        }
        return false;
    }
    public String mostrar() {
        String listaString = "[";
        if (cima == null) {
            listaString += " Null";
        } else {
            Nodo<T> aux = cima;
            while (aux != null) {
                listaString += " " + aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        listaString += " ]";
        return listaString;
    }


    @Override
    public Iterator<T> iterator() {
        return new PilaIterator();
    }
    private class PilaIterator implements Iterator<T> {
        Nodo<T> actual = cima;
        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                return null;
            }
            T valor = actual.getDato();
            actual = actual.getSiguiente();
            return valor;
        }
    }
}
