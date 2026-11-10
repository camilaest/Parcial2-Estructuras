package co.edu.uniquindio.pilas_colas;

/**
 * Estructura enlazada genérica Cola. Guarda el nodo de inicio y del final, también su tamaño.
 * @param <T>
 */
public class Cola<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int tam;

    public Cola() {
        inicio = null;
        fin = null;
        tam = 0;
    }

    public void encolar(T dato){
        Nodo nuevo = new Nodo(dato);
        if(estaVacia()){
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        tam++;
    }

    public T desencolar(){
        if (estaVacia()){
            return null;
        }
        T aux = inicio.getDato();
        inicio = inicio.getSiguiente();
        tam --;
        if(inicio == null){
            fin = null;
        }
        return aux;
    }
    public String mostrar() {
        String listaString = "[";
        if (inicio == null) {
            listaString += " Null";
        } else {
            Nodo aux = inicio;
            while (aux != null) {
                listaString += " " + aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        listaString += " ]";
        return listaString;
    }

    public boolean estaVacia(){
        if (inicio == null && fin == null && tam == 0){
            return true;
        }
        return false;
    }
    public int tamanio(){
        return tam;
    }
}
