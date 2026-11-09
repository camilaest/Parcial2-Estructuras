package co.edu.uniquindio.pilas_colas;

import java.util.Iterator;

public class Pila<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new PilaIterator();
    }

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
    public int localizar(T datoBuscar) {
        Nodo<T> aux = cima;
        int count = 0;
        while (aux != null) {
            if (aux.getDato().equals(datoBuscar)) {
                return count;
            }
            count++;
            aux = aux.getSiguiente();
        }
        return -1;
    }
    public boolean buscar(T datoBuscar) {
        Nodo<T> aux = cima;
        while (aux != null) {

            if (aux.getDato().equals(datoBuscar)) {
                return true;
            }
            aux = aux.getSiguiente();
        }

        return false;
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
